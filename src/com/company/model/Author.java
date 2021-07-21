package com.company.model;

public class Author extends Person
{
    private String authorRegCode;

    public Author(String authorRegCode, String name, ContactInfo contactInfo)
    {
        super(name, contactInfo);
        this.authorRegCode = authorRegCode;
    }

    public String getAuthorRegCode()
    {
        return authorRegCode;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || ! (obj instanceof Author)) return false;
        return this.authorRegCode.equals(((Author) obj).getAuthorRegCode());
    }
}
