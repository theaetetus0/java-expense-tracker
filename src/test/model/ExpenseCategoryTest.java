package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseCategoryTest {
    ExpenseCategory testExpenseCategory;
    Expense testExpense1;
    Expense testExpense2;
    ArrayList<Expense> testListOfExpenses;

    @BeforeEach
    void runBefore() {
        testExpenseCategory = new ExpenseCategory("test expense category");
        testListOfExpenses = new ArrayList<Expense>();
        testExpense1 = new Expense("expense1", "category", 100, false);
        testExpense2 = new Expense("expense2", "category", 200, true);
    }

    @Test
    void testConstructor() {
        assertEquals("test expense category", testExpenseCategory.getName());
        assertEquals(0, testExpenseCategory.getListOfExpenses().size());
    }

    @Test
    void testAddExpense() {
        testExpenseCategory.addExpense(testExpense1);
        assertEquals(1, testExpenseCategory.getListOfExpenses().size());
        assertEquals(testExpense1, testExpenseCategory.getListOfExpenses().get(0));

        testExpenseCategory.addExpense(testExpense2);
        assertEquals(2, testExpenseCategory.getListOfExpenses().size());
        assertEquals(testExpense2, testExpenseCategory.getListOfExpenses().get(1));
    }

    @Test
    void testRemoveExpense() {
        testExpenseCategory.addExpense(testExpense1);   
        testExpenseCategory.addExpense(testExpense2);
        assertEquals(2, testExpenseCategory.getListOfExpenses().size());

        testExpenseCategory.removeExpense(testExpense1);
        assertEquals(1, testExpenseCategory.getListOfExpenses().size());
        assertEquals(testExpense2, testExpenseCategory.getListOfExpenses().get(0));
    }

    @Test
    void testSettersAndGetters() {
        testExpenseCategory.setName("new expense category");

        testListOfExpenses.add(testExpense1);
        testListOfExpenses.add(testExpense2);
        testExpenseCategory.addExpense(testExpense1);
        testExpenseCategory.addExpense(testExpense2);

        assertEquals("new expense category", testExpenseCategory.getName());
        assertEquals(2, testExpenseCategory.getListOfExpenses().size());
        assertEquals(testListOfExpenses, testExpenseCategory.getListOfExpenses());
    }

}
