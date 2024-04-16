public class Payment {
    // Attributes
    private String ID, payMethod, payDate;
    private Item item;
    private double cost;

    // Constructor
    public Payment(String ID, Item item, String payMethod, String payDate, double cost) {
        this.ID = ID;
        this.item = item;
        this.payMethod = payMethod;
        this.payDate = payDate;
        this.cost = cost;
    }

    // Getter for ID
    public String getID() {
        return ID;
    }

    // Getter for item
    public String getItem() {
        return item.getName();
    }

    // Getter for payment method
    public String getPayMethod() {
        return payMethod;
    }

    // Getter for cost
    public double getCost() {
        return cost;
    }

    // Getter for payment date
    public String getPayDate() {
        return payDate;
    }

    // Setter for ID
    public void setID(String ID) {
        this.ID = ID;
    }

    // Setter for item
    public void setItem(Item item) {
        this.item = item;
    }

    // Setter for payment method
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    // Setter for cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Setter for payment date
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Object[] paymentData() {
        Object[] record = {getID(), getItem(), getPayMethod(), getPayDate(), getCost()};
        return record;
        
    }

    /*public static void main(String[] args) {
        // Create a Payment instance
        Payment payment = new Payment("123456", new Item("001", "Chocolate", 5, 20.99), "MoMo", "2024-04-10", 1200.50);

        // Initial payment details
        System.out.println("Initial Payment Details:");
        payment.getReceipt();
        System.out.println();

        // Modify some payment details
        payment.setPayMethod("Meal Plan");
        payment.setCost(1100.75);

        // Modified payment details
        System.out.println("Modified Payment Details:");
        payment.getReceipt();
    }*/
}