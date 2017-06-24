package ict4315.assignment10.BaseClasses;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-05-20
* 
* This is a class that represents a contact list.  A contact list is a collection that
* contains any number of Contacts.
*/

public class ContactList implements Iterable<Contact>
{
	//Private Member Variables
	
	/**
	 * A List container that is used to hold contacts.
	 */
	private List<Contact> contactList;
	
	// Constructor
	
	/**
	 * Creates a new ContactList that can hold Contacts and be iterated through.
	 */
 	public ContactList(){this.contactList = new CopyOnWriteArrayList<Contact>();}
	
 	//Public Methods
    /**
    * A method to add a contact to an existing ContactList
    */
	public void addContact(Contact c1) {contactList.add(c1);}
	
   /**
    * A method to remove a specific contact from an existing ContactList
    */
	public void removeContact(Contact c2) {
		for (Iterator<Contact> iter = contactList.listIterator(); iter.hasNext();)
		{
			Contact contact = iter.next();
			if(c2.equals(contact)){contactList.remove(contact);}
		}
	}

   /**
    * A method to create an iterator to loop through all Contacts in a ContactList
    */
	public Iterator<Contact> iterator() {return contactList.iterator();}
	
   /**
    * A method to return the number of Contacts that exist in a ContactList
    */
	public Integer Size(){return contactList.size();}
	
   /**
    * A method to determine if a ContactList contains any contacts
    */
	public Boolean isEmpty(){return contactList.isEmpty();}
	
   /**
    * A method that returns the current index in a ContactList of a
    * given Contact.
    */
	public int currIndex(Contact c){return contactList.indexOf(c);}
}
