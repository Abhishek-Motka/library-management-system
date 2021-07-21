package com.company.exceptions;

import com.company.model.BookItem;

public class BookIsNotIssuedException extends RuntimeException
{
    private BookItem bookItem;

    public BookIsNotIssuedException(BookItem bookItem)
    {
        this.bookItem = bookItem;
    }

    @Override
    public String toString()
    {
        return "Book with barcode: " + bookItem.getBarCode() + " is not issued to anyone";
    }
}
