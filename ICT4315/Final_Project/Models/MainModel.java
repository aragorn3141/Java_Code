package ict4315.finalproject.Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ict4315.finalproject.BaseClasses.Contact;
import ict4315.finalproject.BaseClasses.ContactList;
import ict4315.finalproject.BaseClasses.Phone;
import ict4315.finalproject.BaseClasses.HelperClasses.ValidateInput;
import ict4315.finalproject.OutputStrategies.CreateFileOutput;
import ict4315.finalproject.OutputStrategies.HTMLFileStrategy;
import ict4315.finalproject.OutputStrategies.PlainTextFileStrategy;
import ict4315.finalproject.OutputStrategies.XMLFileStrategy;
import ict4315.finalproject.Templates.GUITemplate;
import ict4315.finalproject.Templates.ModelTemplate;

public class MainModel extends ModelTemplate {

	private static MainModel model = null;

	// Default null
	private File contactFile;
	private File defaultContactFile;

	private Contact contact;
	private ContactList contactList;

	private int currentContactIndex;

	// Default false
	private boolean addedContact;
	private boolean editContact;
	private boolean changeMade;
	
	private static boolean validFullName = false;
	private static boolean validStreet = false;
	private static boolean validCity = false;
	private static boolean validZipCode = false;
	private static boolean validPhone = false;
	private static boolean validEmail = false;

	private CreateFileOutput strategyTxt = new PlainTextFileStrategy();
	private CreateFileOutput strategyHTML = new HTMLFileStrategy();
	private CreateFileOutput strategyXML = new XMLFileStrategy();
	
	private String fullName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String phoneType;
	private String email;

	private JFrame addEditFrame;

	// Constructors
	private MainModel() {
		defaultContactFile = new File("C:\\Users\\Public\\contact");
		contactList = new ContactList();
	}

	public static MainModel getInstance() {
		if (model == null) {
			model = new MainModel();
		}
		return model;
	}

	// Getters
	public File getFile() {
		return contactFile;
	}

	public ContactList getList() {
		return contactList;
	}

	public Contact getContactFromContactList() {
		if ((currentContactIndex >= 0) && (contactList.Size() > 0)) {
			return contactList.contactAtIndex(currentContactIndex);
		}
		return null;
	}
	
	public int getContactListSize() {
		return contactList.Size();
	}

	public int getCurrentContactIndex() {
		return currentContactIndex;
	}

	public boolean isAddedContact() {return addedContact;}

	public boolean isChangeMade() {return changeMade;}

	public boolean isEditContact() {return editContact;}

	// Setters
	// Allows AddressBook to forward created Frame to Model
	public void setAddEditFrame(JFrame frame) {
		addEditFrame = frame;
	}

	//Sets the current index as determined by the list view
	public void setCurrentContactIndex(int index) 
	{
		if((contactList != null) && (contactList.Size() >= 0))
		{
			currentContactIndex = index;
			notifyViews();
		}
	}
	
	// Adding contacts
	/**
	 * A method used to add a contact to the contact list by first creating a
	 * contact
	 */
	public void addContact(String fullName, String street, String city,
			String state, String zipcode, Phone phone, String email) {
		
		Contact contact = new Contact(fullName, street, city, state, zipcode,
				phone, email);
		addContactToContactList(contact);
	}

	/**
	 * A method used to add contacts to the contact list
	 */
	public void addContactToContactList(Contact contact) {
		contactList.addContact(contact);
		addedContact = true;
	}

	// Methods called from Main Controller
	// Method for opening file
	public void openContacts(File openFile) {
	
		if(openFile != null)
		{
			contactFile = openFile;
			try 
			{ 
				contactList.clear();
				BufferedReader br = new BufferedReader
					(new FileReader(openFile));
			
				String input = null;
						
				while((input = br.readLine()) != null)
				{
					String temp[] = input.split("\t");
					fullName = temp[0];
					street = temp[1];
					city = temp[2];
					state = temp[3];
					zipCode = temp[4];
					phone = temp[5];
					phoneType = temp[6];
					
					Phone p = new Phone(phone, phoneType);
					addContact(fullName, street, city, state, zipCode,
						p, email);
				}
			
				br.close();
				changeMade = true;
				addedContact = true;
				editContact = false;
				notifyViews();
				
			}
			catch(IOException e){
				displayUserMessage(
				"An error has occurred while reading the file.");
				contactFile = null;
			}
		}
	}

	// Methods for saving
	public boolean saveContacts() {
		return saveContactsAsTxt(contactFile);
	}

	public boolean saveContactsAsTxt(File contactFile) {
		if(getContactListSize() > 0)
		{
			if (contactFile == null) 
			{
				contactFile = defaultContactFile;
			}
			
			try
			{
				deleteFile(contactFile);
				
				for (Contact c : contactList) {
					c.setOutputFileStrategy(strategyTxt);
					c.writeContactToFile(contactFile.getAbsolutePath());
				}
			}
			catch(Exception e){
				displayUserMessage("An error has occurred: " + e.getMessage());
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, 
					"You have no contacts!  Please add a contact before saving.");
		}
			
			return false;
	}

