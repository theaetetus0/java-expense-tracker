package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseCategoryTest {
    ExpenseCategory testExpenseCategory;
    Expense testExpense;

    @BeforeEach
    void runBefore() {
        testExpenseCategory = new ExpenseCategory();
        testExpense = new Expense("test expense", 100);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testExpenseCategory.getListOfExpenses().size());
    }

    @Test
    void addExpenseCategory() {
        testExpenseCategory.addExpense(testExpense);
        assertEquals(1, testExpenseCategory.getListOfExpenses().size());
        assertEquals(testExpense, testExpenseCategory.getListOfExpenses().get(0));
    }


}
