package org.example;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.AddBook("Dandelion Wine", "Bradberry", 9780062262273L, 1957);
        library.AddBook("Harry Potter", "DJ Rolling", 9780605943117L, 1957);
        library.AddBook("Mummi Trolls", "Tuwe Yansson", 9780062242267L, 1952);
        library.AddBook("Shelter", "Medelin Ru", 9786171273191L , 2016);
        library.AddBook("Home for Peculiar Children", "Ransom Riggs", 9780062242273L, 2011);

        library.ShowBooks();

        library.Search("Home for Peculiar Children");

        library.DeleteBook(9780062242273L);
        library.ShowBooks();
    }
}