package model;

import java.util.ArrayList;

// A class representing the an expense with a name and cost
public class Expense {
    ArrayList<Expense> listOfExpenses;
    String name;
    int cost;

    public Expense(String name, int cost) {
        listOfExpenses = new ArrayList<Expense>();
        this.name = name;
        this.cost = cost;
    }
}
