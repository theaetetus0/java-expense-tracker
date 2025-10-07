package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseTest {
    Expense testExpense;

    @BeforeEach
    void runBefore() {
        testExpense = new Expense("test expense", 100);
    }

    @Test
    void testConstructor() {
        assertEquals("test expense", testExpense.getName());
        assertEquals(100, testExpense.getCost());
    }
}

