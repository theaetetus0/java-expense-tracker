package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseListTest {
    ExpenseList testExpenseList;
    Expense testExpense1;
    Expense testExpense2;
    ArrayList<Expense> testListOfExpenses;

    @BeforeEach
    void runBefore() {
        testExpenseList = new ExpenseList();
        testListOfExpenses = new ArrayList<Expense>();
        testExpense1 = new Expense("expense1", "category", 100, false);
        testExpense2 = new Expense("expense2", "category", 200, true);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testExpenseList.getListOfExpenses().size());
    }

    @Test
    void testAddExpense() {
        testExpenseList.addExpense(testExpense1);
        assertEquals(1, testExpenseList.getListOfExpenses().size());
        assertEquals(testExpense1, testExpenseList.getListOfExpenses().get(0));

        testExpenseList.addExpense(testExpense2);
        assertEquals(2, testExpenseList.getListOfExpenses().size());
        assertEquals(testExpense2, testExpenseList.getListOfExpenses().get(1));
    }

    @Test
    void testRemoveExpense() {
        testExpenseList.addExpense(testExpense1);   
        testExpenseList.addExpense(testExpense2);
        assertEquals(2, testExpenseList.getListOfExpenses().size());

        testExpenseList.removeExpense(testExpense1);
        assertEquals(1, testExpenseList.getListOfExpenses().size());
        assertEquals(testExpense2, testExpenseList.getListOfExpenses().get(0));
    }

    @Test
    void testSettersAndGetters() {
        testListOfExpenses.add(testExpense1);
        testListOfExpenses.add(testExpense2);
        testExpenseList.addExpense(testExpense1);
        testExpenseList.addExpense(testExpense2);

        assertEquals(2, testExpenseList.getListOfExpenses().size());
        assertEquals(testListOfExpenses, testExpenseList.getListOfExpenses());
    }

}
