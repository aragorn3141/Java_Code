package ict4315.assignment10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AddressBookGUI implements ActionListener {
	
	//Private member variables
    /**
     * Private variable to hold our one instance of the AddressBookGUI
     */
	private static AddressBookGUI uniqueGUI;
	
	
	private AddressBookMenuFileController controller;
	
	
	
    /**
     * A variable representing the frame component of the GUI
     */
	private static JFrame frame;
	
    /**
     * A variable representing the panel component of the GUI
     */
	private static JPanel panel;
	
    /**
     * A variable that contains a Dimension Object which is used
     * as a parameter in the call to the panel's setPreferredSize
     * method.
     */
	private static Dimension panelDim;
	
    /**
     * A variable representing the menu bar component of the GUI
     */
	private static JMenuBar menuBar;
	
    /**
     * A variable representing the menu corresponding to File manipulation
     */
	private static JMenu menuFile;
	
    /**
     * A variable representing the menu corresponding to contact 
     */
	private static JMenu menuContacts;


	private	static JMenuItem menuFileOpen;
	private	static JMenuItem menuFileSave;
	private	static JMenuItem menuFileSaveAllFormats;
	private	static JMenuItem menuFileSaveAsTxt;
	private	static JMenuItem menuFileSaveAsHTML;
	private	static JMenuItem menuFileSaveAsXML;
	private	static JMenuItem menuFileExit;
	private	static JMenuItem menuAddContact;
	private	static JMenuItem menuEditContact;
	private	static JMenuItem menuDeleteContact;
	
	
	// Constructor
	/**
	 * Creates a new AddressBookGUI with the given application name for the 
	 * content panel.
	 */
	public AddressBookGUI(String guiName)
	{
		controller = new AddressBookMenuFileController();
		getInstance();
		initializeGUI(guiName);
	}
	
	//Public methods
	/**
     * Method to create and return an unique instance of the AddressBookGUI class.
     */
    public AddressBookGUI getInstance()
    {
    	if(uniqueGUI == null){uniqueGUI = this;}
    	
    	return uniqueGUI;
    }
    
    /**
     * Method call that results in the initialization of the GUI. 
     */
    private void initializeGUI(String guiName) 
    {
    	createFrame(guiName);
    	createContentPanel();
    	createMenuBar();
    	createMenus();
    	createMenuItems();
    	createListeners();
	}
    
	/**
     * Method to create the top level component, that holds all other
     * components which creates a simple window for this application 
     */
    private void createFrame(String guiName)
    {
        frame = new JFrame(guiName);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Listener to handle window close event
        frame.addWindowListener(new WindowCloseManager());
    }
    
 	/**
     * Method to create a panel, which is a generic light weight container
     * used to group components and simplify layout
     */
   private void createContentPanel()
   {
   	panel = new JPanel();
   	panelDim = new Dimension(800, 500);
   	
   	panel.setLayout(new BorderLayout());
   	panel.setPreferredSize(panelDim);
   	frame.setContentPane(panel);
   }
   
	/**
    * Method to create a menu bar, which is a component that holds JMenu objects
    * thus creating a menu that the user can see and utilize.
    */
   private void createMenuBar()
   {
   	menuBar = new JMenuBar();
   	frame.setJMenuBar(menuBar);
   }
   
   private void createMenus()
   {
	   //Create menus
	   menuFile = new JMenu("File");
	   menuContacts = new JMenu("Contacts");
	   
	   menuFile.setMnemonic(KeyEvent.VK_F);
	   menuContacts.setMnemonic(KeyEvent.VK_C);
	   
	   //Add menus to menu bar
	   menuBar.add(menuFile);
	   menuBar.add(menuContacts);
   }
   
   private void createMenuItems()
   {
	   //Add menu items to menuFile
	   menuFileOpen = CreateMenuItem(menuFile, "Open Contact List", KeyEvent.VK_O,
		   "Open an existing contact list file");
	   
	   menuFile.addSeparator();
	  
	   menuFileSave = CreateMenuItem(menuFile, "Save Contact List", KeyEvent.VK_S,
		   "Save this contact list");
	   
	   menuFileSaveAllFormats = CreateMenuItem(menuFile, "Save Contact List All Formats", KeyEvent.VK_F,
		   "Save this contact list in txt, html and xml");
	  
	   menuFile.addSeparator();
	   
	   menuFileSaveAsTxt = CreateMenuItem(menuFile, "Text: Save As Contact List", KeyEvent.VK_T,
			"Save this contact list to a new text file");
	
	   menuFileSaveAsHTML = CreateMenuItem(menuFile, "HTML: Save As Contact List", KeyEvent.VK_H,
		   "Save this contact list to a new html file");
	
	   menuFileSaveAsXML = CreateMenuItem(menuFile, "XML: Save Contact List", KeyEvent.VK_X,
		   "Save this contact list to a new xml file");
	   
	   menuFile.addSeparator();
	  
	   menuFileExit = CreateMenuItem(menuFile, "Exit", KeyEvent.VK_X, "Exit program");

	 //Add menu items to menuContacts
	   menuAddContact = CreateMenuItem(menuContacts, "Add Contact", KeyEvent.VK_A,
			   "Creates a new contct and adds it to the contct list");
	   
	   menuEditContact = CreateMenuItem(menuContacts, "Edit Contact", KeyEvent.VK_E,
			   "Edits an existing contact");
	   
	   menuDeleteContact = CreateMenuItem(menuContacts, "Delete Contact", KeyEvent.VK_D,
			   "Deletes an existing contact");
   }
   
   public void createListeners()
   {
	   	   //File->Open
		   menuFileOpen.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.openFileDialog();
	             }
	        });
		   
		 //File->Save
		   menuFileSave.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.saveFileDialog();
	             }
	        });
		   
		   menuFileSaveAllFormats.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.saveAllFormatsFileDialog();
	             }
	        });
		   
		   //File->SaveAsTxt
		   menuFileSaveAsTxt.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.saveAsTxtFileDialog();
	             }
	        });
		   
		   //File->SaveAsHTML
		   menuFileSaveAsHTML.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.saveAsHTMLFileDialog();
	             }
	        });
		   
		   //File->SaveAsXML
		   menuFileSaveAsXML.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.saveAsXMLFileDialog();
	             }
	        });
		   
		 //Contacts->Add
		   menuAddContact.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.addContact();
	             }
	        });
		   
			 //Contacts->Add
		   menuEditContact.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.editContact();
	             }
	        });
		   
			 //Contacts->Delete
		   menuDeleteContact.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.deleteContact();
	             }
	        });
		   
			 //Contacts->Delete
		   menuFileExit.addActionListener(new ActionListener() {
			   
	            public void actionPerformed(ActionEvent e)
	            { 
	            	controller.closeApplication();
	             }
	        });
		   
   }
 
	/**
     * Method to size the frame and make it visible to the users. 
     */
    public void displayGUI()
    {
    	frame.pack();
    	frame.setVisible(true);
    }
    
    public static void addPaneToContentPanel(JComponent pane)
    {
    	panel.add(pane, BorderLayout.CENTER);
    }
    
	/**
     * A private static class used to handle the listening event
     * that we added to the frame
     */
    private static class WindowCloseManager extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }
    
    public JMenuItem CreateMenuItem( JMenu menu, String menuItemName, 
    		Integer key, String toolTip)
    {
    	JMenuItem menuItem;
    	menuItem = new JMenuItem();
	
		menuItem.setText(menuItemName);
		
		menuItem.setMnemonic(key);
		
		menuItem.setToolTipText(toolTip);
	
		// Add an action handler to this menu item
		menuItem.addActionListener( this );
		menu.add(menuItem);
		
		return menuItem;
    }

    public void actionPerformed(ActionEvent ae) {}
    
    
  

}
