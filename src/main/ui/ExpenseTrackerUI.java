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

		buttonPanel.add(createPrintCombo());

		controlPanel.add(buttonPanel, BorderLayout.WEST);
	}
	
	// add menu bar
	private void addMenu() {



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
