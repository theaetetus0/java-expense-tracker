package ui;

import model.ExpenseList;
import model.Expense;

import java.util.ArrayList;
import java.util.Scanner;

// An expense tracker application that allows user to add expenses
public class ExpenseTracker {

    private ExpenseList expenseList;

    private Scanner scanner;
    private boolean isProgramRunning;

    // EFFECTS: Creates an instance of the ExpenseTracker console ui application
    public ExpenseTracker() {
       init();

        printDivider();
        System.out.println("Welcome to the Expense Tracker app!");
        printDivider();

        while (this.isProgramRunning) {
            handleMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes the application with the starting values
    public void init() {
        expenseList = new ExpenseList();
        this.scanner = new Scanner(System.in);
        this.isProgramRunning = true;
    }

    // EFFECTS: displays and processes inputs for the main menu
    public void handleMenu() {
        displayMenu();
        Boolean isInt = false;
        int input = -1;
        do {
            try {
                input = scanner.nextInt(); 
                scanner.nextLine();
                isInt = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        } while(isInt != true);

        processMenuCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    public void displayMenu() {
        System.out.println("Please select an option:\n");
        System.out.println("1: View all expenses");
        System.out.println("2: Add a new expense");
        System.out.println("3: Remove an expense");
        System.out.println("4: Rename an expense");
        System.out.println("5: Change category of an expense");
        System.out.println("6: Change cost of an expense");
        System.out.println("7: Change payment status of an expense");
        System.out.println("0: Exit the application");
        printDivider();
    }

    // EFFECTS: processes the user's input in the main menu
    public void processMenuCommands(int input) {
        printDivider();
        switch (input) {
            case 1:
                viewExpenses();
                break;
            case 2:
                addExpense();
                break;
            case 3:
                removeExpense();
                break;
            case 4:
                renameExpense();
                break;
            case 5:
                changeExpenseCategory();
                break;
            case 6:
                changeExpenseCost();
                break;
            case 7:
                changeExpensePaymentStatus();
                break;
            case 0:
                quitApplication();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
        printDivider();
    }

    // EFFECTS: prints list of expenses in ExpenseList
    public void viewExpenses() {
        System.out.println("List of expenses:");
        System.out.println(expenseList.getListOfExpenseNames());
    }

    // MODIFIES: this
    // EFFECTS: adds an Expense to ExpenseList
    public void addExpense() {
        Boolean isInt = false;
        Boolean isBool = false;

        String nameInput = "";
        String categoryInput = "";
        int costInput = -1;
        Boolean statusInput = false;

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter the expense category:");
                categoryInput = scanner.nextLine(); 

                System.out.println("Enter the cost of the expense:");
                costInput = scanner.nextInt();
                isInt = true;

                System.out.println("Enter the payment status (true/false):");
                statusInput = scanner.nextBoolean();
                isBool = true;

                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while(isInt != true && isBool != true);

        Expense expense = new Expense(nameInput, categoryInput, costInput, statusInput);
        expenseList.addExpense(expense);
        System.out.println(nameInput + " was added to your expenses.");
    }

    // MODIFIES: this
    // EFFECTS: removes an Expense from ExpenseList
    public void removeExpense() {
        String nameInput = "";

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while(!expenseList.getListOfExpenseNames().contains(nameInput));

        int index = getIndex(nameInput);
        expenseList.removeExpense(expenseList.getListOfExpenses().get(index));
        System.out.println(nameInput + " was removed from your expenses.");
    }

    // MODIFIES: this
    // EFFECTS: prints list of expenses in ExpenseList
    public void renameExpense() {
        String nameInput = "";
        String newNameInput = "";

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter a new name for the expense:");
                newNameInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while(!expenseList.getListOfExpenseNames().contains(nameInput));

        int index = getIndex(nameInput);
        expenseList.getListOfExpenses().get(index).setName(newNameInput);
        System.out.println(nameInput + " was renamed to " + newNameInput);
    }

    // MODIFIES: this
    // EFFECTS: adds an Expense to ExpenseList
    public void changeExpenseCategory() {
        String nameInput = "";
        String categoryInput = "";

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter a new category for the expense:");
                categoryInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while(!expenseList.getListOfExpenses().contains(categoryInput));

        int index = getIndex(categoryInput);
        expenseList.getListOfExpenses().get(index).setName(categoryInput);
        System.out.println(nameInput + " category was renamed to " + categoryInput);
    }

    // MODIFIES: this
    // EFFECTS: removes an Expense from ExpenseList
    public void changeExpensePaymentStatus() {
        System.out.println("Thank you for using the Expense Tracker app!");
        this.isProgramRunning = false;
    }

    // MODIFIES: this
    // EFFECTS: removes an Expense from ExpenseList
    public void changeExpenseCost() {
        System.out.println("Thank you for using the Expense Tracker app!");
        this.isProgramRunning = false;
    }

    // MODIFIES: this
    // EFFECTS: prints a closing message and marks the program as not running
    public void quitApplication() {
        System.out.println("Thank you for using the Expense Tracker app!");
        this.isProgramRunning = false;
    }

    public int getIndex(String name){
    for(int i = 0; i < expenseList.getListOfExpenses().size(); i++) {
        String expenseName = expenseList.getListOfExpenses().get(i).getName();
        //search the string
        if(name.equals(expenseName)) {
            return i;
        }
    }
    return -1;
}

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }
    
}
