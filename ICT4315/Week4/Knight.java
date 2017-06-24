package assignment4;

/**
* @author Frederick McGovern
* @version 1.3
* @since 2014-04-20
* 
* This class is used as part of the Knights Tour algorithm
*/

public class Knight 
{
	//private member variables
	
	/**
     * Private variable to hold the moves that a knight can make
     */
	private final int knightMoves[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
	
	/**
     * Private variable to hold the current square that the knight is on
     */
	private Square location;
	
	/**
	 * Private variable to hold the number of moves that the knight has made
	 */
	private int moves;

	/**
     * Private variable to hold our one instance of knight
     */
    private static Knight uniqueKnight;
    
	//Constructors
    
    /**
     * Private constructor to create an instance of knight.
     */
    //This is using the Singleton pattern to ensure only one knight created.
	private Knight(Square location)
	{
		this.location = location;
		moves = 0;
	}
	
	 /**
     * Method to create and return a single instance of the Knight class.
     */
    public static Knight getInstance(Square location)
    {
    	if(uniqueKnight == null)
    	{
    		uniqueKnight = new Knight(location);
    	}
    	return uniqueKnight;
    }
	
	//getters
	/**
     * A method to return the knights current location
     */
	public Square getLocation() 
	{
		return location;
	}
	
	/**
	 * A method to return the number of moves that the knight has made
	 * @return
	 */
	public int getMove() 
	{
		return moves;
	}

	//setters
	/**
     * A method to set the knights current location
     */
	protected void setLocation(Square location) 
	{
		this.location = location;
	}
	
	/**
	 * A method to update the number of moves that the knight has made
	 * @return
	 */
	protected void setMove(int moves) 
	{
		this.moves = moves;
	}
	
	//other methods
	
	/**
	* Method to check if an existing move number would be valid.  
	* @param board
	* @param moveNumber
	* @return
	* The move number corresponds to the first column of the knightsMoves two column array.  Using it we can
	* determine what the xPos and yPos we should add to the existing squares current xPos and current yPos.
	* We then need to check that the field hasn't already been moved to by checking to see if that square 
	* has been visited before
	*/
    protected boolean IsValidMove(Board board, Square square, int moveNumber)
    {
    	try
    	{
    		int newXPos = square.getXPos() + knightMoves[moveNumber][0];
	    	int newYPos = square.getYPos() + knightMoves[moveNumber][1];
	    	int newId = (newYPos * board.getBoardWidth())+newXPos;
	    	
	    	return((newXPos >= 0) && (newXPos < board.getBoardWidth()) &&
	    	      (newYPos >= 0) && (newYPos < board.getBoardHeight()) &&
	    	      (board.getSquare(newId).isVisited() == false));
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
    
    /**
     * Method to determine id of square Knight should move to
     * position has already been verified to be legal
     * @param board
     * @param moveNumber
     * @return id corresponding to square knight will move to
     */
    protected int moveKnightPositionID(Board board, int moveNumber)
    {
    	int newXPos = location.getXPos() + knightMoves[moveNumber][0];
    	int newYPos = location.getYPos() + knightMoves[moveNumber][1];
    	return (newYPos * board.getBoardWidth())+newXPos;
    }
}
