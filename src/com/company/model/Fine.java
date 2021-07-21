package com.company.model;

import java.util.Date;

public class Fine
{
    private String bookBarcode;
    private double fineAmount;
    private Date fineDate;
    private Date paidDate;

    public Fine(String bookBarcode, double fineAmount)
    {
        this.bookBarcode = bookBarcode;
        this.fineAmount = fineAmount;
        this.fineDate = new Date();
    }

    public String getBookBarcode()
    {
        return bookBarcode;
    }

    public double getFineAmount()
    {
        return fineAmount;
    }

    public Date getFineDate()
    {
        return fineDate;
    }

    public Date getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate(Date paidDate)
    {
        this.paidDate = paidDate;
    }
}
