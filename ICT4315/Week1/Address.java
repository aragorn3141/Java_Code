/**
	* @author Frederick McGovern
	* @version 1.0
	* @since 2014-03-28
	* 
	* This class contains five private member variables: contactName, streetAddr, city, 
	* state, and zipCode.  Each private member variable has a public getter and public
	* setter method.  A toString method outputs all the values in the private members
	* utilizing the getting methods.
	*/

public class Address
{
	private String contactName, streetAddr, city, state, zipCode;

	//default constructor. 
	public Address()
	{
		contactName = "";
		streetAddr = "";
		city = "";
		state = "";
		zipCode = "";
	}
	
	//Five value constructor
	public Address(String contactName, String streetAddr, String city, String state, String zipCode)
	{
		this.contactName = contactName;
		this.streetAddr = streetAddr;
		this.city = city;
		setState(state);
		setZipCode(zipCode);
	}
	
	
	/**
	 * @return the contactName
	 */
    public String getContactName() 
    {
	    return contactName;
    }

	/**
	 * @param contactName the contactName to set
	 */
    public void setContactName(String contactName) 
    {
	    this.contactName = contactName;
    }

	/**
	 * @return the streetAddr
	 */
    public String getStreetAddr() 
    {
	    return streetAddr;
    }

	/**
	 * @param streetAddr the streetAddr to set
	 */
    public void setStreetAddr(String streetAddr) 
    {
	    this.streetAddr = streetAddr;
    }

	/**
	 * @return the city
	 */
    public String getCity() 
    {
	    return city;
    }

	/**
	 * @param city the city to set
	 */
    public void setCity(String city) 
    {
	    this.city = city;
    }

	/**
	 * @return the mailState
	 */
    public String getState() 
    {
	    return state;
    }

	/**
	 * @param mailState the mailState to set
	 */
    public void setState(String state) 
    {
	    this.state = state.substring(0,2).toUpperCase() ;
    }

	/**
	 * @return the zipCode
	 */
    public String getZipCode() 
    {
	    return zipCode;
    }

	/**
	 * @param zipCode the zipCode to set.  Forcing value to be only 5 characters in length
	 * Assumes that if length is 4 then leading zero needs to be added 
	 */
    public void setZipCode(String zipCode) 
    {
	    if (zipCode.length() == 4)
	    {
	    	this.zipCode = "0" + zipCode.substring(0, 4);
	    }
	    else
	    {
	    	this.zipCode = zipCode.substring(0, 5);
	    }
    }
    
    @Override //Overrides the object.toString method
    public String toString()
    {
    	return String.format("%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n", 
    			"Contact Name", getContactName(),
    			"Street Address", getStreetAddr(),
    			"City", getCity(),
    			"State", getState(),
    			"Zip Code", getZipCode());	
    }




	
	

    
}
