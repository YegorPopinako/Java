package org.example;

public class Book {
    private String name;
    private String author;
    private long ISBN;
    private int year;

    public Book(String name, String author, long ISBN, int year) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return  name + " " +author + " "+ ISBN + " " + year;
    }
}
