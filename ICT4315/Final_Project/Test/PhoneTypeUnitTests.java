package ict4315.finalproject;

import static org.junit.Assert.*;
import ict4315.finalproject.BaseClasses.HelperClasses.PhoneType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhoneTypeUnitTests {
	
	@Before
	public void setUp() throws Exception 
	{
		PhoneType.getValues();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetSizeOfArrayShouldEqualFourExpectTrue() 
	{
		//Assert
		assertEquals("The wrong array size was returned.  Size should have been four", PhoneType.size(), 4);
	}

	@Test
	public void testCheckThatStringReturnedValidIndex0ReturnsValueHome() 
	{
		//Arrange
		String returnedValue;
		returnedValue = PhoneType.stringAtIndex(0);
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been 'Home'", returnedValue, "Home");
	}
	
	@Test
	public void testCheckThatStringReturnedInvalidIndex4ReturnsValueInvalid() 
	{
		//Arrange
		String returnedValue;
		returnedValue = PhoneType.stringAtIndex(4);
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been 'Invalid'", returnedValue, "Invalid");
	}
	
	@Test
	public void testCheckThatIntReturnedForItemInListIsValid() 
	{
		//Arrange
		int returnedValue;
		returnedValue = PhoneType.indexOf("Home");
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been '0'", returnedValue, 0);
	}
	
	@Test
	public void testCheckThatIntReturnedForItemInListIsInvalid() 
	{
		//Arrange
		int returnedValue;
		returnedValue = PhoneType.indexOf("Crocodile");
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been '-1'", returnedValue, -1);
	}


}
