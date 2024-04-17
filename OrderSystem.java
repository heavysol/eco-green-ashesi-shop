import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Double;

public class OrderSystem implements InputValue {
    private Database database;
    private Item[] items;
    private Random rand = new Random();
    private int idMaker = 0;
    private Scanner scanner = new Scanner(System.in);  // Single scanner instance for the entire application

    public OrderSystem(Database database) {
        this.database = database;
        items = new Item[5];  // Initialize the array
        
        // Initialize items array with example data
        for (int i = 0; i < 5; i++) {
            items[i] = new Item(String.valueOf(i), Item.ITEMS[i], 9.99 + rand.nextInt(21));
        }
    }

    public void createMenuOption() {
        System.out.println("Menu Options:");
        System.out.println("1. Add item payment data");
        System.out.println("2. Edit item payment data");
        System.out.println("3. View all item payment data");
        System.out.println("4. Delete item payment data");
        System.out.println("5. Exit");
    }

    public void viewMenuOptions() {
        createMenuOption();
    }

    public int selectOption() {
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();  // Consume newline left behind by nextInt()
        return option;
    }

    private void addPaymentData() {
        String itemName = inputVal("Enter item name; the options are: herbal tea, reusable water bottle, reusable pack, kraft paper bag, bamboo toothbrush.");
        int itemNameIndex = -1;
        switch (itemName.toLowerCase()) {
            case "herbal tea":
                itemNameIndex = 0;
                break;
            case "reusable water bottle":
                itemNameIndex = 1;
                break;
            case "reusable pack":
                itemNameIndex = 2;
                break;
            case "kraft paper bag":
                itemNameIndex = 3;
                break;
            case "bamboo toothbrush":
                itemNameIndex = 4;
                break;
            default:
                System.out.println("Invalid item name. Please try again.");
                return; // Early return to prevent further execution
        }

        if (itemNameIndex >= 0 && itemNameIndex < items.length) {  // Check to avoid ArrayIndexOutOfBoundsException
            String payMethod = inputVal("Enter payment method of item");
            String datePurchase = inputVal("Enter date of purchase");
            String cost = inputVal("Enter cost of item");
            
            idMaker++;
            Payment payment = new Payment(String.valueOf(idMaker), items[itemNameIndex], payMethod, datePurchase, Double.parseDouble(cost));
            try {
                database.addRecord(payment.paymentData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Payment data successfully added to database.\nID of added record is: " + idMaker);
        } else {
            System.out.println("Error: Item index out of bounds.");
        }
    }

    public void runSelectedOption(int option) {
        try {
            switch (option) {
                case 1:
                    addPaymentData();
                    break;
                case 2:
                    database.editRecord();
                    System.out.println("Record in database successfully edited.");
                    break;
                case 3:
                    database.viewRecords();
                    System.out.println("=====END OF RECORD LIST=====");
                    break;
                case 4:
                    database.deleteRecord();
                    System.out.println("Record in database successfully deleted.");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();  // Close the scanner before exiting
                    return;  // Return after closing the scanner to properly exit
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public String inputVal(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    } 

    public void welcomeMessage() {
        System.out.println("Welcome to the Order System!");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Database database = new Database();
        OrderSystem orderSystem = new OrderSystem(database);
        orderSystem.welcomeMessage();
        int option = 0;

        do {
            orderSystem.viewMenuOptions();
            option = orderSystem.selectOption();
            orderSystem.runSelectedOption(option);
        } while (option != 5);
    }
}