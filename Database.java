import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    /*
     * items are added, viewed, edited and deleted from this class
     * Attributes: record of purchased item (Item)
     * Methods: add record of item info, edit particular record, view all database
     * records, delete record, read from text database and write to t4ext database
     */

    public ArrayList<Object[]> record; // attribute of database class that stores the record of a purchase item(s)

    public Database() {
        // constructor
        record = new ArrayList<Object[]>();
    }

    // method to add item to the record
    public void addRecord(Object[] data) {
        record.add(data);
    }

    // method to view items
    public void viewItems() {
        // a for loop to print out every item in the record
        for (int i = 0; i < record.size(); i++) {
            System.out.println(record.get(i));
        }
    }

    // method to edit item in a record
    public void editItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item purchase ID: ");
        String id = input.nextLine();
        // validation checks for the id value to ensure the user enters a valid id

        System.out.println("Enter field name to modify (1 for Item Name, 2 for Payment Method, 3 for Payment Date, 4 for Cost of Item)");
        int field = input.nextInt();
        input.close();
        // validation checks for the field value to ensure the user enters a valid field number
        
        record.get();
    }

}
