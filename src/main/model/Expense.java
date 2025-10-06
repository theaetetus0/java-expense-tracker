package model;

import java.util.ArrayList;

// A class representing the an expense with a name and cost
public class Expense {
    ArrayList<Expense> listOfExpenses;
    String name;
    int cost;

    // EFFECTS: constructs a new expense and adds it to listOfExpenses
    public Expense(String name, int cost) {
        listOfExpenses = new ArrayList<Expense>();
        this.name = name;
        this.cost = cost;
    }

    // MODIFIES: this
    // EFFECTS: adds new expense to listOfExpenses
    public void addExpense(Expense expense) {
        // stub
    }

    // EFFECTS: returns the name of the expense
    public String getName() {
        return ""; // stub
    }

    // EFFECTS: returns the cost of the expense
    public int getCost() {
        return 0; // stub
    }
}
