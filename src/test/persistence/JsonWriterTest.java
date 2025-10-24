package persistence;

import model.Expense;
import model.ExpenseList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {
    
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyExpenseList() {
        try {
            ExpenseList el = new ExpenseList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyExpenseList.json");
            writer.open();
            writer.write(el);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyExpenseList.json");
            el = reader.read();
            assertEquals(0, el.getListOfExpenses().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralExpenseList() {
        try {
            ExpenseList el = new ExpenseList();
            el.addExpense(new Expense("a", "rent", 500, false));
            el.addExpense(new Expense("b", "grocery", 100, true));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralExpenseList.json");
            writer.open();
            writer.write(el);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralExpenseList.json");
            el = reader.read();
            List<Expense> testList = el.getListOfExpenses();
            assertEquals(2, testList.size());
            checkExpense("a", "rent", 500, false, testList.get(0));
            checkExpense("b", "grocery", 100, true, testList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
