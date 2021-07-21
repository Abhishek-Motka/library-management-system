package com.company.strategies;

import com.company.model.Author;
import com.company.model.BookItem;

public class SearchByAuthorStrategy implements SearchStrategy
{
    private Author author;

    public SearchByAuthorStrategy(Author author)
    {
        this.author = author;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return bookItem.getAuthors().contains(author);
    }
}
