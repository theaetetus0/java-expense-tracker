package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Remote;

import javax.swing.*;

public class ExpenseTrackerUI extends JFrame {

    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String FILE_DESCRIPTOR = "...file";
	private static final String SCREEN_DESCRIPTOR = "...screen";
	private JComboBox<String> printCombo;
	private JDesktopPane desktop;
	private JInternalFrame controlPanel;

    public ExpenseTrackerUI() {
        desktop = new JDesktopPane();
		desktop.addMouseListener(new DesktopFocusAction());
		controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
		controlPanel.setLayout(new BorderLayout());

        setContentPane(desktop);
		setTitle("Expense Tracker");
		setSize(WIDTH, HEIGHT);

        addButtonPanel();
		addMenu();

		controlPanel.pack();
		controlPanel.setVisible(true);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		centreOnScreen();
		setVisible(true);
    }
	
	// helper to add control buttons
	private void addButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,2));
        buttonPanel.add(new JButton(new ViewAction()));
		buttonPanel.add(new JButton(new AddAction()));
		buttonPanel.add(new JButton(new RemoveAction()));
		buttonPanel.add(new JButton(new RenameAction()));
		buttonPanel.add(new JButton(new ChangeCategoryAction()));
		buttonPanel.add(new JButton(new ChangeCostAction()));
		buttonPanel.add(new JButton(new ChangePaymentStatusAction()));
		buttonPanel.add(createPrintCombo());

		controlPanel.add(buttonPanel, BorderLayout.WEST);
	}
	
	// add menu bar
	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu expenseMenu = new JMenu("Expenses Menu");
		expenseMenu.setMnemonic('M');
		
        JMenu viewMenu = new JMenu("View Expenses");
		viewMenu.setMnemonic('V');
		addMenuItem(viewMenu, new ViewAction(), null);
		menuBar.add(viewMenu);

		JMenu addRemoveMenu = new JMenu("Add/Remove Expenses");
		addRemoveMenu.setMnemonic('E');
		addMenuItem(addRemoveMenu, new AddAction(), null);
		addMenuItem(addRemoveMenu, new RemoveAction(), null);
		menuBar.add(addRemoveMenu);
		
		JMenu editMenu = new JMenu("Edit Expenses");	
		editMenu.setMnemonic('y');
		addMenuItem(editMenu, new RenameAction(), null);
		addMenuItem(editMenu, new ChangeCategoryAction(), null);
        addMenuItem(editMenu, new ChangeCostAction(), null);
        addMenuItem(editMenu, new ChangePaymentStatusAction(), null);
		menuBar.add(editMenu);
		
        JMenu infoMenu = new JMenu("Expense Info");	
		infoMenu.setMnemonic('y');
		addMenuItem(infoMenu, new NumberOfExpensesAction(), null);
		addMenuItem(infoMenu, new TotalCostAction(), null);
		menuBar.add(infoMenu);

		setJMenuBar(menuBar);
	}

	/**
	 * Adds an item with given handler to the given menu
	 * @param theMenu  menu to which new item is added
	 * @param action   handler for new menu item
	 * @param accelerator    keystroke accelerator for this menu item
	 */
	private void addMenuItem(JMenu theMenu, AbstractAction action, KeyStroke accelerator) {
		JMenuItem menuItem = new JMenuItem(action);
		menuItem.setMnemonic(menuItem.getText().charAt(0));
		menuItem.setAccelerator(accelerator);
		theMenu.add(menuItem);
	}
	
	
	/**
	 * Helper to create print options combo box
	 * @return  the combo box
	 */
	private JComboBox<String> createPrintCombo() {
		printCombo = new JComboBox<String>();
		printCombo.addItem(FILE_DESCRIPTOR);
		printCombo.addItem(SCREEN_DESCRIPTOR);
		return printCombo;
	}
	
	// Helper to centre main application window on desktop
	private void centreOnScreen() {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
	}

    // Represents action to be taken when user wants to view the list of expenses
	private class ViewAction extends AbstractAction {
		
		ViewAction() {
			super("View Expenses");
		}
		
		@Override
		public void actionPerformed(ActionEvent evt) {
		}
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

	/**
	 * Represents action to be taken when user clicks desktop
	 * to switch focus. (Needed for key handling.)
	 */
	private class DesktopFocusAction extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ExpenseTrackerUI.this.requestFocusInWindow();
		}
	}
	
	// starts the application
	public static void main(String[] args) {
		new ExpenseTrackerUI();
	}

}
