package ict4315.assignment10;

import static org.junit.Assert.*;
import ict4315.assignment10.HelperClasses.ValidateInput;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidateInputUnitTests {
	
	private String name;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNbr;
	private String email;

	@Before
	public void setUp() throws Exception {
		name = new String("James O'Brien");
		street = new String("123 Testing Avenue");
		city = new String("Jameston");
		state = new String("RI");
		zipCode = new String("45678");
		phoneNbr = new String("123-456-7890");
		email = new String("unittestsrock45@du.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//Test isValidNameOrCity
	@Test
	public void testIsValidNameOrCityWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidNameOrCity(name));
		
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidNameOrCity(city));}
	
	@Test
	public void testIsValidNameOrCityWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isValidNameOrCity(street));}
		
	@Test
	public void testIsValidNameOrCityWhenPassedInvalidValueAllNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
			ValidateInput.isValidNameOrCity(zipCode));}
	
	@Test
	public void testIsValidNameOrCityWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
				ValidateInput.isValidNameOrCity(null));}
	
	//Test isValidState
	@Test
	public void testIsValidStateWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidState(state));}
	
	@Test
	public void testIsValidStateWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isValidState(street));}
		
	@Test
	public void testIsValidStateWhenPassedInvalidValueAllNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
			ValidateInput.isValidState(zipCode));}
	
	@Test
	public void testIsValidStateWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
				ValidateInput.isValidState(null));}
	
	//Test isValidZipCode
	@Test
	public void testIsValidZipCodeeWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidZipCode(zipCode));}
	
	@Test
	public void testIsValidZipCodeWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isValidZipCode(street));}
		
	@Test
	public void testIsValidZipCodeWhenPassedInvalidValueNoNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
			ValidateInput.isValidZipCode(name));}
	
	@Test
	public void testIsValidZipCodeWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
				ValidateInput.isValidZipCode(null));}
	
	//Test isValidPhone
	@Test
	public void testIsValidPhoneNbrWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidPhoneNbr(phoneNbr));}
	
	@Test
	public void testIsValidPhoneNbrWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isValidPhoneNbr(street));}
		
	@Test
	public void testIsValidPhoneNbrWhenPassedInvalidValueAllNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
			ValidateInput.isValidPhoneNbr(zipCode));}
	
	@Test
	public void testIsValidPhoneNbrWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
					ValidateInput.isValidPhoneNbr(null));}
	
	//Test isValidEmail
	@Test
	public void testIsValidEmailWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isValidEmail(email));}
	
	@Test
	public void testIsValidEmailWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isValidEmail(street));}
		
	@Test
	public void testIsValidEmailWhenPassedInvalidValueAllNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
			ValidateInput.isValidEmail(zipCode));}
	
	@Test
	public void testIsValidEmailWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
					ValidateInput.isValidEmail(null));}
	
	//Test isNumeric
	@Test
	public void testIsNumericWhenPassedValidValueExpectingTrue(){
		assertTrue("The input value was valid so this should have returned true", 
				ValidateInput.isNumeric(zipCode));}
	
	@Test
	public void testIsNumericWhenPassedInvalidValueWithNbrsExpectingFalse(){
		assertFalse("The input value was invalid so this should have returned false", 
				ValidateInput.isNumeric(phoneNbr));}
	@Test
	public void testIsNumericWhenPassedNullValueExpectingFalse(){
		assertFalse("The input value was null so this should have returned false", 
					ValidateInput.isNumeric(null));}
		
}
