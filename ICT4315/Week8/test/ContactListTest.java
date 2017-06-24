package ict4315.assignment8;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContactListTest 
{
	
	public static void main(String args[]) 
	{
		Contact c1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", "617-855-2431", "JCochoran14@yahoo.com");
		Contact c2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", "339-933-6405", null);
		Contact c3 = new Contact("Steven Johnson", "45 Jasper Drive", "Westover", "MA", "03215", "508-697-6478", "SJohnson34@hotmail.com");
		Contact c4 = new Contact("Fredeick Kaymen", "5 Noddington Way", "Lily", "WV", "32144", "805-968-4545", "13PlaneLover@aol.com");
		
		
	    ContactList contactList = new ContactList();
	    contactList.addContact(c1);
	    contactList.addContact(c2);
	    contactList.addContact(c3);
	    
	    for(Contact c : contactList)
	    {
	    	System.out.println(c.Address_To_String());
	    }
	    
	    System.out.println("-------------Remove second address--------------");
	    contactList.removeContact(c2);
	    
	    for(Contact c : contactList)
	    {
	    	System.out.println(c.Address_To_String());
	    }
	    
	    System.out.println("-------------Attempt to add fourth address while iterating--------------");
	    
	    for(Contact c : contactList)
	    {
	    	System.out.println(c.Address_To_String());
	    	contactList.addContact(c4);
	    }   
	}
}
