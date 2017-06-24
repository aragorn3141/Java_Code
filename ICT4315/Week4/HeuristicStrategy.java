package assignment4;

import java.util.ArrayList;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-04-22
* 
* This class is a concrete implementation of the NextMove interface
* using a heuristic algorithm that looks at square accessibilities
* to determine the next move to make
*/

import java.util.Collections;

public class HeuristicStrategy implements NextMove
{
	
	/**
	 * Calculate if there are any possible moves and if there are then
	 * choose one at random and return it
	 * 
	 * @return 
	 */
	public int moveKnight(Board board, Knight knight) 
	{
		setAccessibility(board, knight);
		
		ArrayList< Integer > validMoves = new ArrayList< Integer>();
		ArrayList< Integer > accessNbr = new ArrayList< Integer>();
		
		int minAccessNbr = -1;
		int listSelection = -1;
		int potentialPositionID = 0;

		//Loop through all available moves.  If the move number is valid, add it to the validMoves List
		for(int i = 0; i < NextMove.KNIGHT_MOVES; ++i)
		{
			if(knight.IsValidMove(board, knight.getLocation(), i))
			{
				validMoves.add(i);
				
				//Determine the square ID this move will take us to.
				potentialPositionID = knight.moveKnightPositionID(board, i);
				
				
				//Rule number is i so get the accessibility number for the potential new position
				accessNbr.add(board.getSquare(potentialPositionID).getAccessibityNbr());
			}
		}
		
		if (validMoves.size() > 0)
		{
			//Move is available to be made so determine what index contains the lowest accessibility number
			minAccessNbr = Collections.min(accessNbr);
			
			//Having the minAccessNbr find the index in the accessNbr array corresponding to this value
			listSelection = accessNbr.indexOf(minAccessNbr);
			
			//Return the move number that corresponds to the minimum accessibility nbr
			return validMoves.get(listSelection);
		}
		else
		{
			return listSelection;
		}
	}

	/**
	 * This method sets the accessibility number for every position on the board by
	 * cycling through all moves and counting the number of legal moves found
	 */
	private void setAccessibility(Board board, Knight knight)
	{
		
		for(int i = 0; i < board.getBoardSize(); ++i)
		{
			if(board.getSquare(i).isVisited() == false)
			{
				int counter = 0;
				
				//Loop through all available moves.  If the move number is valid, increase the counter
				for(int j = 0; j < NextMove.KNIGHT_MOVES; ++j)
				{
					if(knight.IsValidMove(board, board.getSquare(i), j))
					{
						++counter;
					}	
				}
				
				//Set accessibility number equal to number of moves available
				board.getSquare(i).setAccessibityNbr(counter);	
			}
			else
			{
				board.getSquare(i).setAccessibityNbr(0);
			}	
		}
		
	
		//If we have moved set current position to zero as we have been there so its no longer accessible
		if(knight.getMove() > 0)
		{
			knight.getLocation().setAccessibityNbr(0);
		}
	}
	
}
