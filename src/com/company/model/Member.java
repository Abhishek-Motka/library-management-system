package com.company.model;

import com.company.utils.DateUtils;
import com.company.enums.AccountStatus;
import com.company.exceptions.AccountSuspendedException;
import com.company.exceptions.BookAlreadyIssudException;
import com.company.exceptions.BookNotFoundException;
import com.company.exceptions.BookNotIssuedByMemberException;
import com.company.strategies.SearchByBarcodeStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Member extends Person
{
    private String id;
    private AccountStatus accountStatus;
    private List<BookItem> booksIssued;
    private List<Fine> fines;

    public Member(String name, ContactInfo contactInfo)
    {
        super(name, contactInfo);
        this.id = UUID.randomUUID().toString();
        this.accountStatus = AccountStatus.ACTIVE;
        this.booksIssued = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public AccountStatus getAccountStatus()
    {
        return accountStatus;
    }

    public List<BookItem> getBooksIssued()
    {
        return booksIssued;
    }

    public String getId()
    {
        return id;
    }

    public void setAccountStatus(AccountStatus accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public void lendBook(String barCode, int days) {
        if (accountStatus.equals(AccountStatus.BLOCKED)) throw new AccountSuspendedException();
        BookCatalog catalog = BookRepository.getInstance();
        Optional<BookItem> bookItemOptional = catalog.searchByBarcode(barCode);
        if (!bookItemOptional.isPresent()) throw new BookNotFoundException();
        BookItem bookItem = bookItemOptional.get();
        if (bookItem.isIssued()) throw new BookAlreadyIssudException();
        bookItem.markAsIssued(days);
        booksIssued.add(bookItem);
    }

    public void returnBook(String barCode) {
        Optional<BookItem> bookItemOptional =
                booksIssued.stream().filter(new SearchByBarcodeStrategy(barCode)::filter).findFirst();
        if (!bookItemOptional.isPresent()) throw new BookNotIssuedByMemberException();
        BookItem bookItem = bookItemOptional.get();
        Optional<Fine> fineOptional = calculateFine(bookItem);
        if (fineOptional.isPresent()) this.fines.add(fineOptional.get());
        bookItem.markAsAvailable();
        booksIssued.remove(bookItem);
    }

    public double dueFineAmount() {
        return dueFines().stream()
                .map(Fine::getFineAmount)
                .reduce(0d, (a, b) -> a + b);
    }

    public List<Fine> dueFines() {
        return this.fines.stream()
                .filter(fine -> Objects.isNull(fine.getPaidDate()))
                .collect(Collectors.toList());
    }

    public void payFine() {
        for (Fine fine : fines) fine.setPaidDate(new Date());
    }

    public Optional<Fine> calculateFine(BookItem bookItem) {
        Date today = new Date();
        if (today.compareTo(bookItem.getDueDate()) <= 0) return Optional.empty();
        double fineAmount = DateUtils.diffInDays(bookItem.getDueDate(), today) * Constants.FINE_AMOUNT_PER_DAY;
        Fine fine = new Fine(bookItem.getBarCode(), fineAmount);
        return Optional.of(fine);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Member && this.id.equals(((Member) obj).getId());
    }
}
