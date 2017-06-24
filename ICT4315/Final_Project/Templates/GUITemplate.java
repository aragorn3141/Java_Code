package ict4315.finalproject.Templates;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public abstract class GUITemplate {

	// Private member variables
	/**
	 * Private variable to hold our one instance of the AddressBookGUI
	 */
	private static GUITemplate uniqueGUI = null;

	/**
	 * A variable representing the frame component of the GUI
	 */
	private static JFrame frame;

	/**
	 * A variable representing the panel component of the GUI
	 */
	private static JPanel panel;

	/**
	 * A variable that contains a Dimension Object which is used as a parameter
	 * in the call to the panel's setPreferredSize method.
	 */
	private static Dimension panelDim;

	/**
	 * A variable representing the menu bar component of the GUI
	 */
	private static JMenuBar menuBar;

	// Constructor
	public GUITemplate(String guiName, boolean hasMenu, Dimension dim) {
		initializeGUI(guiName, hasMenu, dim);

		if (uniqueGUI != null) {
			return;
		}

		uniqueGUI = this;

		initializeGUI(guiName, hasMenu, dim);
	}

	/**
	 * Method call that results in the initialization of the GUI.
	 */
	private void initializeGUI(String guiName, boolean hasMenu, Dimension dim) {
		createFrame(guiName);
		createContentPanel(dim);
		if (hasMenu) {
			createMenuBar();
		}
	}

	/**
	 * Method to create the top level component, that holds all other components
	 * which creates a simple window for this application
	 */
	private void createFrame(String guiName) {
		frame = new JFrame(guiName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create Listener to handle window close event
		frame.addWindowListener(new WindowCloseManager());
	}

	/**
	 * Method to create a panel, which is a generic light weight container used
	 * to group components and simplify layout
	 */
	private void createContentPanel(Dimension dim) {
		panel = new JPanel();
		if (dim != null) {
			panelDim = dim;
		} else {
			panelDim = new Dimension(800, 500);
		}

		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(panelDim);
		frame.setContentPane(panel);
	}
	
	/**
	 * Method to create a menu bar, which is a component that holds JMenu
	 * objects thus creating a menu that the user can see and utilize.
	 */
	private void createMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	}
	
	/**
     * Method to size the frame and make it visible to the users. 
     */
    public static void displayGUI()
    {
    	frame.pack();
    	frame.setVisible(true);
    }
    
	/**
     * Method to and a pane to the main JPanel. 
     */
    public static void addPaneToContentPanel(JComponent pane)
    {
    	panel.add(pane, BorderLayout.CENTER);
    }
    
    
    public static void addMenu(JMenu menu)
    {
    	if(menu != null)
    	{
    		menuBar.add(menu);
   
    }
    
    public static JFrame getFrame(){return frame;}
    
    public static void hideDisplay(){frame.setVisible(false);}

	/**
	 * A private static class used to handle the listening event that we added
	 * to the frame
	 */
	private static class WindowCloseManager extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}
