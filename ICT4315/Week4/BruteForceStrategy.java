package assignment4;

import java.util.ArrayList;
import java.util.Random;

/**
* @author Frederick McGovern
* @version 1.4
* @since 2014-04-22
* 
* This class is a concrete implementation of the NextMove interface
* using a brute force algorithm to determine the next move to make
*/


public class BruteForceStrategy implements NextMove
{
	/**
     * Private variable to hold a random 
     */	
	private static Random random = new Random();
	
	/**
	 * Calculate if there are any possible moves and if there are then
	 * choose one at random and return it
	 * 
	 * @return 
	 */
	public int moveKnight(Board board, Knight knight) 
	{
		ArrayList< Integer > validMoves = new ArrayList< Integer>();
		int listSelection = -1;

		//Loop through all available moves.  If the move number is valid, add it to the validMoves List
		for(int i = 0; i < NextMove.KNIGHT_MOVES; ++i)
		{
			if(knight.IsValidMove(board, knight.getLocation(), i))
			{
				validMoves.add(i);
			}
		}
		
		//If a valid move exists, randomly select a move and return it
		//else return -1
		if(validMoves.size()> 0)
		{
			listSelection = getRandom(validMoves.size());
			return validMoves.get(listSelection);
		}
		else
		{
			return listSelection;
		}
	}

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
	
	
}
