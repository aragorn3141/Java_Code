
	/**
	* @author Frederick McGovern
	* @version 1.0
	* @since 2014-04-09
	* 
	* This interface contains the methods indicated in this weeks assignment
	* that should be utilized in the Deque class
	*/

public interface IDeque 
{
	/* This methods increases the size of the Deque to be one larger than the current size
	 * If the Deque is not null, then we copy each element to the next higher element starting
	 * from the top of the Deque.
	 * @param Object o
	 */
	void pushFront(Object o);
	
	
	
	/* Store the object stored in the Deque corresponding to index = 0 into the variable temp.  
	 * Then copy the values in the remaining indexes using the copyOfRange method to decrease 
	 * the capacity.
	 * Finally, return the value stored in the variable temp.
	 */
	Object popFront();
	
	
	
	/* Method to return the element on the Deque corresponding to index = 0 unless the Deque is
	 * empty in which case a null value is returned.
	 */
	Object front();
	
	

	 /* Increase the size of the Deque and add the element to the highest index position
	  * from the top of the Deque.
	  * @param Object o
	 */
	void pushBack(Object o);
	
	
	
	/* Store the element stored in the Deque corresponding to the highest index into the variable temp.  
	 * Then copy the values in the remaining indexes using the copyOfRange method to decrease 
	 * the capacity
	 * Finally, return the value stored in the variable temp.
	 */
	Object popBack();
	
	
	
	/* Method to return the element corresponding to the maximum index in Deque unless the Deque is
	 * empty in which case a null value is returned.
	 */
	Object back();
	
	
		
	/* Method to return the element located at the previous index location on the Deque 
	 * from where the object parameter is located.
	 * Returns null if the object is not found or is found at index value = 0
	 * @param Object o
	 */
	Object previous(Object o);
	
	
	
	/* Method to return the element located at the next index location on the Deque 
	 * from where the object parameter is located.
	 * Returns null if the object is not found or is found at the location corresponding
	 * to the highest index value.
	 * @param Object o
	 */
	Object next(Object o);
	
	
	
	/* Method removes the first element matching the object 0 and returns it 
	 * the size of the deque is reduced by one in the process.
	 */
	Object remove(Object o);
	
	
	
	/* Print the contents of the list, nicely formatted.
	 * Output indicate the index number and the value at the index
	 */
	void print();
	
	
	
	/* Checks to see if the object is null or if the length is equal to zero
	 * If either condition is true then the method returns true.  
	 * If neither condition is true then the method returns false.
	 */
	boolean isEmpty();
	
	
	
	/* Returns an integer corresponding to the number of elements in the Deque 
	 * by calling the classes array length's method
	 */
	int size();
	
}
