// Item class

public class Item {
    String recordID, name;
    int quantAvailable;
    double price;

    public Item(String recordID, String name, int quantAvailable, double price) {
        this.recordID = recordID;
        this.name = name;
        this.quantAvailable = quantAvailable;
        this.price = price;
    }
}