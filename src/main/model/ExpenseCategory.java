package model;

import java.util.ArrayList;

// A class representing the expense categories
public class ExpenseCategory {
    ArrayList<Expense> listOfExpenses;

    // EFFECTS: constructs new expense categories and adds it to listOfExpenses
    public ExpenseCategory() {
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

    // EFFECTS: returns listOfExpenseCategories
    public ArrayList<Expense> getListOfExpenses() {
        return listOfExpenses;
    }

}
