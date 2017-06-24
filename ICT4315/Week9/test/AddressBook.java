package ict4315.assignment9;

/**
* @author Frederick McGovern
* @version 1.3
* @since 2014-05-26
* 
* This is a class that represents an address book that contains a contact list holding contacts
*/

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class AddressBook {
	
	//private member variables
	private AddressBookModel model;
	private AddressBookAddContactView view;
	
	//Constructor
	public AddressBook()
	{
		model = new AddressBookModel();
		view = new AddressBookAddContactView(model);
		model.addContactView(view);
		
		AddInitialContacts();
		initializeGUI();
	}
	
	public static void main(String[] args) 
	{
		final AddressBook addrBook = new AddressBook();
	}
	
	// A method to load some initial contacts into the contact list
	private void AddInitialContacts()
	{
		//Create initial contacts that will be added 
		Contact contact1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", "617-855-2431", "JCochoran14@yahoo.com");
		Contact contact2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", "339-933-6405", null);
		Contact contact3 = new Contact("Steven Johnson", "45 Jasper Drive", "Westover", "MA", "03215", "508-697-6478", "SJohnson34@hotmail.com");
		Contact contact4 = new Contact("Fredeick Kaymen", "5 Noddington Way", "Lily", "WV", "32144", "805-968-4545", "13PlaneLover@aol.com");
				
		//Call to the model method to add the created contacts to a contact list
		model.addContactToContactList(contact1);
		model.addContactToContactList(contact2);
		model.addContactToContactList(contact3);
		model.addContactToContactList(contact4);
	}

	/*A method to create the frame that will be displayed to the user.  
	  A specified view that allows the user to add contacts and implements 
	  JPanel is added to the frame*/
	private void initializeGUI()
	{
		//Create JFrame
        JFrame frame = new JFrame("Fred's Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create container and add views
        Container container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));      
        container.add(view);

        //Displays the GUI to user
        frame.pack();
        frame.setVisible(true);
	}
}
