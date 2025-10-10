package model;

import java.util.ArrayList;

// A class representing the expense categories
public class ExpenseList {
    ArrayList<Expense> listOfExpenses;
   
    // EFFECTS: constructs new expense list with a name and listOfExpenses
    public ExpenseList() {
        listOfExpenses = new ArrayList<Expense>();
    }

    // MODIFIES: this
    // EFFECTS: adds new expense to listOfExpenses
    public void addExpense(Expense expense) {
        listOfExpenses.add(expense);
    }

    // MODIFIES: this
    // EFFECTS: removes expense from listOfExpenses
    public void removeExpense(Expense expense) {
        listOfExpenses.remove(expense);
    }
    
    // EFFECTS: returns listOfExpenses
    public ArrayList<String> getListOfExpenses() {
        ArrayList<String> listOfExpenseNames = new ArrayList<String>();
        for (Expense expense : listOfExpenses) {
            listOfExpenseNames.add(expense.getName());
        }
        
        return listOfExpenseNames;
    }
}