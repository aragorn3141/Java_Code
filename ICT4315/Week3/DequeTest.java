
	/**
	* @author Frederick McGovern
	* @version 1.8
	* @since 2014-04-09
	* 
	* This class contains all the test cases that were created to test
	* the successful coding of every method required in the interface
	*/

public class DequeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Create a new queue of class Deque. 
		Deque myDeque = new Deque(); 
			
// Default check
		
		System.out.println("...................Default Check Start.............."); 
		System.out.println();
		
		//Check that default stubs do in fact return expected values
		System.out.printf("%s%s\n", "The deque size is: ", myDeque.size()); //Returned 0
		System.out.printf("%s%s\n", "The deque is empty: ", myDeque.isEmpty()); //Returned true
		System.out.printf("%s%s\n", "The item at the front of the deque is: ", myDeque.front()); //Returned null
		
		System.out.println();
		System.out.println("...................Default Check End................"); 
		System.out.println();
		
// Test the pushFront, size and isEmpty methods
		
		System.out.println("...................pushFront, size and isempty methods Start..............");
		System.out.println();
		System.out.println("Adding one object to the front of the deque....");
		
		//Check that the array was copied and its size increased. It should no longer be null */
		myDeque.pushFront("First item added to the deque");
		System.out.printf("%s%s\n", "The deque size is: ", myDeque.size()); //Returned 1
		System.out.printf("%s%s\n", "The deque is empty: ", myDeque.isEmpty()); //Returned false
		
		System.out.println();
		System.out.println("...................pushFront, size and isempty methods End................"); 
		System.out.println();
		
		
// Test the front method
		
		System.out.println("...................front method Start..............");
		System.out.println();
		
		//Check that the item that was added to myDeque actual exists at index 0.
		System.out.printf("%s%s\n", "The item at the front of the deque is: ", myDeque.front()); //Returned "First item added to the deque"
		
		System.out.println();
		System.out.println("...................front method End..............");
		System.out.println();
		
// Test the back method	
		
		System.out.println("...................back method Start..............");
		System.out.println();
		
		//We should get the same value if we call the back method as there is only one item on the deque
		System.out.printf("%s%s\n", "The item at the back of the deque is: ", myDeque.back()); //Returned "First item added to the deque"
		
		System.out.println();
		System.out.println("...................back method End..............");
		System.out.println();
		
// Test the pushFront method	
		
		System.out.println("...................pushFront method Start..............");
		System.out.println();
		
		System.out.println("Lets add another object to the deque using the pushfront method.....");
		System.out.println();
		
		//Add another item to the deque and then check the front and back items to ensure they are different
		myDeque.pushFront("Second item added to the deque");
		
		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned "Second item added to the deque"
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned "First item added to the deque"
		
		//Output the size to show that its now 2
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 2
		
		System.out.println();
		System.out.println("...................pushFront method End..............");
		System.out.println();
		
// Test the pushBack method
		
		System.out.println("...................pushBack method Start..............");
		System.out.println();
		
		System.out.println("Lets add another object to the deque using the pushBack method.....");
		System.out.println();
		
		//Add another item to the deque and then check the front and back items to ensure they are different
		myDeque.pushBack("Third item added to the deque"); 
		
		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned "Second item added to the deque"
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned "Third item added to the deque"

		//Output the size to show that its now 3
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 3
		
		System.out.println();
		System.out.println("...................pushBack method End..............");
		System.out.println();
		
// Test the popFront method
		
		System.out.println("...................popFront method Start..............");
		System.out.println();
		
		System.out.println("Lets pop off the first object in the deque using the popFront method.....");
		System.out.println();
		
		//Pop the item from the front of the queue and verify that the back object remained the same
		System.out.printf("%s%s\n", "The item popped off the front of the deque is: ", myDeque.popFront());//Returned "Second item added to the deque"
		
		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned "First item added to the deque"
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned "Third item added to the deque"

		//Output the size to show that its now 2
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 2
		
		System.out.println();
		System.out.println("...................popFront method End..............");
		System.out.println();
		
// Test the popBack method
		
		System.out.println("...................popBack method Start..............");
		System.out.println();
		
		System.out.println("Lets pop off the last object in the deque using the popBack method.....");
		System.out.println();
		
		//Pop the item from the back of the queue and verify that the back object remained the same
		//In this test case the front object and back object should return the same value now.
		System.out.printf("%s%s\n", "The item popped off the back of the deque is: ", myDeque.popBack());//Returned "Third item added to the deque"
		
		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned "First item added to the deque"
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned "First item added to the deque"

		//Output the size to show that its now 1
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 1
		
		System.out.println();
		System.out.println("...................popBack method End..............");
		System.out.println();		
		
