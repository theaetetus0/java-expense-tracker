package ui;

import model.ExpenseList;
import model.Expense;

import java.util.Scanner;

// An expense tracker application that allows user to add expenses
public class ExpenseTracker {

    private ExpenseList expenseCategory;

    private Scanner scanner;
    private boolean isProgramRunning;

    // EFFECTS: Creates an instance of the ExpenseTracker console ui application
    public ExpenseTracker() {
       // init();

        printDivider();
        System.out.println("Welcome to the Expense Tracker app!");
        printDivider();

        // while (this.isProgramRunning) {
        //     handleMenu();
        // }
    }

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }
    
}
