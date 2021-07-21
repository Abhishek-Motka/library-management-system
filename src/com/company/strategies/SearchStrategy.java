package com.company.strategies;

import com.company.model.BookItem;

public interface SearchStrategy
{
    boolean filter(BookItem bookItem);
}
