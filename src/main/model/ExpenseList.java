package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.*;

// A class representing the expense categories
public class ExpenseList implements Writable {
    ArrayList<Expense> listOfExpenses;

    // EFFECTS: constructs new expense list with a name and listOfExpenses
    public ExpenseList() {
        EventLog.getInstance().clear();
        listOfExpenses = new ArrayList<Expense>();

        EventLog.getInstance().logEvent(new Event("New ExpenseList Created"));
    }

    // MODIFIES: this
    // EFFECTS: adds new expense to listOfExpenses
    public void addExpense(Expense expense) {
        listOfExpenses.add(expense);
        EventLog.getInstance().logEvent(
            new Event("Added expense, Name: " + expense.getName() + ", Category: " + expense.getCategory() 
                    + ", Cost: " + expense.getCost() + ", Payment Status: " + expense.getPaymentStatus())
        );
    }

    // MODIFIES: this
    // EFFECTS: removes expense from listOfExpenses
    public void removeExpense(Expense expense) {
        listOfExpenses.remove(expense);
        EventLog.getInstance().logEvent(
            new Event("Removed expense, Name: " + expense.getName() + ", Category: " + expense.getCategory())
        );
    }
    
    // EFFECTS: returns listOfExpenses
    public ArrayList<Expense> getListOfExpenses() {
        return listOfExpenses;
    }

    // EFFECTS: returns listOfExpenses names
    public ArrayList<String> getListOfExpenseNames() {
        ArrayList<String> listOfExpenseNames = new ArrayList<String>();
        for (Expense expense : listOfExpenses) {
            listOfExpenseNames.add(expense.getName());
        }
        
        return listOfExpenseNames;
    }

    // EFFECTS: returns total number of expenses
    public int getTotalNumberOfExpenses() {
        int total = 0;
        for (Expense expense : listOfExpenses) {
            total++;
        }
        
        EventLog.getInstance().logEvent(
            new Event("Requested total number of expenses: " + total)
        );

        return total;
    }

    // EFFECTS: returns total cost of expenses
    public double getTotalCost() {
        double total = 0;
        for (Expense expense : listOfExpenses) {
            total += expense.getCost();
        }
        
        EventLog.getInstance().logEvent(
            new Event("Requested total cost of expenses: $" + total)
        );

        return total;
    }

    // referenced from JsonSerializationDemo
    // EFFECTS: Inserts expenses to JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("expenses", expensesToJson());

        EventLog.getInstance().logEvent(
            new Event("Saved expense list")
        );

        return json;
    }

    // referenced from JsonSerializationDemo
    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray expensesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Expense next : listOfExpenses) {
            jsonArray.put(next.toJson());
        }

        return jsonArray;
    }
}