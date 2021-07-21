package com.company.model;

import com.company.enums.BookCategory;
import com.company.strategies.*;

import java.util.*;
import java.util.stream.Collectors;

public class BookRepository implements BookCatalog
{
    private static BookRepository catalog;
    private Set<BookItem> bookItems;

    private BookRepository()
    {
        this.bookItems = new HashSet<>();
    }

    public static BookRepository getInstance() {
        if (catalog != null) return catalog;
        if (catalog == null) {
            synchronized (BookRepository.class) {
                if (catalog == null) {
                    catalog = new BookRepository();
                }
            }
        }
        return catalog;
    }

    public void addBookItem(BookItem bookItem) {
        this.bookItems.add(bookItem);
    }

    public void addBookItems(List<BookItem> bookItems) {
        this.bookItems.addAll(bookItems);
    }

    public void removeBookItem(BookItem bookItem) {
        this.bookItems.remove(bookItem);
    }

    public void removeBookItem(String barCode) {

    }

    @Override
    public List<BookItem> searchByTitle(String title)
    {
        return search(new SearchByTitleStrategy(title));
    }

    @Override
    public List<BookItem> searchByISBN(String ISBN)
    {
        return search(new SearchByISBNStrategy(ISBN));
    }

    @Override
    public List<BookItem> searchByPublicationDate(Date publicationDate)
    {
        return search(new SearchByPublicationDateStrategy(publicationDate));
    }

    @Override
    public List<BookItem> searchByCategory(BookCategory category)
    {
        return search(new SearchByCategoryStrategy(category));
    }

    @Override
    public List<BookItem> searchByAuthor(Author author)
    {
        return search(new SearchByAuthorStrategy(author));
    }

    @Override
    public Optional<BookItem> searchByBarcode(String barcode)
    {
        List<BookItem> bookItems = search(new SearchByBarcodeStrategy(barcode));
        return bookItems.size() > 0 ? Optional.of(bookItems.get(0)) : Optional.empty();
    }

    public List<BookItem> search(SearchStrategy searchStrategy) {
        return bookItems.stream().filter(searchStrategy::filter).collect(Collectors.toList());
    }
}
