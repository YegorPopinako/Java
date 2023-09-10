package org.example;

import java.util.ArrayList;

public class Library implements IManageable{

    public ArrayList<Item> items = new ArrayList();
    public ArrayList<Patron> patrons = new ArrayList();


    @Override
    public boolean add(Item item) {
        if(items.contains(item)){
            System.out.println("Item is already added!");
            return false;
        }
        items.add(item);
        return true;
    }

    @Override
    public boolean remove(Item item) {
        if(!items.contains(item)){
            System.out.println("Item is already removed or does not exist!");
            return false;
        }
        items.remove(item);
        return true;
    }

    @Override
    public ArrayList<Item> listAvailable() {
        ArrayList<Item> listAvailable = new ArrayList<>();
        for (Item item : items) {
            if(!item.isBorrowed()) {
                listAvailable.add(item);
            }
        }
        if(!listAvailable.isEmpty()){
            System.out.println("List of available items:");
            for (Item item : listAvailable) {
                System.out.println("\t" + item);
            }
            return listAvailable;
        }
        return null;
    }

    @Override
    public ArrayList<Item> listBorrowed() {
        ArrayList<Item> listBorrowed = new ArrayList<>();
        for (Item item : items) {
            if(item.isBorrowed()) {
                listBorrowed.add(item);
            }
        }
        if(!listBorrowed.isEmpty()){
            System.out.println("List of borrowed items:");
            for (Item item : listBorrowed) {
                System.out.println("\t" + item);
            }
            return listBorrowed;
        }
        return null;
    }

    public void registerPatron(Patron patron) {
        if (patrons.contains(patron)) {
            System.out.println("Patron already registered.");
        } else {
            patrons.add(patron);
            System.out.println("Patron registered: " + patron.getName());
        }
    }

    public boolean lendItem(Patron patron, Item item) {
        if(!item.isBorrowed() && items.contains(item)) {
            item.isBorrowed = true;
            patron.borrowed(item);
            return true;
        }
        return false;
    }

    public Item returnItem(Patron patron, Item item) {
        if (item.isBorrowed() && patron.getBorrowedItems().contains(item) && items.contains(item)) {
            item.returnItem();
            patron.returned(item);
            return item;
        }
        System.out.println("Item already returned!");
        return null;
    }
}
