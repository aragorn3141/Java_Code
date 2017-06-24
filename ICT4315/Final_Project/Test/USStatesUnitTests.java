package ict4315.finalproject;

import static org.junit.Assert.*;
import ict4315.finalproject.BaseClasses.HelperClasses.USStates;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class USStatesUnitTests {

	@Before
	public void setUp() throws Exception 
	{
		USStates.getValues();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetSizeOfArrayShouldEqualFiftyOneExpectTrue() 
	{
		//Assert
		assertEquals("The wrong array size was returned.  Size should have been fifty one", USStates.size(), 51);
	}

	@Test
	public void testCheckThatStringReturnedValidIndex0ReturnsValueAL() 
	{
		//Arrange
		String returnedValue;
		returnedValue = USStates.stringAtIndex(0);
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been 'AL'", returnedValue, "AL");
	}
	
	@Test
	public void testCheckThatStringReturnedInvalidIndex51ReturnsValueInvalid() 
	{
		//Arrange
		String returnedValue;
		returnedValue = USStates.stringAtIndex(51);
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been 'Invalid'", returnedValue, "Invalid");
	}
	
	@Test
	public void testCheckThatIntReturnedForItemCapitalizedInListIsValid() 
	{
		//Arrange
		int returnedValue;
		returnedValue = USStates.indexOf("MA");
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been '19'", returnedValue, 19);
	}
	
	@Test
	public void testCheckThatIntReturnedForItemLowerCaseInListIsValid() 
	{
		//Arrange
		int returnedValue;
		returnedValue = USStates.indexOf("ma");
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been '19'", returnedValue, 19);
	}
	
	@Test
	public void testCheckThatIntReturnedForItemInListIsInvalid() 
	{
		//Arrange
		int returnedValue;
		returnedValue = USStates.indexOf("Crocodile");
		
		//Assert
		assertEquals("The wrong value was returned.  The value should have been '-1'", returnedValue, -1);
	}


}
