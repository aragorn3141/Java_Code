package ict4315.finalproject.BaseClasses;

import ict4315.finalproject.BaseClasses.HelperClasses.ValidateInput;



/**
 * @author Frederick McGovern
 * @version 1.1
 * @since 2014-05-31
 * 
 * Represents a phone number and phone type. A person can have
 * multiple phone numbers.
 */

public class Phone {

// Private Member Variables
/**
 * The area code of this phone.
 */
private String areaCode;

/**
 * The prefix of this phone.
 */
private String prefix;

/**
 * The line number of this phone.
 */
private String lineNumber;

/**
 * The type of this phone.
 */
private String phoneType;

// Constructor
/**
 * Creates a new Phone with the given phone number and phone type. The phone
 * number should be ten digits not including any parenthesis or hyphens.
 */
public Phone(String fullPhoneNumber, String phoneType) {
	setPhoneNumber(fullPhoneNumber);
	this.setPhoneType(phoneType);}

// Getter methods
/**
 * A public method to get the area code of this phone.
 */
public String getAreaCode() {return areaCode;}

/**
 * A public method to get the prefix of this phone.
 */
public String getPrefix() {return prefix;}

/**
 * A public method to get the line number of this phone.
 */
public String getLineNumber() {return lineNumber;}

/**
 * A public method to get the full phone number of this phone.
 */
public String getPhoneNumber() {return ("(" + getAreaCode() + ") " + 
		getPrefix() + "-" + getLineNumber());}

/**
 * A public method to get the phone type of this phone.
 */
public String getPhoneType() {return phoneType;}

// Public setter methods
/**
 * A public method to replace the existing phone number of a Phone object
 * with another valid phone number
 */
public void setPhoneNumber(String phoneNumber) {
	if (ValidateInput.isValidPhoneNbr(phoneNumber)) {
		String newPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");

		setAreaCode(newPhoneNumber.substring(0, 3));
		setPrefix(newPhoneNumber.substring(3, 6));
		setLineNumber(newPhoneNumber.substring(6));} 
	else {throw new IllegalArgumentException("The phone number format is invalid");		}
}

/**
 * A public method to replace the existing phone type of a Phone object with
 * another phone type
 */
public void setPhoneType(String phoneType) {this.phoneType = phoneType;}

// Private setter methods used internally
/**
 * A private method to set the area code of this phone.
 */
private void setAreaCode(String areaCode) {this.areaCode = areaCode;}

/**
 * A private method to set the prefix of this phone.
 */
private void setPrefix(String prefix) {this.prefix = prefix;}

/**
 * A private method to set the line number of this phone.
 */
private void setLineNumber(String lineNumber) {this.lineNumber = lineNumber;}


// Other public methods
/**
 * A method to return a concise but informative representation of a Phone
 * that is easy for a person to read.
 */
public String to_string() {return getPhoneNumber() + " - " + getPhoneType();}
}


