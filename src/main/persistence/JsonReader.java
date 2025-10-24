package persistence;

import model.Expense;
import model.ExpenseList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// referenced from JsonSerializationDemo
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        
    }

    // EFFECTS: reads expense list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ExpenseList read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return "";
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ExpenseList parseWorkRoom(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: el
    // EFFECTS: parses listOfExpenses from JSON object and adds them to expense list
    private void addExpenseList(ExpenseList el, JSONObject jsonObject) {
    }

    // MODIFIES: el
    // EFFECTS: parses an expense from JSON object and adds it to expense list
    private void addExpense(ExpenseList el, JSONObject jsonObject) {
    }
}
