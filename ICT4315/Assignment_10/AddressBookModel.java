package ict4315.assignment10;


import ict4315.assignment10.BaseClasses.ContactList;
import ict4315.assignment10.BaseClasses.Contact;
import ict4315.assignment10.BaseClasses.Phone;
import ict4315.assignment10.OutputStrategies.CreateFileOutput;
import ict4315.assignment10.OutputStrategies.HTMLFileStrategy;
import ict4315.assignment10.OutputStrategies.PlainTextFileStrategy;
import ict4315.assignment10.OutputStrategies.XMLFileStrategy;


import java.io.File;

public class AddressBookModel {
	
	private File contactFile;
	private File defaultContactFile;
	private ContactList contactList;
	
	private CreateFileOutput strategyTxt = new PlainTextFileStrategy();
	private CreateFileOutput strategyHTML = new HTMLFileStrategy();
	private CreateFileOutput strategyXML = new XMLFileStrategy();
	
	public AddressBookModel()
	{
		contactFile = null;
		defaultContactFile  = new File("C:\\Users\\Public\\contact");
		contactList  = new ContactList();
	}
	
	public File getFile(){return contactFile;}

	public boolean saveContacts() 
	{
		return saveContactsAsTxt(contactFile);
	}

	public boolean saveContactsAsTxt(File contactFile)
	{
		if(contactFile == null) {contactFile = defaultContactFile;}
		
		AddInitialContacts();
		
		for(Contact c : contactList)
	    {
			c.setOutputFileStrategy(strategyTxt);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    }
		
		return false;
	}
	
	public boolean saveContactsAsHTML(File contactFile) 
	{
		if(contactFile == null) {contactFile = defaultContactFile;}
		
		AddInitialContacts();
		
		for(Contact c : contactList)
	    {
			c.setOutputFileStrategy(strategyHTML);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    }
		
		return false;
	}

	public boolean saveContactsAsXML(File contactFile) 
	{
		if(contactFile == null) {contactFile = defaultContactFile;}
		
		AddInitialContacts();
		
		for(Contact c : contactList)
	    {
			c.setOutputFileStrategy(strategyXML);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    }
		
		return false;
	}

	public boolean saveContactsAllFormats() 
	{
		if(contactFile == null) {contactFile = defaultContactFile;}
		
		AddInitialContacts();
		
		for(Contact c : contactList)
	    {
			c.setOutputFileStrategy(strategyTxt);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    	
			c.setOutputFileStrategy(strategyHTML);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    	
			c.setOutputFileStrategy(strategyXML);
	    	c.writeContactToFile(contactFile.getAbsolutePath());
	    }
		return false;
	}

	public void openContacts(File openFile) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	/**
	 * A method used to add a contact to the contact list by first creating a contact
	 */
	public void addContact(String fullName, String street, String city, String state,
			String zipcode, Phone phone, String email)
	{
        Contact contact = new Contact(fullName, street, city, state, zipcode, phone, email);
        addContactToContactList(contact);
    }
	
	/**
	 * A method used to add contacts to the contact list
	 */
	public void addContactToContactList(Contact contact){contactList.addContact(contact);}
	

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
		addContactToContactList(contact1);
		addContactToContactList(contact2);
		addContactToContactList(contact3);
		addContactToContactList(contact4);
	}










	
	
	
	

}
