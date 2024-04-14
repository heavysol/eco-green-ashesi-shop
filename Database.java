import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Database {
    /*
     * items are added, viewed, edited and deleted from this class
     * Attributes: record of purchased item (Item)
     * Methods: add record of item info, edit particular record, view all database
     * records, delete record, read from text database and write to t4ext database
     */

    public ArrayList<Object[]> records; // attribute of database class that stores the record of a purchase item(s)
    File table;

    // constructor
    public Database() throws FileNotFoundException, IOException {
        records = new ArrayList<Object[]>();
        table = new File("table.txt");
        readFile();
    }

    // method to add item to the record
    public void addRecord(Object[] data) throws IOException {
        records.add(data);
        writeFile();
    }

    // method to view items
    public void viewItems() {
        // a for loop to print out every item in the record
        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i));
        }
    }

    // method to edit item in a record
    public void editItem() {
        Scanner input = new Scanner(System.in);

        String id = inputVal("Enter id of item purchase record");
        // validation checks for the id value to ensure the user enters a valid id

        int field = Integer.parseInt(inputVal("Enter field name to modify (1 for Item Name, 2 for Payment Method, 3 for Payment Date, 4 for Cost of Item)"));
        // validation checks for the field value to ensure the user enters a valid field number
        
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i)[0].equals(id)) {
                System.out.println("The current data in this field is " + records.get(i)[field] + "\nEnter the new data");
                if (field == 4) {
                    double update = input.nextDouble();
                    records.get(i)[field] = update;
                } else {
                    String update = input.nextLine();
                    records.get(i)[field] = update;
                }

                break;
            }
        }

        System.out.println("Field data edited");
        input.close();
    }

    public void deleteItem() {
        String id = inputVal("Enter id of item purchase record");
        // Validation of id data entered

        for (int i = 0; i < records.size(); i++) {
            if (records.get(i)[0].equals(id)) records.remove(i);
        }
    }

    void readFile() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(table);
        String[] line;
        
        while (input.hasNextLine()) {
            line = input.nextLine().split(",");
            Object[] tempArr = {line[0], line[1], line[2], line[3], Double.parseDouble(line[4])};
            addRecord(tempArr);
        }

        input.close();
    }

    void writeFile() throws IOException {
        FileWriter writeData = new FileWriter(table);

        for (int i = 0; i < records.size(); i++) {
            writeData.write(String.valueOf(records.get(0)));
            writeData.write(String.valueOf(records.get(1))); // runtime error here: Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            writeData.write(String.valueOf(records.get(2)));
            writeData.write(String.valueOf(records.get(3)));
            writeData.write(String.valueOf(records.get(4)));
        }

        writeData.close();
    }

    String inputVal(String prompt) {
        Scanner input = new Scanner(System.in);

        System.out.println(prompt);
        String val = input.nextLine();
        input.close();

        return val;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Database d = new Database();
        Object[] da1 = {"12","23","43","23",23.443};
        d.addRecord(da1);
    }
}
