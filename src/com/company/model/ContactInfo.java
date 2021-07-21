package com.company.model;

public class ContactInfo
{
    private String emailAddress;
    private String phoneNumber;
    private String address;

    public ContactInfo(String emailAddress, String phoneNumber, String address)
    {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Email: " + emailAddress + "\nPhone Number: " + phoneNumber + "\nAddress: " + address;
    }
}
