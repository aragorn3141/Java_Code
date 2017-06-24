package assignment4;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-04-18
* 
* This class is used as part of the Knights Tour algorithm
*/

public class Square 
{
	//private member variables
	
	/**
     * A specific name for the square
     */
	private final int id;
	
	/**
     * The corresponding x position (column) assigned to the square
     */
	private final int xPos;
	
	/**
     * The corresponding y position (row) assigned to the square
     */
	private final int yPos;
	
	/**
     * A indicator to indicate if the square has been previously visited
     */
	private boolean visited;
	
    /**
     * The move number assigned to the square
     */
	private int moveNbr;
	
	/**
     * The accessibility number assigned to the square
     */
	private int accessibityNbr;
	
	
	//public constructor
	
    /**
     * Public constructor to create an instance of a square.
     * @param xPos - the x position of the square
     *            
     * @param yPos - the y position of the square
     *  
     * @param widths - the corresponding width of the container 
     */
	public Square(int xPos, int yPos, int width)
	{
		id = (yPos*width)+xPos;
		this.xPos = xPos;
		this.yPos = yPos;
		moveNbr = -1;
		accessibityNbr = -1;
	}
	
	//getter methods
		
    /**
     * Method to return the square identifier
     */
	public int getId() {
		return id;
	}
	
    /**
     * Method to return the x position (column) assigned to the square
     */
	public int getXPos() 
	{
		return xPos;
	}

    /**
     * Method to return the y position (row) assigned to the square
     */
	public int getYPos() {
		return yPos;
	}

    /**
     * Method to return an indication of whether or not the square has been previously visited
     */
	public boolean isVisited() {
		return visited;
	}
	
    /**
     * Method to return the move number assigned to the square
     */
	public int getMoveNbr() {
		return moveNbr;
	}
	
	/**
     * Method to return the accessibility number assigned to the square
     */
	public int getAccessibityNbr() {
		return accessibityNbr;
	}

	//setter methods

	/**
     * Method to set the move number assigned to the square
     * Since assigning move number other than default (-1), 
     * square has been visited as well
     */
	protected void setMoveNbr(int moveNbr) {
		this.moveNbr = moveNbr;
		
		if(moveNbr != -1)
		{
			visited = true;
		}
		else
		{
			visited = false;
		}
	}

	/**
     * Method to set the accessibility number assigned to the square
     */
	protected void setAccessibityNbr(int accessibityNbr) {
		this.accessibityNbr = accessibityNbr;
	}	
	
	//Other methods used in testing
	
	/**
     * Outputs the values assigned to a given square
     */
	public String toString() 
	{
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("          Square Object" + NEW_LINE);
		result.append("---------------------------------" + NEW_LINE);
	    result.append("This square id is : " + id + NEW_LINE);
	    result.append("This square xPos is : " + xPos + NEW_LINE);
	    result.append("This square yPos is : " + yPos + NEW_LINE);
	    result.append("This square has been visited : " + visited + NEW_LINE);
	    result.append("This square move number is : " + moveNbr + NEW_LINE);
	    result.append("This square accessibility number is : " + accessibityNbr + NEW_LINE);
	 return result.toString();
    }
	
}
