package ict4315.assignment10;

import static org.junit.Assert.*;
import ict4315.assignment10.BaseClasses.Contact;
import ict4315.assignment10.BaseClasses.ContactList;
import ict4315.assignment10.BaseClasses.Phone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactListUnitTests {
	
	private ContactList contactList;
	private Contact c1;
	private Contact c2;
	private Phone p1;
	private Phone p2;
	private String listFullName;
	

	@Before
	public void setUp() throws Exception 
	{
		contactList = new ContactList();
		
		p1 = new Phone("(472) 456-2289", "Home");
		p2 = new Phone("(393) 780-0405", "Work");
		
		
		c1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", p1, "JCochoran14@yahoo.com");
		c2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", p2, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddContactToContactListCheckFullName() 
	{
		//Arrange
		String origFullName;
		origFullName = c1.getFullName();
		
		contactList.addContact(c1);
		
		//Act
		for(Contact c : contactList)
	    {
			listFullName = c.getFullName();
	    }  
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been " + c1.getFullName(), origFullName, listFullName);
	}
	
	@Test
	public void testAddTwoContactToContactListCheckSecondName() 
	{
		//Arrange
		String origSecondFullName;
		origSecondFullName = c2.getFullName();
		
		contactList.addContact(c1);
		contactList.addContact(c2);
		
		//Act
		int i = 0;
		for(Contact c : contactList)
	    {
			i += 1;
			if(i == 2)
			{
				listFullName = c.getFullName();
			}
	    }  
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been " + c2.getFullName(), origSecondFullName, listFullName);
	}
	
	@Test
	public void testAddTwoContactToContactListCheckSize() 
	{
		//Arrange
		contactList.addContact(c1);
		contactList.addContact(c2);
		
		//Assert
		assertTrue("The wrong size was returned. Size should be equal to 2", contactList.Size() == 2);
	}
	
	@Test
	public void testAddTwoContactToContactListCheckSecondNameWhenAttemptToRemovePriorToIterator() 
	{
		//Arrange
		String origSecondFullName;
		origSecondFullName = c2.getFullName();
		
		contactList.addContact(c1);
		contactList.addContact(c2);
		
		//Act
		contactList.removeContact(c1);
		for(Contact c : contactList)
	    {
			listFullName = c.getFullName();
	    }  
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been " + c2.getFullName(), origSecondFullName, listFullName);
	}
	
	@Test
	public void testAddTwoContactToContactListCheckSecondNameWhenAttemptToRemoveFromIterator() 
	{
		//Arrange
		String origSecondFullName;
		origSecondFullName = c2.getFullName();
		
		contactList.addContact(c1);
		contactList.addContact(c2);
		
		//Act
		int i = 0;
		for(Contact c : contactList)
	    {
			i += 1;
			if(i == 2)
			{
				listFullName = c.getFullName();
			}
			else
			{
				contactList.removeContact(c2);
			}
	    }  
		
		//Assert
		assertEquals("The wrong contact name was returned.  Name should have been " + c2.getFullName(), origSecondFullName, listFullName);
	}
}
