package org.example;

public class DVD extends Item{

    public int Duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.Duration = duration;
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
        return  title + ", " +uniqueID + ", " + Duration +" minutes";
    }
}
