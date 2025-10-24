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

    // referenced from JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("expenses", expensesToJson());
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