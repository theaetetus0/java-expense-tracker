package ui;

import model.ExpenseList;
import model.Expense;

import java.util.Scanner;

// An expense tracker application that allows user to add expenses
public class ExpenseTracker {

    private ExpenseList expenseList;

    private Scanner scanner;
    private boolean isProgramRunning;

    // EFFECTS: Creates an instance of the ExpenseTracker console ui application
    //          (referenced from lab 4)
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
    //          (referenced from lab 4)
    public void init() {
        expenseList = new ExpenseList();
        this.scanner = new Scanner(System.in);
        this.isProgramRunning = true;
    }

    // EFFECTS: displays and processes inputs for the main menu
    //          (referenced from lab 4)
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
        } while (isInt != true);

        processMenuCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    //          (referenced from lab 4)
    public void displayMenu() {
        System.out.println("Please select an option:\n");
        System.out.println("1: View all expenses");
        System.out.println("2: Add a new expense");
        System.out.println("3: Remove an expense");
        System.out.println("4: Rename an expense");
        System.out.println("5: Change category of an expense");
        System.out.println("6: Change payment status of an expense");
        System.out.println("7: Change cost of an expense");
        System.out.println("8: View number of expenses");
        System.out.println("9: View total cost of expenses");
        System.out.println("0: Exit the application");
        printDivider();
    }

    // EFFECTS: processes the user's input in the main menu
    //          (referenced from lab 4)
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
            case 8:
                viewNumberOfExpenses();
                break;
            case 9:
                viewTotalCostOfExpenses();
                break;
            case 0:
                quitApplication();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
        printDivider();
    }

    // EFFECTS: prints list of expenses in expenseList
    public void viewExpenses() {
        System.out.println("List of expenses:");

        for (int i = 0; i < expenseList.getListOfExpenses().size(); i++) {
            String expenseName = expenseList.getListOfExpenses().get(i).getName();
            String expenseCategory = expenseList.getListOfExpenses().get(i).getCategory();
            int expenseCost = expenseList.getListOfExpenses().get(i).getCost();
            Boolean expensePaymentStatus = expenseList.getListOfExpenses().get(i).getPaymentStatus();

            System.out.println("Name: " + expenseName + ", Category: " + expenseCategory + ", Cost: " + expenseCost + ", Payment Status: " + expensePaymentStatus);
        }

    }

    // MODIFIES: this
    // EFFECTS: adds an Expense to expenseList
    public void addExpense() {
        String nameInput = "";
        String categoryInput = "";
        int costInput = -1;
        Boolean statusInput = false;

        Boolean isInt = false;
        Boolean isBool = false;

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter the expense category:");
                categoryInput = scanner.nextLine(); 

                System.out.println("Enter the cost of the expense (cost >= 0):");
                costInput = scanner.nextInt();

                System.out.println("Enter the payment status (true/false):");
                statusInput = scanner.nextBoolean();

                scanner.nextLine(); 
                isInt = true;
                isBool = true;

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while (isInt != true && isBool != true && costInput >= 0);

        Expense expense = new Expense(nameInput, categoryInput, costInput, statusInput);
        expenseList.addExpense(expense);
        System.out.println(nameInput + " was added to your expenses.");
    }

    // MODIFIES: this
    // EFFECTS: removes an expense from expenseList
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
        } while (!expenseList.getListOfExpenseNames().contains(nameInput));

        int index = getIndex(nameInput);
        expenseList.removeExpense(expenseList.getListOfExpenses().get(index));
        System.out.println(nameInput + " was removed from your expenses.");
    }

    // MODIFIES: this
    // EFFECTS: rename an expense
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
        } while (!expenseList.getListOfExpenseNames().contains(nameInput));

        int index = getIndex(nameInput);
        expenseList.getListOfExpenses().get(index).setName(newNameInput);
        System.out.println(nameInput + " was renamed to " + newNameInput);
    }

    // MODIFIES: this
    // EFFECTS: change category of an expense
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
        } while (!expenseList.getListOfExpenseNames().contains(categoryInput));

        int index = getIndex(nameInput);
        expenseList.getListOfExpenses().get(index).setCategory(categoryInput);
        System.out.println(nameInput + " category was renamed to " + categoryInput);
    }

    // MODIFIES: this
    // EFFECTS: change payment status of an expense
    public void changeExpensePaymentStatus() {
        String nameInput = "";
        Boolean statusInput = false;
        Boolean isBool = false;

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter the new payment status (true/false):");
                statusInput = scanner.nextBoolean();

                scanner.nextLine(); 
                isBool = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while (!expenseList.getListOfExpenseNames().contains(nameInput)
                && isBool != true);

        int index = getIndex(nameInput);
        expenseList.getListOfExpenses().get(index).setPaymentStatus(statusInput);
        System.out.println(nameInput + " payment status was changed to " + statusInput);
    }

    // MODIFIES: this
    // EFFECTS: change cost of an expense
    public void changeExpenseCost() {
        String nameInput = "";
        int newCost = 0;

        do {
            try {
                System.out.println("Enter the name of the expense:");
                nameInput = scanner.nextLine();

                System.out.println("Enter the new cost of an expense (cost >= 0):");
                newCost = scanner.nextInt();

                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        } while (!expenseList.getListOfExpenseNames().contains(nameInput) && newCost >= 0);

        int index = getIndex(nameInput);
        expenseList.getListOfExpenses().get(index).setCost(newCost);
        System.out.println(nameInput + " cost was changed to " + newCost);
    }

    // EFFECTS: prints total number of expenses
    public void viewNumberOfExpenses(){
        int total = 0;

        for (Expense expense : expenseList.getListOfExpenses()) {
            total++;
        }
        System.out.println("You have " + total + " total expense(s).");
    }

    // EFFECTS: prints total cost of expenses
    public void viewTotalCostOfExpenses(){
        int totalCost = 0;
        for (Expense expense : expenseList.getListOfExpenses()) {
            totalCost += expense.getCost();
        }
        System.out.println("The total cost of expenses is $" + totalCost + "");
    }  

    // EFFECTS: returns index of expense in expenseList with a specific name
    public int getIndex(String name){
        for (int i = 0; i < expenseList.getListOfExpenses().size(); i++) {
            String expenseName = expenseList.getListOfExpenses().get(i).getName();

            if (name.equals(expenseName)) {
                return i;
            }
        }
        return -1;
    }

    // MODIFIES: this
    // EFFECTS: prints a closing message and marks the program as not running
    //          (referenced from lab 4)
    public void quitApplication() {
        System.out.println("Thank you for using the Expense Tracker app!");
        this.isProgramRunning = false;
    }

    // EFFECTS: prints out a line of dashes to act as a 
    //          (referenced from lab 4)
    private void printDivider() {
        System.out.println("------------------------------------");
    }
    
}
