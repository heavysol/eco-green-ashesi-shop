// Item class

import java.lang.Integer;
import java.lang.Double;

public class Item {
    // Instance vars
    String recordID, name;
    Integer quantAvailable;
    Double price;

    // Constructor
    public Item(String recordID, String name, int quantAvailable, double price) {
        this.recordID = recordID;
        this.name = name;
        this.quantAvailable = (Integer) quantAvailable;
        this.price = (Double) price;
    }

    // gets instance var's value specified in varName parameter
    public String getRecordID() {
        return recordID;
    }

    public String getName() {
        return name;
    }

    public int getQuantAvailable() {
        return quantAvailable;
    }

    public Double getPrice() {
        return price;
    }

    // Sets value of instance var specified in varName parameter to a new one stated in newVal
    public void setInstanceVar(String varName, Object newVal) {
        switch (varName) {
            case "recordID":
                recordID = (String) newVal;
                break;
            case "name":
                name = (String) newVal;
                break;
            case "quantAvailable":
                quantAvailable = (Integer) newVal;
                break;
            case "price":
                price = (Double) newVal;
                break;
            default:
                break;
        }
    }

    // Prints info (instance vars) of item in a list format
    public void itemInfo() {
        System.out.println("Item ID: " + recordID + "\nName: " + name + "\nQuantity available in inventory: " + quantAvailable + "\nPrice: " + price);
    }

    /*public static void main(String[] args) {
        Item01 item = new Item01("001", "null", 3, 4);
        System.out.println(item.getInstanceVar("recordID"));
        item.setInstanceVar("recordID", "111");
        System.out.println(item.getInstanceVar("recordID"));
        item.itemInfo();
    }*/
}