	public boolean saveContactsAsHTML(File contactFile) {
		if(getContactListSize() > 0)
		{
			if (contactFile == null) 
			{
				contactFile = defaultContactFile;
			}
	
			try
			{
				deleteFile(contactFile);
				
				for (Contact c : contactList) {
					c.setOutputFileStrategy(strategyHTML);
					c.writeContactToFile(contactFile.getAbsolutePath());
				}
			}
			catch(Exception e){
				displayUserMessage("An error has occurred: " + e.getMessage());
			}
		}
		else
		{
			displayUserMessage("You have no contacts!  Please add a contact before saving.");
		}
		return false;
	}

	public boolean saveContactsAsXML(File contactFile) {
		if(getContactListSize() > 0)
		{
			if (contactFile == null) 
			{
				contactFile = defaultContactFile;
			}
			
			try
			{
				deleteFile(contactFile);
				
				for (Contact c : contactList) {
					c.setOutputFileStrategy(strategyXML);
					c.writeContactToFile(contactFile.getAbsolutePath());
				}
			}
			catch(Exception e){
				displayUserMessage("An error has occurred: " + e.getMessage());
			}
		}
		else
		{
			displayUserMessage("You have no contacts!  Please add a contact before saving.");
		}
		
		return false;
	}

	public boolean saveContactsAllFormats() {
		if(getContactListSize() > 0)
		{
			if (contactFile == null) {
				contactFile = defaultContactFile;
			}
	
			try
			{
				deleteFile(contactFile);
				
				for (Contact c : contactList) {
					c.setOutputFileStrategy(strategyTxt);
					c.writeContactToFile(contactFile.getAbsolutePath());
	
					c.setOutputFileStrategy(strategyHTML);
					c.writeContactToFile(contactFile.getAbsolutePath());
	
					c.setOutputFileStrategy(strategyXML);
					c.writeContactToFile(contactFile.getAbsolutePath());
				}
			}
			catch(Exception e){
				displayUserMessage("An error has occurred: " + e.getMessage());
			}
		}
		else
		{
			displayUserMessage("You have no contacts!  Please add a contact before saving.");
		}
		
		return false;
	}

	//methods for controlling displays
	public void showAddGUI() 
	{
		addedContact = true;
		editContact = false;
		changeMade = false;
		addEditFrame.setVisible(true);
		GUITemplate.hideDisplay();
		notifyViews();
	}
	
	public void showEditGUI() 
	{
		addedContact = false;
		editContact = true;
		changeMade = false;
		addEditFrame.setVisible(true);
		GUITemplate.hideDisplay();
		notifyViews();
	}

	public void showMainGUI() 
	{
		changeMade = false;
		addEditFrame.setVisible(false);
		GUITemplate.displayGUI();
		notifyViews();
	}
	
	public void deleteFile(File fileName)
	{
		if (fileName.exists()){fileName.delete();}
	}

	public void deleteContact() 
	{
		contactList.removeContact(getContactFromContactList());
		changeMade = true;
		notifyViews();
	}

	public void commitEdit(Contact c)
	{
		deleteContact();
		addContactToContactList(c);
		showMainGUI();
		notifyViews();
	}
	

	//Data validation methods
	public boolean validateFullName(String fullName) 
	{
		validFullName = ValidateInput.isValidNameOrCity(fullName);
		
		if(validFullName)
		{
			this.fullName = fullName;
			return true;
		}
		else
		{
			displayUserMessage("The contact full name is required. Please enter a value");
			return false;
		}
	}
	
	public boolean validateStreet(String street)
	{
		validStreet = (street.length() > 0);
		
		if(validStreet)
		{
			this.street = street;
			return true;
		}
		else
		{
			displayUserMessage("The contact street is required. Please enter a value");
			return false;
		}
	}
	
	public boolean validateCity(String city)
	{
		validCity = ValidateInput.isValidNameOrCity(city);
		
		if(validCity)
		{
			this.city = city;
			return true;
		}
		else
		{
			displayUserMessage("The contact city is required. Please enter a value");
			return false;
		}
	}

	public boolean validateZipCode(String zipCode) 
	{
		validZipCode = ValidateInput.isValidZipCode(zipCode);
		
		if(validZipCode)
		{
			this.zipCode = zipCode;
			return true;
		}
		else
		{
			displayUserMessage("The zip code you entered is not in the correct format. Please enter a five digit zip code.");
			return false;
		}
	}

	public boolean validatePhone(String phone) 
	{
		validPhone = ValidateInput.isValidPhoneNbr(phone);
		
		if(validPhone)
		{
			this.phone = phone;
			return true;
		}
		else
		{
			displayUserMessage("The phone number you entered is not in the correct format. An example of the correct format would be 123-456-7890. Please reenter.");
			return false;
		}
	}

	public boolean validateEmail(String email) 
	{
		validEmail = ValidateInput.isValidEmail(email);
		
		if(email.length()== 0){validEmail = true;}
		
		if(validEmail)
		{
			this.email = email;
			return true;
		}
		else
		{
			displayUserMessage("The email you entered is not in the correct format.  Please reenter or leave blank");
				rturn false;
			}
		}
	
	//Displays a message to the user
    private void displayUserMessage(String message)
    {
    	JOptionPane.showMessageDialog(null, message);
    }
    
    //Checks to see if all fields in the GUI have valid data entered
    public static boolean checkIfAllDataEntered()
    {
    	return  ((validFullName == true) && (validStreet == true) && (validCity == true) && 
    			(validZipCode == true) && (validPhone == true) && (validEmail == true));
    }

    

	
}
