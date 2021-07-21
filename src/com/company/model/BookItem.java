package com.company.model;

import com.company.utils.DateUtils;
import com.company.enums.BookCategory;
import com.company.enums.BookStatus;
import com.company.exceptions.BookIsNotIssuedException;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookItem extends Book
{
    private String barCode;
    private BookStatus bookStatus;
    private Date issueDate;
    private Date dueDate;
    private Rack rack;
    private boolean isIssued;

    public BookItem(String ISBN,
                    String title,
                    BookCategory category,
                    List<Author> authors,
                    String description,
                    Date publishedDate,
                    int noOfPages,
                    String barCode,
                    Rack rack)
    {
        super(ISBN, title, category, authors, description, publishedDate, noOfPages);
        this.barCode = barCode;
        this.rack = rack;
        this.bookStatus = BookStatus.AVAILABLE;
        this.isIssued = false;
    }

    public String getBarCode()
    {
        return barCode;
    }

    public BookStatus getBookStatus()
    {
        return bookStatus;
    }

    public Date getIssueDate()
    {
        if (!isIssued) throw new BookIsNotIssuedException(this);
        return issueDate;
    }

    public Date getDueDate()
    {
        if (!isIssued) throw new BookIsNotIssuedException(this);
        return dueDate;
    }

    public Rack getRack()
    {
        return rack;
    }

    public void placeAt(Rack rack)
    {
        this.rack = rack;
    }

    public boolean isIssued()
    {
        return isIssued;
    }

    public void markAsIssued(int days) {
        this.isIssued = true;
        this.bookStatus = BookStatus.ISSUED;
        this.issueDate = new Date();
        this.dueDate = DateUtils.dateAfterDays(days);
    }

    public void markAsAvailable() {
        this.issueDate = null;
        this.dueDate = null;
        this.isIssued = false;
        this.bookStatus = BookStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (Objects.isNull(obj) || ! (obj instanceof BookItem)) return false;
        return this.barCode.equals(((BookItem) obj).getBarCode());
    }
}
