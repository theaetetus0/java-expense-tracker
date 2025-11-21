package ui;

import model.Expense;
import model.ExpenseList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;

import java.util.HashMap;
import java.util.Map;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// GUI for Expense Tracker Application
@ExcludeFromJacocoGeneratedReport

public class ExpenseTrackerUI extends JFrame {
    private static final int WIDTH = 1050;
    private static final int HEIGHT = 600;

    private JTable expenseTable;
    private DefaultTableModel tableModel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private ExpenseList expenseList = new ExpenseList();

    // Referenced from AlarmSystem from CPSC 210 github
    public ExpenseTrackerUI() {
        setTitle("Expense Tracker");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        
        addMenu();

        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(375, 0));

        String[] columnNames = {"Name", "Category", "Cost ($)", "Paid"};
        tableModel = new DefaultTableModel(columnNames, 0);
        expenseTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(expenseTable);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(400, 0));
        add(rightPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
    }

    // Helper to centre main application window on desktop
    // Referenced from AlarmSystem from CPSC 210 github
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    // Add menu bar
    // Referenced from AlarmSystem from CPSC 210 github
    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();

        JButton addButton = new JButton("Add Expense");
        addButton.setFocusable(false);
        addButton.addActionListener(new AddAction());
        setButtonStyle(addButton);
        menuBar.add(addButton);

        JButton removeButton = new JButton("Remove Expense");
        removeButton.setFocusable(false);
        removeButton.addActionListener(new RemoveAction());
        setButtonStyle(removeButton);
        menuBar.add(removeButton);
        
        JMenu editMenu = new JMenu("Edit Expenses");
        addMenuItem(editMenu, new RenameAction());
        addMenuItem(editMenu, new ChangeCategoryAction());
        addMenuItem(editMenu, new ChangeCostAction());
        addMenuItem(editMenu, new ChangePaymentStatusAction());
        setMenuStyle(editMenu);
        menuBar.add(editMenu);
        
        JMenu infoMenu = new JMenu("Expense Info");
        addMenuItem(infoMenu, new NumberOfExpensesAction());
        addMenuItem(infoMenu, new TotalCostAction());
        setMenuStyle(infoMenu);
        menuBar.add(infoMenu);

        JButton saveButton = new JButton("Save Expenses");
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveAction());
        setButtonStyle(saveButton);
        menuBar.add(saveButton);

        JButton loadButton = new JButton("Load Expenses");
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadAction());
        setButtonStyle(loadButton);
        menuBar.add(loadButton);

        setJMenuBar(menuBar);
    }

    private void setButtonStyle(JButton button) {
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private void setMenuStyle(JMenu menu) {
        menu.setForeground(Color.BLACK);
        menu.setBackground(Color.WHITE);
        menu.setOpaque(true);
    }

    /**
     * Adds an item with given handler to the given menu
     * @param theMenu  menu to which new item is added
     * @param action   handler for new menu item
     * @param accelerator    keystroke accelerator for this menu item
     */
    // Referenced from AlarmSystem from CPSC 210 github
    private void addMenuItem(JMenu theMenu, AbstractAction action) {
        JMenuItem menuItem = new JMenuItem(action);
        menuItem.setMnemonic(menuItem.getText().charAt(0));
        theMenu.add(menuItem);
    }

    // Represents action to be taken when user wants to add a new expense
    private class AddAction extends AbstractAction {
        
        AddAction() {
            super("Add Expense");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            String costInput = JOptionPane.showInputDialog("Enter cost (>= 0):");
            if (costInput == null || costInput.isBlank()) {
                return;
            }

            Double cost;
            try {
                cost = Double.parseDouble(costInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cost must be a number.");
                return;
            }

            int paymentStatusInput = JOptionPane.showConfirmDialog(
                    null, 
                    "Paid? (Yes = Paid, No = Unpaid)",
                    "Payment Status", JOptionPane.YES_NO_OPTION);

            boolean paymentStatus = (paymentStatusInput == JOptionPane.YES_OPTION);
            
            Expense expense = new Expense(name, category, cost, paymentStatus);

            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.equals(expense)) {
                    JOptionPane.showMessageDialog(null, "This expense has already been added.");
                    return;
                }
            }

            expenseList.addExpense(expense);

            tableModel.addRow(
                    new Object[]{expense.getName(), 
                    expense.getCategory(), 
                    expense.getCost(), 
                    expense.getPaymentStatus()});

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to remove an expense
    private class RemoveAction extends AbstractAction {
        
        RemoveAction() {
            super("Remove Expense");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            Expense expense = null;
            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.getName().equals(name) && next.getCategory().equals(category)) {
                    expense = next;
                    break;
                }
            }

            if (expense == null) {
                JOptionPane.showMessageDialog(null, "The expense was not found.");
                return;
            }

            expenseList.removeExpense(expense);

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(expense.getName()) 
                        && tableModel.getValueAt(i, 0).equals(expense.getCategory())) {
                    tableModel.removeRow(i);
                    break;
                }
            }

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to rename an expense
    private class RenameAction extends AbstractAction {
        
        RenameAction() {
            super("Rename Expense");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            String newName = JOptionPane.showInputDialog("Enter a new name:");
            if (name == null || name.isBlank()) {
                return;
            }

            Expense expense = null;
            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.getName().equals(name) && next.getCategory().equals(category)) {
                    expense = next;
                    break;
                }
            }

            if (expense == null) {
                JOptionPane.showMessageDialog(null, "The expense was not found.");
                return;
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(expense.getName()) 
                        && tableModel.getValueAt(i, 1).equals(expense.getCategory())) {
                    tableModel.setValueAt(newName, i, 0);
                    expense.setName(newName);
                    break;
                }
            }

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to change expense category an expense
    private class ChangeCategoryAction extends AbstractAction {
        
        ChangeCategoryAction() {
            super("Change Expense Category");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            String newCategory = JOptionPane.showInputDialog("Enter a new category:");
            if (name == null || name.isBlank()) {
                return;
            }

            Expense expense = null;
            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.getName().equals(name) && next.getCategory().equals(category)) {
                    expense = next;
                    break;
                }
            }

            if (expense == null) {
                JOptionPane.showMessageDialog(null, "The expense was not found.");
                return;
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(expense.getName()) 
                        && tableModel.getValueAt(i, 1).equals(expense.getCategory())) {
                    tableModel.setValueAt(newCategory, i, 1);
                    expense.setCategory(newCategory);
                    break;
                }
            }

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to change cost an expense
    private class ChangeCostAction extends AbstractAction {
        
        ChangeCostAction() {
            super("Change Cost");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            String newCostInput = JOptionPane.showInputDialog("Enter a new cost:");
            if (name == null || name.isBlank()) {
                return;
            }

            Double newCost;
            try {
                newCost = Double.parseDouble(newCostInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cost must be a number.");
                return;
            }

            Expense expense = null;
            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.getName().equals(name) && next.getCategory().equals(category)) {
                    expense = next;
                    break;
                }
            }

            if (expense == null) {
                JOptionPane.showMessageDialog(null, "The expense was not found.");
                return;
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(expense.getName()) 
                        && tableModel.getValueAt(i, 1).equals(expense.getCategory())) {
                    tableModel.setValueAt(newCost, i, 2);
                    expense.setCost(newCost);
                    break;
                }
            }

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to change payment status an expense
    private class ChangePaymentStatusAction extends AbstractAction {
        
        ChangePaymentStatusAction() {
            super("Change Payment Status");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            String name = JOptionPane.showInputDialog("Enter expense name:");
            if (name == null || name.isBlank()) {
                return;
            }

            String category = JOptionPane.showInputDialog("Enter category:");
            if (category == null || category.isBlank()) {
                return;
            }

            int newPaymentStatusInput = JOptionPane.showConfirmDialog(
                    null, 
                    "Paid? (Yes = Paid, No = Unpaid)",
                    "Payment Status", JOptionPane.YES_NO_OPTION);

            boolean newPaymentStatus = (newPaymentStatusInput == JOptionPane.YES_OPTION);

            Expense expense = null;
            for (Expense next : expenseList.getListOfExpenses()) {
                if (next.getName().equals(name) && next.getCategory().equals(category)) {
                    expense = next;
                    break;
                }
            }

            if (expense == null) {
                JOptionPane.showMessageDialog(null, "The expense was not found.");
                return;
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(expense.getName()) 
                        && tableModel.getValueAt(i, 1).equals(expense.getCategory())) {
                    tableModel.setValueAt(newPaymentStatus, i, 3);
                    expense.setPaymentStatus(newPaymentStatus);
                    break;
                }
            }

            Map<String, Double> totalCostPerCategory = new HashMap<>();
            for (Expense next : expenseList.getListOfExpenses()) {
                totalCostPerCategory.put(next.getCategory(), next.getCost());
            }

            rightPanel.removeAll();
            rightPanel.add(new PieGraph(totalCostPerCategory), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    // Represents action to be taken when user wants to view total number of expenses
    private class NumberOfExpensesAction extends AbstractAction {
        
        NumberOfExpensesAction() {
            super("Total Number Of Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "You have " 
                    + expenseList.getTotalNumberOfExpenses() + " total expense(s).");
        }
    }

    // Represents action to be taken when user wants to view total cost on an expense
    private class TotalCostAction extends AbstractAction {
        
        TotalCostAction() {
            super("Total Cost Of Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "The total cost of expenses is $ " + expenseList.getTotalCost());
        }
    }

    // Represents action to be taken when user wants to save list of expenses
    private class SaveAction extends AbstractAction {
        
        SaveAction() {
            super("Save Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
        }
    }

    // Represents action to be taken when user wants to load list of expenses
    private class LoadAction extends AbstractAction {

        LoadAction() {
            super("Load Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
        }
    }

    // starts the application
    public static void main(String[] args) {
        new ExpenseTrackerUI();
    }
}
