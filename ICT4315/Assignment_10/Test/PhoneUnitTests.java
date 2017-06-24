package ict4315.assignment10;

import static org.junit.Assert.*;
import ict4315.assignment10.BaseClasses.Phone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhoneUnitTests {
	
	private Phone p;

	@Before
	public void setUp() throws Exception {this.p = new Phone("777-888-9999", "Cell");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetPhoneNumberToEnsureCorrectNumberIsReturned() 
	{
		assertEquals("The wrong phone number was returned", p.getPhoneNumber(), "(777) 888-9999");
	}
	
	@Test
	public void testgetAreaCodeToEnsureCorrectAreaCodeIsReturned() 
	{
		assertEquals("The wrong area code was returned", p.getAreaCode(), "777");
	}
	
	@Test
	public void testgetPrefixToEnsureCorrectPrefixIsReturned() 
	{
		assertEquals("The wrong prefix was returned", p.getPrefix(), "888");
	}
	
	@Test
	public void testgetLineNumberToEnsureCorrectPhoneTypeIsReturned() 
	{
		assertEquals("The wrong line number was returned", p.getLineNumber(), "9999");
	}
	
	@Test
	public void testgetToStringToEnsureCorrectOutputIsReturned() 
	{
		assertEquals("The wrong output was returned", p.to_string(), "(777) 888-9999 - Cell");
	}
	
	@Test
	public void testgetPhoneTypeToEnsureCorrectLineNumberIsReturned() 
	{
		assertEquals("The wrong phone type was returned", p.getPhoneType(), "Cell");
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenNumberIsInvalid() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Phone p1 = new Phone("77-888-99", "Cell");
			 fail("Expected IllegalArgumentException when phone number arg is invalid");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}
	
	@Test
	public void testConstructorCallsIllegalArgumentExceptionWhenNumberIsNull() 
	{
		 try 
		 {
			 @SuppressWarnings("unused")
			Phone p1 = new Phone(null, "Cell");
			 fail("Expected IllegalArgumentException when phone number arg is null");
		 } 
		 catch (IllegalArgumentException expected) 
		 {
		 // ignore this because it means the test passed!
		 }
	}

}
