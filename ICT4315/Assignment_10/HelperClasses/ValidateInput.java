package ict4315.assignment10.HelperClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

	/**
	 * @author Frederick McGovern
	 * @version 1.6
	 * @since 2014-05-16
	 * 
	 * This is a class that performs validation of various data points 
	 * many through the utilization of regular expressions. All inputs
	 * need to be of type String. All methods return a
 	 * boolean to indicate if the input value is valid.
 	 */

public class ValidateInput {
	
	/**
	 * A method to check to see if the input entered is of valid format
	 * representing a persons name or city. A valid format is any input that
	 * contains only alphabetic characters, hypens, single quotes periods or
	 * spaces. If any number is contained in the input string it will result in
	 * a return of false. It will return true if all conditions are true. A null
	 * input will return false.
	 */
	public static boolean isValidNameOrCity(String input){
		return (input != null) && (input.matches("[a-zA-Z-.'\\s]+"));}

	/**
	 * A method to check to see if the input entered matches one of the fifty
	 * states. It will return true if a match is found. A null input will return
	 * false.
	 */
	public static boolean isValidState(String input) {
		// Create a Pattern 
		Pattern expression = Pattern
				.compile("AL|AK|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|"
						+ "LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|"
						+ "OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY");

		// Match regular expression to contactState and return boolean based on if match found
		if ((input != null) && (input.length() == 2)) 
		{
			Matcher matcher = expression.matcher(input.toUpperCase());
			return matcher.matches();
		} else {return false;}}

	/**
	 * A method to check to see if the input entered is of valid format
	 * representing a zip code. A valid format is any input of length equal to 5
	 * that contains all numerals. It will return true if all conditions are
	 * true. A null input will return false.
	 */
	public static boolean isValidZipCode(String input) {
		return ((input != null) && (input.matches("\\d{5}")));}

	/**
	 * A method to check to see if the input entered is of valid format. A valid
	 * format is any input of length equal to 10 that contains all numerals with
	 * no leading zero in either the first or second set of numbers. It will
	 * return true if all conditions are true A null phone number will return
	 * false
	 */
	public static boolean isValidPhoneNbr(String input) {
		return (input != null) && 
				(input.matches("^(?>\\(\\d{3}\\) ?|\\d{3}[.-]?)?\\d{3}[.-]?\\d{4}$"));}

	/**
	 * A method to check to see if the input entered is of valid format
	 * representing an email. A valid format checks specific conditions such as
	 * the presence of an @ symbol. It will return true if all conditions are
	 * true or if email. A null input will return false
	 */
	public static boolean isValidEmail(String input) {
		// Create regular expression
		Pattern expression = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// Match regular expression to contactEmail and return boolean based on
		// if match found
		if ((input != null) && (input.isEmpty() == false)) {
			Matcher matcher = expression.matcher(input);
			return matcher.matches();
		} else {return false;}}
	
	/**
	 * A method to check to see if the input value consists only of numeric values.
	 * A null input will return false.
	 */
	 public static boolean isNumeric(String input) { 
		 return ((input != null) && input.matches("\\d*"));}
	 

}
