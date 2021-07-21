package com.company.model;


public class Person
{
    private String name;
    private ContactInfo contactInfo;

    public Person(String name, ContactInfo contactInfo)
    {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName()
    {
        return name;
    }

    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo.toString());
    }
}
