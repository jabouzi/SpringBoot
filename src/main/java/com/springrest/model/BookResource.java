package com.springrest.model;

public class BookResource {

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookResource{" +
                "book=" + book.toString() +
                '}';
    }
}
