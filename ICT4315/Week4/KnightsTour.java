package assignment4;

import java.util.Random;

/**
* @author Frederick McGovern
* @version 2.2
* @since 2014-04-18
* 
* This class attempts to solve the Knights Tour problem through
* the use of a user defined strategy
*/

public class KnightsTour 
{
	//private member variables
	
	/**
     * Private variable to hold the move strategy that the tour will utilize
     */
	private NextMove nextMoveStrategy;
	
    /**
     * Private variable to hold our one instance of board
     */
	private Board board = Board.getInstance();
	
	/**
     * Private variable to hold our one instance of knight
     */
	private Knight knight = Knight.getInstance(board.getSquare(0));
	
	/**
     * Private variable to hold a random 
     */	
	private static Random random = new Random();
	
	//public constructor
	
	/**
     * Public constructor to create an instance of a knightsTour.
     * @param strategy - the move strategy that will be used in the tour
     *            
     */
	public KnightsTour(NextMove strategy)
	{
		setNextMoveStrategy(strategy);
		
		//Since board is a singleton we want to ensure that its been reset for initial use
		resetBoard();
	}
	
	//setters
	
	/**
	 * Allows for resetting of the move strategy that the tour will utilize
	 */
	public void setNextMoveStrategy(NextMove nm)
	{
		nextMoveStrategy = nm;
	}
	
	
	//public methods
	
	/** 
	 * Method to loop through all squares contained in the board and reset to default values
	 * and then set the initial position of the knight
	 */
	public void resetBoard()
	{
		
		for(int i = 0; i < board.getBoardSize(); ++i)
		{
			board.getSquare(i).setMoveNbr(-1);
			board.getSquare(i).setAccessibityNbr(-1);
		}
		
		//After resetting board, call method to set initial knight position
		setInitialKnightPosition();
	}
	
	/**
	 * Method that executes a single tour using a predetermined move strategy
	 */
	public boolean executeTour()
	{
		int movesMade = 0;
		int moveNbr = -1;
		
		while(true)
		{
			moveNbr = nextMoveStrategy.moveKnight(board, knight);
			if(moveNbr != -1 )
			{
				performMove(moveNbr);
				++movesMade;
			}
			else
			{
				break;
			}	
		}

		return(movesMade == 63);
	}
	
	
	//private methods
	
    /**
     * Method to return a random number based on a maximum value.  
     * For example, if a max value of 8 is passed the random number will be between 0 and 7. 
     * Method deemed as private as no need for user to utilize - internal to program only.
	 * @param maxRange
	 * @return
	 */
	private int getRandom(int maxRange) 
    {
    	return random.nextInt(maxRange);
    }
	
	/**
	 * Method to set the initial position of the Knight on the board
	 */
	private void setInitialKnightPosition()
	{
		//Get a random number between 0 and the maximum number of squares on the board
		int initPosition = getRandom(board.getBoardSize());
		
		//Given a position, set the knight to that location
		knight.setLocation(board.getSquare(initPosition));
		
		//Set the moveNbr for that position
		board.getSquare(initPosition).setMoveNbr(0);
		
		//Set the number of moves made equal to zero
		knight.setMove(0);
	}

	/**
	 * Performs the move specified by a moveNbr that was
	 * determined by the strategy being utilized in the tour.
	 */
	private void performMove(int moveNbr)
	{
		int movePositionID;
		
		//Determine the square ID this move will take us to.
		movePositionID = knight.moveKnightPositionID(board, moveNbr);
		
		//Move the knight to the position specified by the retrieved rule
		knight.setLocation(board.getSquare(movePositionID));
		
		//Increment the number of moves the knight has made
		knight.setMove(knight.getMove()+1);
		
		//For the square that the knight just moved to, update the square to show the current moveNbr
		board.getSquare(movePositionID).setMoveNbr(knight.getMove());
	}

}
