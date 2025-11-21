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
    private static final int WIDTH = 1000;
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
            
        }
    }

    // Represents action to be taken when user wants to remove an expense
    private class RemoveAction extends AbstractAction {
        
        RemoveAction() {
            super("Remove Expense");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to rename an expense
    private class RenameAction extends AbstractAction {
        
        RenameAction() {
            super("Rename Expense");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to change expense category an expense
    private class ChangeCategoryAction extends AbstractAction {
        
        ChangeCategoryAction() {
            super("Change Expense Category");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to change cost an expense
    private class ChangeCostAction extends AbstractAction {
        
        ChangeCostAction() {
            super("Change Cost");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to change payment status an expense
    private class ChangePaymentStatusAction extends AbstractAction {
        
        ChangePaymentStatusAction() {
            super("Change Payment Status");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to view total number of expenses
    private class NumberOfExpensesAction extends AbstractAction {
        
        NumberOfExpensesAction() {
            super("Total Number Of Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    // Represents action to be taken when user wants to view total cost on an expense
    private class TotalCostAction extends AbstractAction {
        
        TotalCostAction() {
            super("Total Cost Of Expenses");
        }
        
        @Override
        public void actionPerformed(ActionEvent evt) {
            
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
