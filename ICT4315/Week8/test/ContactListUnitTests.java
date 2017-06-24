package ict4315.assignment8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactListUnitTests {
	
	private ContactList contactList;
	private Contact c1;
	private Contact c2;
	private String listFullName;
	

	@Before
	public void setUp() throws Exception 
	{
		this.contactList = new ContactList();
		this.c1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", "617-855-2431", "JCochoran14@yahoo.com");
		this.c2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", "339-933-6405", null);
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
