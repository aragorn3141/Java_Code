package ict4315.assignment8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Frederick McGovern
* @version 1.4
* @since 2014-05-16
* 
* This is a class that performs validation of various data points
* through the utilization of regular expressions.  All methods
* return a boolean to indicate if the input value is valid
*/

public class ValidateInput 
{
    /**
     * A method to check to see if the state entered matches one
     * of the fifty states.  It will return true if a match is found.
     */
	public static boolean isValidState(String contactState) 
	{
		// create regular expression
		Pattern expression = 
		Pattern.compile("AL|AK|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|" +
		"LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|" +
		"TN|TX|UT|VA|VT|WA|WI|WV|WY");
		
		//match regular expression to contactState and return boolean based on if match found
		
		Matcher matcher = expression.matcher(contactState.toUpperCase());
		
		return matcher.matches();
	}

    /**
     * A method to check to see if the zip code entered is of valid 
     * format. A valid format is any input of length equal to 5
     * that contains all numerals.
     * It will return true if all conditions are true
     */
	public static boolean isValidZipCode(String contactZipCode) 
	{
		return ((contactZipCode.length() == 5)&&(contactZipCode.matches("\\d{5}")));  
	}

    /**
     * A method to check to see if the phone number entered is of valid 
     * format. A valid format is any input of length equal to 10
     * that contains all numerals with no leading zero in either the first
     * or second set of numbers.
     * It will return true if all conditions are true
     */
	public static boolean isValidPhone(String contactPhone) 
	{
		return contactPhone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
	}
	
    /**
     * A method to check to see if the email entered is of valid 
     * format. A valid format checks specific conditions such as
     * the presence of an @ symbol.
     * It will return true if all conditions are true
     */
	public static boolean isValidEmail(String contactEmail) 
	{
		
		// create regular expression
		Pattern expression = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		//match regular expression to contactEmail and return boolean based on if match found
		
		if(contactEmail != null)
		{
			Matcher matcher = expression.matcher(contactEmail);
			return matcher.matches();
		}
		else
		{
			return false;
		}
	}
}

