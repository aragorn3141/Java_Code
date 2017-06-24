package ict4315.assignment10;

import static org.junit.Assert.*;
import ict4315.assignment10.BaseClasses.Contact;
import ict4315.assignment10.BaseClasses.Phone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactUnitTests {
	
	private Contact c;
	private Phone p;

	@Before
	public void setUp() throws Exception 
	{
		this.p = new Phone("123-456-7890", "Home");
		this.c = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", p, "JCochoran14@yahoo.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//-------------------------Test fullName--------------------------------
	@Test
	public void testgetFullNameToEnsureCorrectFullNameIsReturned() 
	{
		assertEquals("The wrong contact name was returned", c.getFullName(), "James Cochoran");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenFullNameIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Contact c1 = new Contact(null, "6 Happy Birthday Rd", "Jamestown", "RI", "14556", p, "myBestFriendRon@gmail.com");;
			 fail("Expected IllegalArgumentException when name arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testsetFullNameToEnsureFullNameDoesntChangeWhenPassedANull() 
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
	public void testsetFullNameToEnsureFullNameDoesntChangeWhenPassedAnInvalidValue() 
	{
		//Arrange
		String origFullName;
		origFullName = c.getFullName();
		
		//Act
		c.setFullName("Geor%ge Cushman");
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been unchanged", c.getFullName(), origFullName);
	}
	
	
	@Test
	public void testsetFullNameToEnsureFullNameDoesChangeWhenPassedAValidValue() 
	{
		//Act
		c.setFullName("Barbara Long");
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been changed", c.getFullName(), "Barbara Long");
	}
	
	
	//-------------------------Test street--------------------------------

	@Test
	public void testgetStreetToEnsureCorrectStreetIsReturned() 
	{
		assertEquals("The wrong contact street was returned", c.getStreet(), "46 Robin Drive");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenStreetIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Contact c1 = new Contact("John Carter", null, "Roanoake", "VI", "54412", p, "14MarsBound@gmail.com");
			 fail("Expected IllegalArgumentException when street arg is null");
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
	
	//-------------------------Test city--------------------------------
	
	@Test
	public void testgetCityToEnsureCorrectCityIsReturned() 
	{
		assertEquals("The wrong contact street was returned", c.getCity(), "Mattapan");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenCityIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Contact c1 = new Contact("Kim Reynolds", "45 Johnson Ln", null, "SC", "41238", p, "KReynolds@aol.com");
			 fail("Expected IllegalArgumentException when city arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
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
	public void testsetCityToEnsureCityDoesntChangeWhenPassedAnInvalidValue() 
	{
		//Arrange
		String origCity;
		origCity = c.getCity();
		
		//Act
		c.setCity("7 Hills");
		
		//Assert
		assertEquals("The wrong contact city was returned.  City should have been unchanged", c.getCity(), origCity);
	}
	
	@Test
	public void testsetCityToEnsureCityDoesChangeWhenPassedAValidValue() 
	{
		//Act
		c.setCity("Plymouth");
		
		//Assert
		assertEquals("The wrong contact city was returned.  City should have been changed", c.getCity(), "Plymouth");
	}
	
	//-------------------------Test state--------------------------------
	
	@Test
	public void testgetStateToEnsureCorrectStateIsReturned() 
	{
		assertEquals("The wrong contact state was returned", c.getState(), "MA");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenStateIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Contact c1 = new Contact("Harold Higgins", "3698 Lancaster Blvd", "Hope", null, "01254", p, "HigginsH42@gmail.com");
			 fail("Expected IllegalArgumentException when state arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
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
	public void testsetStateToEnsureStateDoesntChangeWhenPassedAnInvalidValue() 
	{
		//Arrange
		String origState;
		origState = c.getState();
		
		//Act
		c.setState("MY");
		
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
	
	//-------------------------Test zip code--------------------------------
	
	@Test
	public void testgetZipCodeToEnsureCorrectZipCodeIsReturned() 
	{
		assertEquals("The wrong contact zip code was returned", c.getZipCode(), "02366");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenZipCodeIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Contact c1 = new Contact("Timothy Gropple", "2354 GrandView Terr", "Numeral", "CT", null, p, "TGropple@hotmail.com");
			 fail("Expected IllegalArgumentException when state arg is null");
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
	public void testsetZipCodeToEnsureZipCodeDoesntChangeWhenPassedAnInvalidValue() 
	{
		//Arrange
		String origZipCode;
		origZipCode = c.getZipCode();
		
		//Act
		c.setZipCode("123");
		
		//Assert
		assertEquals("The wrong contact zip code was returned.  Zip code should have been unchanged", c.getZipCode(), origZipCode);
	}
	
	@Test
	public void testsetZipCodeToEnsureZipCodeDoesChangeWhenPassedAValidZipCode() 
	{
		//Act
		c.setZipCode("98765");
		
		//Assert
		assertEquals("The wrong contact zip code was returned.  Zip Code should have been changed", c.getZipCode(), "98765");
	}
	
	//-------------------------Test Phone--------------------------------
	
		@Test
		public void testgetPhoneToEnsureCorrectPhoneIsReturned() 
		{
			assertEquals("The wrong contact zip code was returned", c.getPhone(), p);
		}
		
		@Test
		public void testConstructorCallsIllegalArgumentExceptionWhenPhoneIsNull() 
		{
			 try 
			 {
				 @SuppressWarnings("unused")
				Contact c1 = new Contact("Harry Burncoat", "17 George Jackson Ln", "Kingston", "SC", "48120", null, "14CowboyatHeart@gmail.com");;
				 fail("Expected IllegalArgumentException when name arg is null");
			 } 
			 catch (IllegalArgumentException expected) 
			 {
			 // ignore this because it means the test passed!
			 }
		}
		
		@Test
		public void testsetPhoneToEnsurePhoneDoesntChangeWhenPassedANull() 
		{
			//Arrange
			Phone origPhone;
			origPhone = c.getPhone();
			
			//Act
			c.setPhone(null);
			
			//Assert
			assertEquals("The wrong contact phone was returned.  Phone should have been unchanged", c.getPhone(), origPhone);
		}
		
		@Test
		public void testsetPhoneToEnsurePhoneDoesChangeWhenPassedAValidPhone() 
		{
			//Act
			Phone p1 = new Phone("339-244-7872", "home");
			c.setPhone(p1);
			
			//Assert
			assertEquals("The wrong Phone was returned.  Phone should have been changed", c.getPhone(), p1);
		}
		
		//-------------------------Test Email--------------------------------
		
		@Test
		public void testgetEmailToEnsureCorrectEmailIsReturned() 
		{
			assertEquals("The wrong contact email was returned", c.getEmail(), "JCochoran14@yahoo.com");
		}
		
		@Test
		public void testsetEmailToEnsureEmailDoesntChangeWhenPassedANull() 
		{
			//Arrange
			String origEmail;
			origEmail = c.getEmail();
			
			//Act
			c.setEmail(null);
			
			//Assert
			assertEquals("The wrong contact email was returned.  Email should have been unchanged", c.getEmail(), origEmail);
		}
		
		@Test
		public void testsetEmailToEnsureEmailDoesntChangeWhenPassedAnInvalidValue() 
		{
			//Arrange
			String origEmail;
			origEmail = c.getEmail();
			
			//Act
			c.setEmail("BobTheBuilder742hotmail.com");
			
			//Assert
			assertEquals("The wrong contact email was returned.  Email should have been unchanged", c.getEmail(), origEmail);
		}
		
		@Test
		public void testsetEmailToEnsureEmailDoesChangeWhenPassedAValidEmail() 
		{
			//Act
			c.setEmail("DogsAreCoolAndCatsArent71@yahoo.com");
			
			//Assert
			assertEquals("The wrong contact email was returned.  Email should have been changed", c.getEmail(), "DogsAreCoolAndCatsArent71@yahoo.com");
		}
		
}
