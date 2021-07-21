package com.company.strategies;

import com.company.model.BookItem;

import java.util.Date;

public class SearchByPublicationDateStrategy implements SearchStrategy
{
    private Date publicationDate;

    public SearchByPublicationDateStrategy(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return this.publicationDate.equals(bookItem.getPublishedDate());
    }
}
