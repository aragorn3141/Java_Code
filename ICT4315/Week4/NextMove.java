package assignment4;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-04-22
* 
* This the interface to determine the next move to make
* utilizing the strategy pattern
*/
public interface NextMove 
{
	
	/**
	 * The number of possible moves that a knight can make. 
	 * .
	 */
	public static final int KNIGHT_MOVES = 8 ;
	
	/**
     * Method to determine the next move that is made by the Knight
     */
	public int moveKnight(Board board, Knight knight);
	
}
