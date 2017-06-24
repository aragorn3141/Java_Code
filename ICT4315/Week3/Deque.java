
import java.util.Arrays;

/**
* @author Frederick McGovern
* @version 1.8
* @since 2014-04-09
* 
* This concrete class contains all the implementation required by the iDeque interface
* It contains three additional private methods utilized by various public methods
* to perform their required tasks.
*/

public class Deque implements IDeque 
{
	
	private Object [] mDeque;
	
	public Deque()
	{
		this.mDeque = new Object [0];
	}
	
	public int size() 
	{
		return mDeque.length;
	}
	
	public boolean isEmpty() 
	{
		return ((this.mDeque == null)||(this.mDeque.length == 0));
	}

	public void pushFront(Object o) 
	{
		try
		{
			this.mDeque = Arrays.copyOf(this.mDeque, size()+1);
			if(isEmpty() == false)
			{
				//parameter corresponds to index that we should loop down to.
				moveUpToNextIndex();
			}
			
			this.mDeque[0] = o;
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
		}
	}
	
	public Object front() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return this.mDeque[0];
		}
	}
	
	public Object back() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{	
			return this.mDeque[this.size()-1];
		}
	}
	
	/* This method counts down from the highest index down to the next to lowest index
	 * replacing the value in the higher index with the value in the index one lower
	 */
	private void moveUpToNextIndex()
	{
		try
		{
			for(int i= size() -1; i > 0 ; --i)
			{
				this.mDeque[i] = this.mDeque[i-1];
			}
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
		}
	}
	
	/* This method counts down from the highest index down to the next to lowest index
	 * replacing the value in the lower index with the value in the current index
	 */
	private void moveDownToNextIndex(int stopIndex)
	{
		try
		{
			for(int i= size() -1; i > stopIndex ; --i)
			{
				this.mDeque[i-1] = this.mDeque[i];
			}
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
		}
	}
	
	public void pushBack(Object o) 
	{
		try
		{
			this.mDeque = Arrays.copyOf(this.mDeque, size()+1);
			this.mDeque[size()-1] = o;
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
		}
	}
	
	public Object popFront() 
	{
		Object temp = this.mDeque[0];
		
		try
		{
			this.mDeque = Arrays.copyOfRange(this.mDeque, 1, size());
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
			temp = null;
		}
		
		return temp;
	}

	public Object popBack() 
	{
		Object temp = this.mDeque[this.mDeque.length - 1];
		
		try
		{
			this.mDeque = Arrays.copyOfRange(this.mDeque, 0, size()-1);
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
			temp = null;
		}
		
		return temp;
	}
	
	/* Method to return the index position corresponding to a match with the value at a particular index with the passed in parameter.
	 * @param Object o
	 */
    private int indexOf(Object o) 
    {
    	//We first check to see if object is null
    	if(o == null)
    	{
    		for (int i = 0; i < size(); i++)
    		{
    			//Since parameter was null we just need to check each index value to see if a null is present
    			if (mDeque[i]==null)
    			{
    				return i;
    			}
    		}
    	}
    	else
    	{
    		//Since object is not null we can use the object equals method to compare the value at index i 
    		//to the parameter value
    		for (int i = 0; i < size(); i++)
    		{
    			if(o.equals(mDeque[i]))
    			{
    				return i;
    			}
    		}
    	}

    	//If no item found return a negative value as that would not correspond to a valid index
    	return -1;
    }

	public Object previous(Object o) 
	{
		int indexLoc = indexOf(o);
		
		try
		{
			if(indexLoc > 0)
			{
				return this.mDeque[indexLoc-1];
				
			}
			else
			{
				return null;
			}	
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
			return null;
		}
	}

	public Object next(Object o) 
	{
		int indexLoc = indexOf(o);
		
		try
		{
			if((indexLoc > -1) && (indexLoc< size()))
			{
				return this.mDeque[indexLoc+1];
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
			return null;
		}
	}

	public Object remove(Object o) 
	{
		int indexLoc = indexOf(o);
		
		try
		{
			if(indexLoc> -1)
			{
				if(indexLoc < size() - 1)
				{
					moveDownToNextIndex(indexLoc);
				}
				
				this.mDeque = Arrays.copyOfRange(this.mDeque, 0, size()-1);
				
				return o;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.err.println("An error has occurred: " + e.getMessage());
			return null;
		}
	}

	public void print() 
	{
		for(int i = 0; i < size(); ++i)
		{
			System.out.printf("%s%2d%s%s\n", "The element at index", i, " is ", this.mDeque[i]);
		}
		
	}


	

	

}
