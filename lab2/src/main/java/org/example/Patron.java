package org.example;

import java.util.ArrayList;


public class Patron {
    private String Name;
    private String ID;
    private ArrayList<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.Name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowed(Item item) {
        borrowedItems.add(item);
    }

    public void returned(Item item){
        borrowedItems.remove(item);
    }


    public ArrayList<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(ArrayList<Item> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
