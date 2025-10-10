package model;

import java.util.ArrayList;

// A class representing the expense categories
public class ExpenseCategory {
    String name;
    ArrayList<Expense> listOfExpenses;
   
    // EFFECTS: constructs new expense category with a name and listOfExpenses
    public ExpenseCategory(String name) {
        this.name = name;
        listOfExpenses = new ArrayList<Expense>();
    }

    // MODIFIES: this
    // EFFECTS: adds new expense category to listOfExpenses
    public void addExpense(Expense expense) {
        listOfExpenses.add(expense);
    }

    // MODIFIES: this
    // EFFECTS: removes new expense category to listOfExpenses
    public void removeExpense(Expense expense) {
        listOfExpenses.remove(expense);
    }

    // MODIFIES: this
    // EFFECTS: set name of expense category
    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS: returns name of expense category
    public String getName() {
        return this.name;
    }
    
    // EFFECTS: returns listOfExpenses
    public ArrayList<Expense> getListOfExpenses() {
        return this.listOfExpenses;
    }
}