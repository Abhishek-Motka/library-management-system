package com.company.model;

import com.company.enums.BookCategory;

import java.util.Date;
import java.util.List;

public class Book
{
    private String ISBN;
    private String title;
    private BookCategory category;
    private List<Author> authors;
    private String description;
    private Date publishedDate;
    private int noOfPages;

    public Book(String ISBN,
                String title,
                BookCategory category,
                List<Author> authors,
                String description,
                Date publishedDate, int noOfPages)
    {
        this.ISBN = ISBN;
        this.title = title;
        this.category = category;
        this.authors = authors;
        this.description = description;
        this.publishedDate = publishedDate;
        this.noOfPages = noOfPages;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public String getTitle()
    {
        return title;
    }

    public BookCategory getCategory()
    {
        return category;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public String getDescription()
    {
        return description;
    }

    public Date getPublishedDate()
    {
        return publishedDate;
    }

    public int getNoOfPages()
    {
        return noOfPages;
    }
}
