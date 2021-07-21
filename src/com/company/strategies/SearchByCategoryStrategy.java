package com.company.strategies;

import com.company.model.BookItem;
import com.company.enums.BookCategory;

public class SearchByCategoryStrategy implements SearchStrategy
{
    private BookCategory category;

    public SearchByCategoryStrategy(BookCategory category)
    {
        this.category = category;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return this.category.equals(bookItem.getCategory());
    }
}
