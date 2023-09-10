package org.example;

public class Book extends Item{
    public String Author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.Author = author;
    }

    @Override
    void borrowItem(){
        super.isBorrowed = true;
    }
    @Override
    void returnItem(){
        super.isBorrowed = false;
    }
    @Override
    public String toString() {
        return  title + ", " +uniqueID + ", " + Author;
    }
}
