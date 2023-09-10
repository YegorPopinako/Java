package org.example;

import java.util.ArrayList;

public interface IManageable {
    boolean add(Item item);
    boolean remove(Item item);
    ArrayList<Item> listAvailable();
    ArrayList<Item> listBorrowed();
}
