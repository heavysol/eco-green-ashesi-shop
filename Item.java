// Item class

import java.lang.Integer;
import java.lang.Double;
import java.util.Arrays;

public class Item {
    // Instance vars
    String recordID, name;
    Integer quantAvailable;
    Double price;

    static final String[] ITEMS = {
        "herbal tea",
        "reusable water bottle",
        "reusable pack", 
        "kraft paper bag",
        "bamboo toothbrush",
    };

    // Constructor
    public Item(String recordID, String name, int quantAvailable, double price) {
        this.recordID = recordID;
        this.quantAvailable = (Integer) quantAvailable;
        this.price = (Double) price;

        if (Arrays.asList(ITEMS).contains(name.toLowerCase())) this.name = name;
    }

    // gets instance var's value specified in varName parameter
    public String getRecordID() {
        return recordID;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantAvailable() {
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
                String n = (String) newVal;
                n.toLowerCase();
                if (Arrays.asList(ITEMS).contains(n)) name = n; 
                else {
                    System.out.println("Invalid value. Enter items in the list."); 
                    return;
                }
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

    public static void main(String[] args) {
        Item item = new Item("001", "Reusable water bottle", 3, 4);
        item.setInstanceVar("name", "herbal tea");
        System.out.println(item.getName());
        item.itemInfo();
    }
}