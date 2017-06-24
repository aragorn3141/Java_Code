package ict4315.assignment7;

/**
* @author Frederick McGovern
* @version 1.7
* @since 2014-05-18
* 
* This is a class that represents a contact.  A contact is made up of a Full name
* Address, Phone and E-Mail
*/
public class Contact 
{
	//Private Member Variables
	private CreateFileOutput outputFileStrategy;
	
	private String fullName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;
	
	//Constructor
    /**
     * Public constructor to create an instance of a Contact.
     */
	public Contact(String fullName, String street, String city,
			String state, String zipCode, String phone, String email) 
	{
		setFullName(fullName);
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setPhone(phone);
		setEmail(email);
	}

	//Getter methods
	
    /**
     * A method to return the contacts full name
     */
	public String getFullName() {return fullName;}
	
    /**
     * A method to return the contacts address street
     */
	public String getStreet() {return street;}
	
    /**
     * A method to return the contacts address city
     */
	public String getCity() {return city;}

    /**
     * A method to return the contacts address state
     */
	public String getState() {return state;}
	
    /**
     * A method to return the contacts address zip code
     */
	public String getZipCode() {return zipCode;}

    /**
     * A method to return the contacts phone number
     */
	public String getPhone() {return phone;}
	
    /**
     * A method to return the contacts email
     */
	public String getEmail() {return email;}
	
	//Setters
	
    /**
     * A method to set the contacts full name.  The full name 
     * will not change from the previous name if this method is 
     * passed a null
     */
	public void setFullName(String contactName) 
	{
		if(contactName != null)
		{
			fullName = contactName;
		}
		else if((fullName == null)&& (contactName == null))
		{
			throw new IllegalArgumentException("The name must be entered");
		}
	}

    /**
     * A method to set the contacts address street.  The street 
     * will not change from the previous street if this method is 
     * passed a null
     */
	public void setStreet(String contactStreet) 
	{
		if(contactStreet != null)
		{
			street = contactStreet;
		}
		else if((street == null)&& (contactStreet == null))
		{
			throw new IllegalArgumentException("The street must be entered");
		}
	}

    /**
     * A method to set the contacts address city.  The city 
     * will not change from the previous city if this method is 
     * passed a null
     */
	public void setCity(String contactCity) 
	{
		if(contactCity != null)
		{
			city = contactCity;
		}
		else if((city == null)&& (contactCity == null))
		{
			throw new IllegalArgumentException("The city must be entered");
		}
	}

    /**
     * A method to set the contacts address state.  The state 
     * will not change from the previous state if this method is 
     * passed a null or the input is deemed invalid.
     */
	public void setState(String contactState) 
	{
		if((contactState != null) && (ValidateInput.isValidState(contactState) == true))
		{
			state = contactState;		
		}
		else if((contactState != null) && (ValidateInput.isValidState(contactState) == false))
		{
			throw new IllegalArgumentException("The state entered is not a valid state");
		}
		else if((state == null)&& (contactState == null))
		{
			throw new IllegalArgumentException("The state must be entered");
		}
	}
	
    /**
     * A method to set the contacts address zip code.  The zip code 
     * will not change from the previous zip code if this method is 
     * passed a null or the input is deemed invalid.
     */
	public void setZipCode(String contactZip)
	{
		if((contactZip != null) && (ValidateInput.isValidZipCode(contactZip) == true))
		{
			zipCode = contactZip;		
		}
		else if((contactZip != null) && (ValidateInput.isValidZipCode(contactZip) == false))
		{
			throw new IllegalArgumentException("The zip code entered is not a valid zip code");
		}
		else if((zipCode == null)&& (contactZip == null))
		{
			throw new IllegalArgumentException("The zip code must be entered");
		}
	}

    /**
     * A method to set the contacts phone number.  The phone number 
     * will not change from the previous phone number if this method is 
     * passed a null or the input is deemed invalid.
     */
	public void setPhone(String contactPhone) 
	{
		if((contactPhone != null) && (ValidateInput.isValidPhone(contactPhone) == true))
		{
			phone = contactPhone;		
		}
		else if((contactPhone != null) && (ValidateInput.isValidPhone(contactPhone) == false))
		{
			throw new IllegalArgumentException("The phone entered is not a valid phone number");
		}
		else if((phone == null)&& (contactPhone == null))
		{
			throw new IllegalArgumentException("The phone must be entered");
		}
	}

    /**
     * A method to set the contacts email.  The email 
     * will not change from the previous email if the input
     * to this method is deemed invalid.
     */
	public void setEmail(String contactEmail) 
	{
		if((ValidateInput.isValidEmail(contactEmail) == true))
		{
			email = contactEmail;		
		}
		else if((contactEmail != null) && (ValidateInput.isValidEmail(contactEmail) == false))
		{
			throw new IllegalArgumentException("The email entered is not a valid email format");
		}
	}
	
	/**
	 * Allows for resetting of the output strategy that is used when printing a contact
	 */
	public void setOutputFileStrategy(CreateFileOutput fo)
	{
		outputFileStrategy = fo;
	}
	
	/**
	 * Method to write a contact out to a file at a specified location.
	 */
	public void writeContactToFile(String fileLoc)
	{
		outputFileStrategy.writeContact(this, fileLoc);
	}
	
	/**
	 * Method that concatenates all Address elements in order to more neatly print 
	 * out the address.
	 */
	public String Address_To_String()
	{
		return this.street + " " + this.city + ", " + this.state + " " + this.zipCode;
	}
	
}
