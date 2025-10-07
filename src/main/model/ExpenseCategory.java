package model;

import java.util.ArrayList;

// A class representing the expense categories
public class ExpenseCategory {
    ArrayList<Expense> listOfExpenses;

    // EFFECTS: constructs new expense categories and adds it to listOfExpenses
    public ExpenseCategory() {
        listOfExpenses = new ArrayList<Expense>();
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds new expense category to listOfExpenses
    public void addExpense(Expense expense) {
        // stub
    }

    // EFFECTS: returns listOfExpenseCategories
    public ArrayList<Expense> getListOfExpenses() {
        return null; // stub
    }

}
