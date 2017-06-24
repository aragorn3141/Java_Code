package ict4315.assignment10.BaseClasses;

import ict4315.assignment10.HelperClasses.ValidateInput;
import ict4315.assignment10.OutputStrategies.CreateFileOutput;


/**
 * @author Frederick McGovern
 * @version 1.8
 * @since 2014-05-18
 * 
 *        Represents a contact. A contact is made up of a Full name Address,
 *        Phone and E-Mail.
 */

public class Contact {

	// Private Member Variables

	/**
	 * The file output strategy being used to print a contact to a file.
	 */
	private CreateFileOutput outputFileStrategy;

	/**
	 * The full name for this contact.
	 */
	private String fullName;

	/**
	 * The street portion of this contacts address.
	 */
	private String street;

	/**
	 * The city portion of this contacts address.
	 */
	private String city;

	/**
	 * The state portion of this contacts address.
	 */
	private String state;

	/**
	 * The zip code portion of this contacts address.
	 */
	private String zipCode;

	/**
	 * The phone number and phone type for this contact.
	 */
	private Phone phone;

	/**
	 * The email address for this contact.
	 */
	private String email;

	// Constructor
	/**
	 * Creates a new Contact with the given full name, address, a Phone object.
	 * and email address. Email is an optional data element
	 */
	public Contact(String fullName, String street, String city, String state,
			String zipCode, Phone phone, String email) {
		setFullName(fullName);
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setPhone(phone);
		setEmail(email);
	}

	// Getter methods
	/**
	 * A public method to get the full name of this contact.
	 */
	public String getFullName() {return fullName;}

	/**
	 * A public method to get the street portion of this contact's address.
	 */
	public String getStreet() {return street;}

	/**
	 * A public method to get the street portion of this contact's address.
	 */
	public String getCity() {return city;}

	/**
	 * A public method to get the street portion of this contact's address.
	 */
	public String getState() {return state;}

	/**
	 * A public method to get the street portion of this contact's address.
	 */
	public String getZipCode() {return zipCode;}

	/**
	 * A public method to get the Phone object for this contact.
	 */
	public Phone getPhone() {return phone;}

	/**
	 * A public method to get the email address for this contact.
	 */
	public String getEmail() {return email;}

	// Setter methods
	/**
	 * A public method to set the contacts full name. The full name will not change
	 * from the previous name if this method is passed a null. If a previous
	 * name doesn't exist and the input is invalid or null, an IllegalArgumentException
	 * error will be thrown.
	 */
	public void setFullName(String inputFullName) 
	{
		if (ValidateInput.isValidNameOrCity(inputFullName)) {
			fullName = inputFullName;
		} else if (fullName == null) {
			throwErrorMessage(inputFullName, "name");
		} else if (inputFullName != null){displayErrorMessage("name");}
	}

	/**
	 * A public method to set the street portion of a contacts address. The street attribute
	 * will accept any character so validation is not required. If a previous
	 * street doesn't exist and the input is null, an IllegalArgumentException
	 * error will be thrown.
	 */
	public void setStreet(String inputStreet) 
	{
		if(inputStreet != null) {
			street = inputStreet;
		} else if (street == null) {
			throwErrorMessage(inputStreet, "street");
		}
	}

	/**
	 * A public method to set the city portion of a contacts address. The city will not change
	 * from the previous city if this method is passed a null. If a previous
	 * city doesn't exist and the input is invalid or null, an IllegalArgumentException
	 * error will be thrown.
	 */
	public void setCity(String inputCity) 
	{
		if (ValidateInput.isValidNameOrCity(inputCity)) {
			city = inputCity;
		} else if (city == null) {
			throwErrorMessage(inputCity, "city");
		} else if (inputCity != null){displayErrorMessage("city");}
	}
	
	/**
	 * A public method to set the state portion of a contacts address. The state will not change
	 * from the previous state if this method is passed a null. If a previous
	 * state doesn't exist and the input is invalid or null, an IllegalArgumentException
	 * error will be thrown.
	 */
	public void setState(String inputState) 
	{
		if (ValidateInput.isValidState(inputState)) {
			state = inputState;
		} else if (state == null) {
			throwErrorMessage(inputState, "state");
		} else if (inputState != null){displayErrorMessage("state");}
	}

	/**
	 * A public method to set the zip code portion of a contacts address. The zip code will 
	 * not change from the previous zip code if this method is passed a null. If a 
	 * previous zip code doesn't exist and the input is invalid or null, an 
	 * IllegalArgumentException error will be thrown.
	 */
	public void setZipCode(String inputZipCode) 
	{
		if (ValidateInput.isValidZipCode(inputZipCode)) {
			zipCode = inputZipCode;
		} else if (zipCode == null) {
			throwErrorMessage(inputZipCode, "zip code");
		} else if (inputZipCode != null){displayErrorMessage("zip code");}
	}
	
	/**
	 * A public method to set the contacts email address. The email address will not change
	 * from the previous email address if this method is passed a null. If a previous
	 * email address doesn't exist and the input is invalid or null, an 
	 * IllegalArgumentException error will be thrown.
	 */
	public void setEmail(String inputEmail)  
	{
		if (ValidateInput.isValidEmail(inputEmail)) {
			email = inputEmail;
		} else if ((email == null) && (inputEmail !=null)) {
			throwErrorMessage(inputEmail, "email address");
		} else if (inputEmail != null){displayErrorMessage("email address");}
	}
	
	/**
	 * A public method to set the contacts phone info. The phone class validates
	 * the input that creates the Phone object so no validation is required here. 
	 * If a previous Phone object doesn't exist and the input is null, an 
	 * IllegalArgumentException error will be thrown.
	 */
	public void setPhone(Phone inputPhone) 
	{
		if(inputPhone != null) {
			phone = inputPhone;
		} else if (phone == null) {
			throwErrorMessage(null, "phone information");
		}
	}
	
	/**
	 * A public method for setting the output strategy that is used 
	 * when printing a contact to a file.
	 */
	public void setOutputFileStrategy(CreateFileOutput fo)
	{
		outputFileStrategy = fo;
	}
	
	//Other public methods
	/**
	 * A public method to write a contact out to a file at a specified location.
	 */
	public void writeContactToFile(String fileLoc)
	{
		outputFileStrategy.writeContact(this, fileLoc);
	}
	
	/**
	 * A public method that concatenates all Address elements in order to more 
	 * neatly print out the address.
	 */
	public String Address_To_String()
	{
		return this.street + " " + this.city + ", " + this.state + " " + this.zipCode;
	}
	
	//Private methods
	/**
	 * A private method to print out a message to the user that a 
	 * desired input contains invalid characters.
	 */
	private void displayErrorMessage(String input)
	{
		System.out.println("The " + input + " entered contains invalid characters.  " +
				"Contact " + input + " will not be changed.");
	}
	
	/**
	 * A private method to throw an error message due to invalid or null input values.
	 */
	private void throwErrorMessage(String input, String userFieldName) {
		if (input != null) {
			throw new IllegalArgumentException("The " + userFieldName
					+ " entered is not a valid " + userFieldName);
		} else {
			throw new IllegalArgumentException("The " + userFieldName
					+ " must be entered");
		}
	}
}
