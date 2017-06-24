package ict4315.assignment7;

import static org.junit.Assert.*;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public  class ContactUnitTests {
	
	private Contact c;

	@Before
	public void setUp() throws Exception 
	{
		this.c = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", "617-855-2431", "JCochoran14@yahoo.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetFullNameToEnsureCorrectNameIsReturned() 
	{
		assertEquals("The wrong contact name was returned", c.getFullName(), "James Cochoran");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenNameIsNull() 
	{
		 try 
		 {
			 Contact c1 = new Contact(null, "6 Happy Birthday Rd", "Jamestown", "RI", "14556", "339-876-4550", "myBestFriendRon@gmail.com");;
			 fail("Expected IllegalArgumentException when name arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testsetFullNameToEnsureNameDoesntChangeWhenPassedANull() 
	{
		//Arrange
		String origFullName;
		origFullName = c.getFullName();
		
		//Act
		c.setFullName(null);
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been unchanged", c.getFullName(), origFullName);
	}
	
	
	@Test
	public void testsetFullNameToEnsureNameDoesChangeWhenPassedAValidName() 
	{
		//Act
		c.setFullName("Barbara Long");
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been changed", c.getFullName(), "Barbara Long");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenStreetIsNull() 
	{
		 try 
		 {
			 Contact c1 = new Contact("John Carter", null, "Roanoake", "VI", "54412", "339-876-4550", "14MarsBound@gmail.com");
			 fail("Expected IllegalArgumentException when street arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenCityIsNull() 
	{
		 try 
		 {
			 Contact c1 = new Contact("Kim Reynolds", "45 Johnson Ln", null, "SC", "41238", "652-895-2636", "KReynolds@aol.com");
			 fail("Expected IllegalArgumentException when city arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenStateIsNull() 
	{
		 try 
		 {
			 Contact c1 = new Contact("Harold Higgins", "3698 Lancaster Blvd", "Hope", null, "01254", "458-125-0089", "HigginsH42@gmail.com");
			 fail("Expected IllegalArgumentException when state arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenZipCodeIsNull() 
	{
		 try 
		 {
			 Contact c1 = new Contact("Timothy Gropple", "2354 GrandView Terr", "Numeral", "CT", null, "568-472-1004", "TGropple@hotmail.com");
			 fail("Expected IllegalArgumentException when state arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testsetStreetToEnsureStreetDoesntChangeWhenPassedANull() 
	{
		//Arrange
		String origStreet;
		origStreet = c.getStreet();
		
		//Act
		c.setStreet(null);
		
		//Assert
		assertEquals("The wrong contact street was returned.  Street should have been unchanged", c.getStreet(), origStreet);
	}
	
	@Test
	public void testsetStreetToEnsureStreetDoesChangeWhenPassedAValidName() 
	{
		//Act
		c.setStreet("1 Tower Circle Apt 56");
		
		//Assert
		assertEquals("The wrong contact street was returned.  Street should have been changed", c.getStreet(), "1 Tower Circle Apt 56");
	}
	
	@Test
	public void testsetCityToEnsureCityDoesntChangeWhenPassedANull() 
	{
		//Arrange
		String origCity;
		origCity = c.getCity();
		
		//Act
		c.setCity(null);
		
		//Assert
		assertEquals("The wrong contact city was returned.  City should have been unchanged", c.getCity(), origCity);
	}
	
	@Test
	public void testsetCityToEnsureCityDoesChangeWhenPassedAValidName() 
	{
		//Act
		c.setCity("Plymouth");
		
		//Assert
		assertEquals("The wrong contact city was returned.  City should have been changed", c.getCity(), "Plymouth");
	}
	
	@Test
	public void testsetStateToEnsureStateDoesntChangeWhenPassedANull() 
	{
		//Arrange
		String origState;
		origState = c.getState();
		
		//Act
		c.setState(null);
		
		//Assert
		assertEquals("The wrong contact state was returned.  State should have been unchanged", c.getState(), origState);
	}
	
	@Test
	public void testsetStateToEnsureStateDoesChangeWhenPassedAValidName() 
	{
		//Act
		c.setState("MI");
		
		//Assert
		assertEquals("The wrong contact state was returned.  State should have been changed", c.getState(), "MI");
	}
	
	@Test
	public void testsetStateToMakeSureIllegalArgumentExceptionCalledWhenStateIsInvalid() 
	{
		 try 
		 {
			c.setState("MY");
			fail("Expected IllegalArgumentException when state arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testsetZipCodeToEnsureZipCodeDoesntChangeWhenPassedANull() 
	{
		//Arrange
		String origZipCode;
		origZipCode = c.getZipCode();
		
		//Act
		c.setZipCode(null);
		
		//Assert
		assertEquals("The wrong contact zip code was returned.  Zip code should have been unchanged", c.getZipCode(), origZipCode);
	}
	
	@Test
	public void testsetZipCodeToEnsureZipCodeDoesChangeWhenPassedAValidZipCode() 
	{
		//Act
		c.setZipCode("02364");
		
		//Assert
		assertEquals("The wrong contact zip code was returned.  Zip Code should have been changed", c.getZipCode(), "02364");
	}
	
	@Test
	public void testIsValidStateWhenPassedInvalidValueExpectingFalse() 
	{
		assertFalse("The state should have returned a false condition", ValidateInput.isValidState("WW")== true);
	}
	
	@Test
	public void testIsValidStateWhenPassedValidValueExpectingTrue() 
	{
		assertTrue("The state should have returned a true condition", ValidateInput.isValidState("AL")== true);
	}
	
	@Test
	public void testIsValidZipCodeWhenPassedInvalidValueExpectingFalse() 
	{
		assertFalse("The zip code should have returned a false condition", ValidateInput.isValidZipCode("W1234")== true);
	}
	
	@Test
	public void testIsValidZipCodeWhenPassedValidValueExpectingTrue() 
	{
		assertTrue("The zip code should have returned a true condition", ValidateInput.isValidZipCode("12345")== true);
	}
	
	@Test
	public void testsetZipCodeToMakeSureIllegalArgumentExceptionCalledWhenZipCodeIsInvalidDueToLetters() 
	{
		 try 
		 {
			c.setZipCode("012J5");
			fail("Expected IllegalArgumentException when zip code arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	public void testsetZipCodeToMakeSureIllegalArgumentExceptionCalledWhenZipCodeIsInvalidAllNumbers() 
	{
		 try 
		 {
			c.setZipCode("000000000");
			fail("Expected IllegalArgumentException when zip code arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testIsValidPhoneWhenPassedInvalidValueExpectingFalse() 
	{
		assertFalse("The phone number should have returned a false condition", ValidateInput.isValidPhone("123asd")== true);
	}
	
	@Test
	public void testIsValidPhoneWhenPassedValidValueExpectingTrue() 
	{
		assertTrue("The phone number should have returned a true condition", ValidateInput.isValidPhone("339-933-8001")== true);
	}
	
	@Test
	public void testsetPhoneToMakeSureIllegalArgumentExceptionCalledWhenPhoneIsInvalidDueToLetters() 
	{
		 try 
		 {
			c.setPhone("235-klj-0125");
			fail("Expected IllegalArgumentException when phone arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testsetPhoneToMakeSureIllegalArgumentExceptionCalledWhenPhoneIsInvalidDueToLeadingZero() 
	{
		 try 
		 {
			c.setPhone("012-345-6789");
			fail("Expected IllegalArgumentException when phone arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testIsValidEmailWhenPassedInvalidValueExpectingFalse() 
	{
		assertFalse("The email should have returned a false condition", ValidateInput.isValidEmail("frederick_mcgovern")== true);
	}
	
	@Test
	public void testIsValidEmailWhenPassedValidValueExpectingTrue() 
	{
		assertTrue("The email should have returned a true condition", ValidateInput.isValidEmail("Frederick_McGovern@msn.com")== true);
	}
	
	@Test
	public void testsetEmailToMakeSureIllegalArgumentExceptionCalledWhenEmailIsInvalid() 
	{
		 try 
		 {
			c.setEmail("fredmcgovern^com");
			fail("Expected IllegalArgumentException when email arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
}
