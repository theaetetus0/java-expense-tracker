package model;

import java.util.ArrayList;

// A class representing the an expense with a name and cost
public class Expense {
    String name;
    int cost;

    // REQUIRES: cost >= 0
    // EFFECTS: constructs a new expense and adds it to listOfExpenses
    public Expense(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    // EFFECTS: returns the name of an expense
    public String getName() {
        return ""; // stub
    }

    // EFFECTS: returns the cost of an expense
    public int getCost() {
        return 0; // stub
    }
}
