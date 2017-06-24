package ict4315.finalproject.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ict4315.finalproject.Controllers.MainController;
import ict4315.finalproject.Models.MainModel;
import ict4315.finalproject.Templates.GUITemplate;
import ict4315.finalproject.Templates.ViewTemplate;

public class MainView extends ViewTemplate implements ActionListener {

	//Private member variables
	private static MainView view = null;
	
	/**
	 * A variable representing the menu corresponding to File manipulation
	 */
	private static JMenu menuFile;

	/**
	 * A variable representing the menu corresponding to contact
	 */
	private static JMenu menuContacts;

	private static JMenuItem menuFileOpen;
	private static JMenuItem menuFileSave;
	private static JMenuItem menuFileSaveAllFormats;
	private static JMenuItem menuFileSaveAsTxt;
	private static JMenuItem menuFileSaveAsHTML;
	private static JMenuItem menuFileSaveAsXML;
	private static JMenuItem menuFileExit;
	private static JMenuItem menuAddContact;
	private static JMenuItem menuEditContact;
	private static JMenuItem menuDeleteContact;
	private MainModel model;
	private MainController controller;
	
	//Constructors
	private MainView() 
	{
		model = MainModel.getInstance();
		model.addView(this);
		controller = MainController.getInstance();
		
		addGUIControls();
	}
	
	public static MainView getInstance() {
		if (view == null) {
			view = new MainView();
		}
		return view;
	}
	
	//Private methods	
	private void addGUIControls() {
		createMenus();
		addMenuItems();
		createListeners();
	}

	private void createMenus() {
		// Create menus
		menuFile = new JMenu("File");
		menuContacts = new JMenu("Contacts");

		menuFile.setMnemonic(KeyEvent.VK_F);
		menuContacts.setMnemonic(KeyEvent.VK_C);

		// Add menus to menu bar
		GUITemplate.addMenu(menuFile);
		GUITemplate.addMenu(menuContacts);
	}

	private void addMenuItems() {
		
		// Add menu items to menuFile
		menuFileOpen = CreateMenuItem(menuFile, "Open Contact List",
				KeyEvent.VK_O, "Open an existing contact list file");

		menuFile.addSeparator();

		menuFileSave = CreateMenuItem(menuFile, "Save Contact List",
				KeyEvent.VK_S, "Save this contact list");

		menuFileSaveAllFormats = CreateMenuItem(menuFile,
				"Save Contact List All Formats", KeyEvent.VK_V,
				"Save this contact list in txt, html and xml");

		menuFile.addSeparator();

		menuFileSaveAsTxt = CreateMenuItem(menuFile,
				"Text: Save As Contact List", KeyEvent.VK_T,
				"Save this contact list to a new text file");

		menuFileSaveAsHTML = CreateMenuItem(menuFile,
				"HTML: Save As Contact List", KeyEvent.VK_H,
				"Save this contact list to a new html file");

		menuFileSaveAsXML = CreateMenuItem(menuFile, "XML: Save Contact List",
				KeyEvent.VK_X, "Save this contact list to a new xml file");

		menuFile.addSeparator();

		menuFileExit = CreateMenuItem(menuFile, "Exit", KeyEvent.VK_X,
				"Exit program");

		// Add menu items to menuContacts
		menuAddContact = CreateMenuItem(menuContacts, "Add Contact",
				KeyEvent.VK_A,
				"Creates a new contct and adds it to the contct list");

		menuEditContact = CreateMenuItem(menuContacts, "Edit Contact",
				KeyEvent.VK_E, "Edits an existing contact");

		menuDeleteContact = CreateMenuItem(menuContacts, "Delete Contact",
				KeyEvent.VK_D, "Deletes an existing contact");
	}

	private JMenuItem CreateMenuItem(JMenu menu, String menuItemName,
			Integer key, String toolTip) {
		JMenuItem menuItem;
		menuItem = new JMenuItem();

		menuItem.setText(menuItemName);

		menuItem.setMnemonic(key);

		menuItem.setToolTipText(toolTip);

		// Add an action handler to this menu item
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuItem;
	}
	
	private void createListeners() {
		// File->Open
		menuFileOpen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				controller.openFileDialog();
			}
		});

		// File->Save
		menuFileSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				controller.saveFileDialog();
			}
		});

		// File->SaveAllFormats
		menuFileSaveAllFormats.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.saveAllFormatsFileDialog();
			}
		});

		// File->SaveAsTxt
		menuFileSaveAsTxt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.saveAsTxtFileDialog();
			}
		});

		// File->SaveAsHTML
		menuFileSaveAsHTML.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.saveAsHTMLFileDialog();
			}
		});

		// File->SaveAsXML
		menuFileSaveAsXML.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.saveAsXMLFileDialog();
			}
		});

		// Contacts->Add
		menuAddContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.addContact();
			}
		});

		// Contacts->Edit
		menuEditContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.editContact();
			}
		});

		// Contacts->Delete
		menuDeleteContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.deleteContact();
			}
		});

		// Contacts->Exit
		menuFileExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.closeApplication();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {}



}
