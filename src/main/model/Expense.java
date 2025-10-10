package model;

// A class representing the an expense with a name and cost
public class Expense {
    String name;
    String category;
    int cost;
    Boolean paymentStatus;

    // REQUIRES: cost >= 0
    // EFFECTS: constructs a new expense with 
    //          name, cost, and payment status
    public Expense(String name, String category, int cost, Boolean paymentStatus) {
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.paymentStatus = paymentStatus;
    }

    // MODIFIES: this
    // EFFECTS: set name of an expense
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: set category of an expense
    public void setCategory(String category) {
        this.category = category;
    }

    // MODIFIES: this
    // EFFECTS: set cost of an expense
    public void setCost(int cost) {
        this.cost = cost;
    }

    // MODIFIES: this
    // EFFECTS: set payment status
    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // EFFECTS: returns the name of an expense
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns the category of an expense
    public String getCategory() {
        return this.category;
    }

    // EFFECTS: returns the cost of an expense
    public int getCost() {
        return this.cost;
    }

    // EFFECTS: returns the cost of an expense
    public Boolean getPaymentStatus() {
        return this.paymentStatus;
    }
}
