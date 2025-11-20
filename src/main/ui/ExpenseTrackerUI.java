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

    }
	
	
	
	// starts the application
	public static void main(String[] args) {
		new ExpenseTrackerUI();
	}

}
