package com.company.strategies;

import com.company.model.BookItem;

public class SearchByBarcodeStrategy implements SearchStrategy
{
    private String barcode;

    public SearchByBarcodeStrategy(String barcode)
    {
        this.barcode = barcode;
    }

    @Override
    public boolean filter(BookItem bookItem)
    {
        return this.barcode.equals(bookItem.getBarCode());
    }
}
