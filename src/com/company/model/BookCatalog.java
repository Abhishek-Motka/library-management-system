package com.company.model;

import com.company.enums.BookCategory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookCatalog
{
    List<BookItem> searchByTitle(String title);
    List<BookItem> searchByISBN(String ISBN);
    List<BookItem> searchByPublicationDate(Date publicationDate);
    List<BookItem> searchByCategory(BookCategory category);
    List<BookItem> searchByAuthor(Author author);
    Optional<BookItem> searchByBarcode(String barcode);
}
