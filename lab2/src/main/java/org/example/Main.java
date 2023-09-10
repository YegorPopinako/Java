package org.example;


import com.sun.source.tree.PackageTree;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book Book_Miracle = new Book("Miracle", "1234", "Connandyle");
        Book Book_Shelter = new Book("Shelter", "4312", "Medelin Ru");
        Book Book_BFG= new Book("A big friendly giant", "8576", "Roald Dall");
        DVD DVD_Clock = new DVD("a Clock in a Sock", "3525", 5);
        DVD DVD_Muzzy = new DVD("Muzzy in Condoland", "6757", 15);
        DVD DVD_Gumball = new DVD("The amazing world of Gumball", "5346", 22);

        library.add(Book_Miracle);
        library.add(Book_Shelter);
        library.add(Book_BFG);
        library.add(DVD_Clock);
        library.add(DVD_Muzzy);
        library.add(DVD_Gumball);

        library.listAvailable();

        Patron Ron = new Patron("Ronaldo", "7685935");
        Patron Pet = new Patron("Petya", "9763967");
        Patron And = new Patron("Andrew", "6105736");
        Patron Exi = new Patron("Exile", "5436245");

        library.registerPatron(Ron);
        library.registerPatron(Pet);
        library.registerPatron(And);
        library.registerPatron(Exi);

        library.lendItem(Ron, Book_Miracle);

        }
    }
