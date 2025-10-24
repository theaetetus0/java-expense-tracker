package ui;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.FileNotFoundException;

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        try {
            new ExpenseTracker();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}