package org.example;

public abstract class Item {
    public String title;
    public String uniqueID;
    public boolean isBorrowed = false;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
    }
    void borrowItem(){

    }
    void returnItem(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

}
