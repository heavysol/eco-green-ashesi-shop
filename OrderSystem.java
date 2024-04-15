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

    public OrderSystem(Database database) {
        this.database = database;
        
        for (int i = 0; i < 5; i++) {
            items[i] = new Item(String.valueOf(i), Item.ITEMS[i], 20, 9.99 + rand.nextInt(20));
        }
    }

    public void createMenuOption() {
        System.out.println("Menu Options:");
        System.out.println("1. Add Item");
        System.out.println("2. Edit Item");
        System.out.println("3. View Items");
        System.out.println("4. Delete Item");
        System.out.println("5. Exit");
    }

    public void viewMenuOptions() {
        createMenuOption();
    }

    public int selectOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.close();
        return option;
    }

    public void runSelectedOption(int option) {
        try {
            switch (option) {
                case 1:
                    String itemName = inputVal("Enter item name; the options are: herbal tea, reusable water bottle, reusable pack, kraft paper bag, bamboo toothbrush.");
                    int itemNameIndex = -1;
                    switch (itemName) {
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
                            break;
                    }

                    String payMethod = inputVal("Enter payment method of item");
                    String datePurchase = inputVal("Enter date of purchase");
                    String cost = inputVal("Enter cost of item");

                    idMaker += 1;
                    Payment payment = new Payment(String.valueOf(idMaker), items[itemNameIndex], payMethod, datePurchase, Double.parseDouble(cost));

                    database.addRecord(payment.paymentData());

                    break;
                case 2:
                    database.editItem();
                    break;
                case 3:
                    database.viewItems();
                    break;
                case 4:
                    database.deleteItem();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the Order System!");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Database database = new Database();
        OrderSystem orderSystem = new OrderSystem(database);
        orderSystem.welcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            try {
                orderSystem.viewMenuOptions();
                option = orderSystem.selectOption();
                orderSystem.runSelectedOption(option);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
            }
        } while (option != 5);

        scanner.close();
    }

    public String inputVal(String prompt) {
        Scanner input = new Scanner(System.in);

        System.out.println(prompt);
        String val = input.nextLine();
        input.close();

        return val;
    } 
}