package org.example;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public int getSize(){
        return books.size();
    }

    public void AddBook(String n, String au, long isbn, int y) {
        int flag = 0;
        for (Book b : books) {
            if(b.getISBN() == isbn) {
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            books.add(new Book(n, au, isbn, y));
        }
        else{
            System.out.println("The book already exists!");
        }
    }

    public void ShowBooks(){
        if(books.isEmpty()){
            System.out.print("Library is empty!\n");
        }
        else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    public Book Search(String name){
        for (Book b : books){
            if(b.getName().equals(name)){
                System.out.print(b);
                return b;
            }
        }
        System.out.print("No book with such a name!\n");
        return null;
    }


    public Book DeleteBook(long isbn){
        int num = findIndex(isbn);
        if(num == -1){
            System.out.println("Book with such ISBN not found!");
        }
        else {
            return books.remove(findIndex(isbn));
        }
        return null;
    }

    public int findIndex(long isbn){
        int index = -1;

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getISBN() == isbn) {
                index = i;
                break;
            }
        }
        return index;
    }

}

