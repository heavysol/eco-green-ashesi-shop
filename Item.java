// Item class

import java.lang.Integer;
import java.lang.Double;

public class Item {
    String recordID, name;
    Integer quantAvailable;
    Double price;

    public Item(String recordID, String name, int quantAvailable, double price) {
        this.recordID = recordID;
        this.name = name;
        this.quantAvailable = (Integer) quantAvailable;
        this.price = (Double) price;
    }

    public Object getInstanceVar(String varName) {
        Object var = "o";

        switch (varName) {
            case "recordID":
                var = recordID;
                break;
            case "name":
                var = name;
                break;
            case "quantAvailable":
                var = quantAvailable;
                break;
            case "price":
                var = price;
                break;
            default:
                break;
        }

        return var;
    }

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

    public static void main(String[] args) {
        Item item = new Item("001", "null", 3, 4);
        System.out.println(item.getInstanceVar("recordID"));
    }
}