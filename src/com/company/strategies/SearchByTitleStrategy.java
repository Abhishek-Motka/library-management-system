package com.company.strategies;


import com.company.model.BookItem;

public class SearchByTitleStrategy implements SearchStrategy
{
    private String title;

    public SearchByTitleStrategy(String title)
    {
        this.title = title;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return this.title.equalsIgnoreCase(bookItem.getTitle());
    }
}
