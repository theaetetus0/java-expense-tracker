package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseTest {
    Expense testExpense;

    @BeforeEach
    void runBefore() {
        testExpense = new Expense("test expense", "test category", 100.0, false);
    }

    @Test
    void testConstructor() {
        assertEquals("test expense", testExpense.getName());
        assertEquals("test category", testExpense.getCategory());
        assertEquals(100, testExpense.getCost());
        assertEquals(false, testExpense.getPaymentStatus());
    }

    @Test
    void testSettersAndGetters() {
        testExpense.setName("test new name");
        testExpense.setCategory("test new category");
        testExpense.setCost(200.0);
        testExpense.setPaymentStatus(true);

        assertEquals("test new name", testExpense.getName());
        assertEquals("test new category", testExpense.getCategory());
        assertEquals(200, testExpense.getCost());
        assertEquals(true, testExpense.getPaymentStatus());
    }
}

