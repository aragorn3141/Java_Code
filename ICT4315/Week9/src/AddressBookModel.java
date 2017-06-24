package ict4315.assignment9;

/**
* @author Frederick McGovern
* @version 1.8
* @since 2014-05-31
* 
* This is a class that represents an address book model
*/

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class AddressBookModel{
	
	//private member variables
	private ContactList contactList  = new ContactList();
	private ContactView view;
	
	private String fullName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;
	
	private static boolean validFullName = false;
	private static boolean validStreet = false;
	private static boolean validCity = false;
	private static boolean validState = false;
	private static boolean validZipCode = false;
	private static boolean validPhone = false;
	private static boolean validEmail = false;

	//Constructors
	 public AddressBookModel()
	 {
		 this(null);
	 }
	 
	 public AddressBookModel(ContactView view)
	 {
		 InitializeData();
    	 this.view = view;
	 }
	 
	 //Setters
	public void setFullName(String fullname){this.fullName = fullname;}
    
    public void setStreet(String street){this.street = street;}
    
    public void setCity(String city){this.city = city;}
    
    public void setState(String state){this.state = state;}
    
    public void setZipCode(String zipcode){this.zipCode = zipcode;}
    
    public void setPhone(String phone){this.phone = phone;}
    
    public void setEmail(String email)
    {
    	if(email.length() == 0)
    	{
    		this.email = null;
    	}
    	else
    	{
    		this.email = email;
    	}
    }

	/**
	 * A method used to add a contact to the contact list by first creating a contact
	 */
	public void addContact(String fullName, String street, String city, String state,
			String zipcode, String phone, String email)
	{
        Contact contact = new Contact(fullName, street, city, state, zipcode, phone, email);
        addContactToContactList(contact);
    }
	
	/**
	 * A method used to add contacts to the contact list
	 */
	public void addContactToContactList(Contact contact){contactList.addContact(contact);}
	
	//Initialize the private member variables
	private void InitializeData()
	{
		 fullName = "";
		 street = "";
		 city = "";
		 state = "";
		 zipCode = "";
		 phone = "";
		 email = null;
		 
		 validFullName = false;
	   	 validStreet = false;
	   	 validCity = false;
	   	 validState = false;;
	   	 validZipCode = false;
	   	 validPhone = false;
	}

	/**
	 * A method used to output the contact list to the console
	 */
	public void outputAllContactsToConsole()
	{
		System.out.println("----------Contact List-------------------");
		System.out.println();
		
		for(Contact c : contactList)
	    {
			System.out.println("Contact Number " + (contactList.currIndex(c) + 1));
			System.out.println("Name: " + c.getFullName());
	    	System.out.println("Address: " + c.Address_To_String());
	    	System.out.println("Phone: " + c.getPhone());
	    	System.out.println("EMail: " + c.getEmail());
	    	System.out.println("---------------------------------");
	    }
		System.out.println();
		System.out.println("----------End of List-------------------");
	}
	
    //Checks to see if all fields in the GUI have valid data entered
    private boolean checkIfAllDataEntered()
    {
    	return  ((validFullName == true) && (validStreet == true) && (validCity == true) && 
    			(validState == true) && (validZipCode == true) && (validPhone == true) &&
    			(validEmail == true));
    }
    
    /**
	 * A method used to update the private member variables with data passed from the controller
	 */
    public void updateModel(String fullName, String street, String city, String state,
			String zipcode, String phone, String email)
    {
    	if(checkIfAllDataEntered())
    	{
    		setFullName(fullName);
    		setStreet(street);
    		setCity(city);
    		setState(state);
    		setZipCode(zipcode);
    		setPhone(phone);
    		setEmail(email);
    		  		
    		view.refreshContactView(fullName, street, city, state, zipcode, phone, email);
    	}
    }
    
	//Displays a message to the user
    private void displayUserMessage(String message)
    {
    	JOptionPane.showMessageDialog(null, message);
    }
    
    //Data validation methods
	public boolean validateFullName(String fullName) 
	{
		validFullName = (fullName.length() > 0);
		
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
		validCity = (city.length() > 0);
		
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

	public boolean validateState(String state) 
	{
		validState = ValidateInput.isValidState(state);
		
		if(validState)
		{
			this.state = state.toUpperCase();
			return true;
		}
		else
		{
			displayUserMessage("You entered an invalid state. Please enter a two character state abbreviation.");
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
		validPhone = ValidateInput.isValidPhone(phone);
		
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
			return false;
		}
	}
	/**
	 * A method used to assign a private member variable to an existing view 
	 */
	public void addContactView(AddressBookAddContactView view){this.view = view;}

}