// Add additional items of various types using pushfront and pushBack methods
		
		System.out.println("...................Load Additional Objects Start..............");
		System.out.println();
		
		System.out.println("Adding seven more objects to the deque using pushFront and pushBack....");
		System.out.println();
		
		//Add 7 more items to the deque in anticipation of previous and next method coding
		myDeque.pushFront((double)3.14);  
		myDeque.pushBack("Added to the back"); 
		myDeque.pushBack(247); 
		myDeque.pushFront(27.987456);
		myDeque.pushFront("Added to the front");
		
		//load a float type
		myDeque.pushBack((float) 8.326);
		
		//load a boolean type
		myDeque.pushFront((boolean) true);

		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned true
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned 8.326

		//Output the size to show that its now 8
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 8
		System.out.println();
		
		System.out.println("The deque should be loaded as follows:");
		System.out.println("index = 0 -> true; type boolean");
		System.out.println("index = 1 -> 'Added to the front'; type String");
		System.out.println("index = 2 -> 27.987456; type double");
		System.out.println("index = 3 -> 3.14; type double");
		System.out.println("index = 4 -> 'First item added to the deque'; type String");
		System.out.println("index = 5 -> 'Added to the back'; type String");
		System.out.println("index = 6 -> 247; type integer");
		System.out.println("index = 7 -> 8.326; type float");
		
		System.out.println();
		System.out.println("...................Load Additional Objects End..............");
		System.out.println();
		
		
// Test the indexOf method.  
		
		/*Method needs to be changed from private to public for this to work
		System.out.println("...................indexOf method Start..............");
		System.out.println();
		
		System.out.printf("%s%s\n", "The item 3.14 corresponds to an index on the deque of : ", myDeque.indexOf(3.14)); //Returned 3
		System.out.printf("%s%s\n", "The item 'null' corresponds to an index on the deque of : ", myDeque.indexOf(null)); //Returned -1
		
		System.out.println();
		System.out.println("...................indexOf method End..............");
		System.out.println();*/
		
// Test the previous method
		
		System.out.println("...................previous method Start..............");
		System.out.println();
		
		//When the object exists in the deque
		System.out.printf("%s%s\n", "The item in the deque that is before the item 247 is : ", myDeque.previous(247)); //Returned 'Added to the back'
		System.out.println(myDeque.previous(247)); //Returned added to the back
		
		//When the object doesn't exist in the deque
		System.out.printf("%s%s\n", "The item in the deque that is before the item 'football' is : ", myDeque.previous("football")); //Returned 'Added to the back'
		
		System.out.println();
		System.out.println("...................previous method End..............");
		System.out.println();
		
// Test the next method
		
		System.out.println("...................next method Start..............");
		System.out.println();
		
		//When the object exists in the deque
		System.out.printf("%s%s\n", "The item in the deque that is after the item 247 is : ", myDeque.next(247)); //Returned 8.326
		System.out.println(myDeque.previous(247)); //Returned added to the back
		
		//When the object doesn't exist in the deque
		System.out.printf("%s%s\n", "The item in the deque that is after the item 'football' is : ", myDeque.next("football")); //Returned 'Added to the back'
		
		System.out.println();
		System.out.println("...................next method End..............");
		System.out.println();
		
// Test the remove method

		System.out.println("...................remove method Start..............");
		System.out.println();
		System.out.println("Let's remove the object 247 from the deque....");
		System.out.println();
		
		
		//When the object exists in the deque
		System.out.printf("%s%s%s\n", "The item in the deque that is being removed is : ", myDeque.remove(247), ", which is at index 6"); //Returned 247
		
		System.out.println();
		
		System.out.printf("%s%s\n", "The item at the front of the deque now is: ", myDeque.front()); //Returned true
		System.out.printf("%s%s\n", "The item at the back of the deque now is: ", myDeque.back()); //Returned 8.326
		
		//Output the size to show that its now 7
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 7
		
		/*indexOf Method needs to be changed from private to public for this to work
		Check that the item at the index 1 higher is now at the index position that 247 used to be in (6)
		System.out.printf("%s%s\n", "The item that followed 247 was 8.326.  This is now at index: ", myDeque.indexOf((float) 8.326));*/
		
		System.out.println();
		System.out.println("Let's remove the object 'football' from the deque....");
		System.out.println();
			
		//When the object doesn't exist in the deque
		System.out.printf("%s%s\n", "The item in the deque that is being removed is : ", myDeque.remove("football")); //Returned 247
		
		//Output the size to show that its still 7
		System.out.printf("%s%s\n", "The deque size is now: ", myDeque.size()); //Returned 7
		
		
		System.out.println();
		System.out.println("...................remove method End..............");
		System.out.println();
		
// Test the print method

		System.out.println("...................print method Start..............");
		System.out.println();
		System.out.println("The final state of the deque looks like the following....");
		System.out.println();
		
		//Call the print method to output the contents of the deque
		myDeque.print();
		
		System.out.println();
		System.out.println("...................print method End..............");
		
		
		
		
		
		

	}

}
