package com.company.strategies;

import com.company.model.BookItem;

public class SearchByISBNStrategy implements SearchStrategy
{
    private String ISBN;

    public SearchByISBNStrategy(String isbn)
    {
        this.ISBN = isbn;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return this.ISBN.equalsIgnoreCase(bookItem.getISBN());
    }
}
