package persistence;

import model.Expense;
import model.ExpenseList;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// referenced from JsonSerializationDemo
@ExcludeFromJacocoGeneratedReport
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            @SuppressWarnings("unused")
            ExpenseList el = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyExpenseList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyExpenseList.json");
        try {
            ExpenseList el = reader.read();
            assertEquals(0, el.getListOfExpenses().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralExpenseList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralExpenseList.json");
        try {
            ExpenseList el = reader.read();
            List<Expense> testList = el.getListOfExpenses();
            assertEquals(2, testList.size());
            checkExpense("a", "rent", 500.0, false, testList.get(0));
            checkExpense("b", "grocery", 100.0, true, testList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
