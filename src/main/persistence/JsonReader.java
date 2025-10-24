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
        this.source = source;
    }

    // EFFECTS: reads expense list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ExpenseList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExpenseList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses expense list from JSON object and returns it
    private ExpenseList parseExpenseList(JSONObject jsonObject) {
        ExpenseList el = new ExpenseList();
        addExpenses(el, jsonObject);
        return el;
    }

    // MODIFIES: el
    // EFFECTS: parses listOfExpenses from JSON object and adds them to expense list
    private void addExpenses(ExpenseList el, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("expenses");
        for (Object json : jsonArray) {
            JSONObject nextExpense = (JSONObject) json;
            addExpense(el, nextExpense);
        }
    }

    // MODIFIES: el
    // EFFECTS: parses an expense from JSON object and adds it to expense list
    private void addExpense(ExpenseList el, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String category = jsonObject.getString("category");
        int cost = jsonObject.getInt("cost");
        Boolean paymentStatus = jsonObject.getBoolean("paymentStatus");
        Expense expense = new Expense(name, category, cost, paymentStatus);
        el.addExpense(expense);
    }
}
