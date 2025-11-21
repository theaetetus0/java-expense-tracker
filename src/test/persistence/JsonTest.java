package persistence;

import model.Expense;

import static org.junit.jupiter.api.Assertions.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// referenced from JsonSerializationDemo
@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkExpense(String name, String category, Double cost, Boolean paymentStatus, Expense expense) {
        assertEquals(name, expense.getName());
        assertEquals(category, expense.getCategory());
        assertEquals(cost, expense.getCost());
        assertEquals(paymentStatus, expense.getPaymentStatus());
        assertEquals(String.valueOf(paymentStatus) + ": " +  String.valueOf(cost) 
                + ": " + category + ": " + name, expense.toString());
    }
}
