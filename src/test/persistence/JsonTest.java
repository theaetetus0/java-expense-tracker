package persistence;

import model.Expense;
import model.ExpenseList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkExpense(String name, String category, int cost, boolean paymentStatus, Expense expense) {
        assertEquals(name, expense.getName());
        assertEquals(category, expense.getCategory());
        assertEquals(cost, expense.getCost());
        assertEquals(paymentStatus, expense.getPaymentStatus());
        assertEquals(paymentStatus + ": " + cost + ": " + category + ": " + name, expense.toString());
    }
}
