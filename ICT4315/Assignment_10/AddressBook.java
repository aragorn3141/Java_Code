package ict4315.assignment10;


import ict4315.assignment10.BaseClasses.Contact;
import ict4315.assignment10.BaseClasses.Phone;
import ict4315.assignment10.Views.AddressBookAddEditView;
import ict4315.assignment10.Views.AddressBookDetailView;
import ict4315.assignment10.Views.AddressBookListView;


import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class AddressBook extends AddressBookGUI{
	
	//private member variables
	
	//private AddressBookMainView mainView;
	private AddressBookListView listView;
	private AddressBookDetailView detailView;
	private AddressBookModel model;
	
	
	private AddressBookAddEditView view;
	
		
	public AddressBook(String guiName) 
	{
		
		//initializeGUI();
		super(guiName);
		
		model = new AddressBookModel();
		
		view = new AddressBookAddEditView();
		
		//listView = new AddressBookListView();
		detailView = new AddressBookDetailView();
		
		JScrollPane listPane =
				new JScrollPane(view.getPanel());
		
		JScrollPane detailPane =
				new JScrollPane(detailView.getPanel());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				listPane, detailPane);
		
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(200);
		
		Dimension minimumSize = new Dimension(100,50);
		listPane.setMinimumSize(minimumSize);
		detailPane.setMinimumSize(minimumSize);
		
		AddressBookGUI.addPaneToContentPanel(splitPane);
		
	}

	public static void main(String[] args) 
	{
		//AddressBookGUI gui = new AddressBookGUI("Fred's contact list");
		//gui.displayGUI();
		
		final AddressBook addrBook = new AddressBook("Fred");
		addrBook.displayGUI();
		addrBook.AddInitialContacts();
		
	
	}
	
	private void initializeGUI()
	{
		//Create JFrame
        JFrame frame = new JFrame("Fred's Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create container and add views
        Container container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));      
        container.add(view.getPanel());

        //Displays the GUI to user
        frame.pack();
        frame.setVisible(true);
	}
	
	// A method to load some initial contacts into the contact list
	private void AddInitialContacts()
	{
		
		Phone p1 = new Phone("111-222-3333", "Home");
		Phone p2 = new Phone("444-555-6666", "Cell");
		Phone p3 = new Phone("777-888-9999", "Work");
		Phone p4 = new Phone("123-456-7890", "Fax");
		
		//Create initial contacts that will be added 
		Contact contact1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", p1, "JCochoran14@yahoo.com");
		Contact contact2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", p2, null);
		Contact contact3 = new Contact("Steven Johnson", "45 Jasper Drive", "Westover", "MA", "03215", p3, "SJohnson34@hotmail.com");
		Contact contact4 = new Contact("Fredeick Kaymen", "5 Noddington Way", "Lily", "WV", "32144", p4, "13PlaneLover@aol.com");
				
		//Call to the model method to add the created contacts to a contact list
		model.addContactToContactList(contact1);
		model.addContactToContactList(contact2);
		model.addContactToContactList(contact3);
		model.addContactToContactList(contact4);
	}


}
