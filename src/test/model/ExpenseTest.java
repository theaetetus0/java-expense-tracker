package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseTest {
    Expense testExpense;

    @BeforeEach
    void runBefore() {
        testExpense = new Expense("test expense 1", 100, false);
    }

    @Test
    void testConstructor() {
        assertEquals("test expense 1", testExpense.getName());
        assertEquals(100, testExpense.getCost());
        assertEquals(false, testExpense.getPaymentStatus());
    }

    @Test
    void testSetters() {
        testExpense.setName("test expense 1");
        testExpense.setCost(200);
        testExpense.setPaymentStatus(true);

        assertEquals("test expense 2", testExpense.getName());
        assertEquals(200, testExpense.getCost());
        assertEquals(true, testExpense.getPaymentStatus());
    }
}

