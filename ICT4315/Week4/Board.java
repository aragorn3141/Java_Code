package assignment4;

import java.util.ArrayList;

/**
* @author Frederick McGovern
* @version 1.3
* @since 2014-04-18
* 
* This class is used as part of the Knights Tour algorithm
* It is used as a container to hold square objects
*/

public class Board 
{
	//private member variables
	
	/**
     * The number of rows on the board
     */
	private final int boardWidth = 8;
	
	/**
     * The number of columns on the board
     */
    private final int boardHeight = 8;
    
	/**
     * The number of squares on the board
     */
    private final int boardSize = 64;
    
        
    /**
     * The internal representation of the board.
     */
    private ArrayList<Square> board;
    

    /**
     * Private variable to hold our one instance of board
     */
    private static Board uniqueBoard;
    
    
    //Constructor
    
    /**
     * Private constructor to create an instance of board.
     */
    //This is using the Singleton pattern to ensure only one board created.
    private Board()
    {
    	board = new ArrayList<Square>(boardWidth*boardHeight);
    	buildSquares();
    }
    
    /**
     * Method to create and return an instance of the Board class.
     */
    public static Board getInstance()
    {
    	if(uniqueBoard == null)
    	{
    		uniqueBoard = new Board();
    	}
    	return uniqueBoard;
    }
    
    //getters
    
    /**
     * A method to return the boards width
     */
	public int getBoardWidth() 
	{
		return boardWidth;
	}
    
    /**
     * A method to return the boards height
     */
	public int getBoardHeight() 
	{
		return boardHeight;
	}
	
    /**
     * A method to return the boards size
     */
	public int getBoardSize() 
	{
		return boardSize;
	}
	
	
    /**
     * A method to return a specific square on the board
     * Its used only by other classes hence protected.
     */
	protected Square getSquare(int id) 
	{
		return board.get(id);
	}
    
    
    // other methods
	
    /**
     * Method to build all squares necessary for the board
     * Number of squares that will be built is equal to board width * board height      
     */
    private void buildSquares()
    {	
		for(int y_coord = 0; y_coord < boardHeight; ++y_coord)//number of rows
		{
			for(int x_coord = 0; x_coord < boardWidth; ++x_coord)//number of columns
			{
				build(x_coord, y_coord);
			}
		}
    }
    
    /**
     * Method to build a specific square and add it to our board.
     * @param xPos - the x position of the square
     *            
     * @param yPos - the y position of the square
     *            
     */
    private void build(int xPos, int yPos)
    {
    	Square s = new Square(xPos,yPos,boardWidth);
    	board.add(s);
    }
	
	/**
	* Method to display the tour that the Knight made to the user.  
	* The knight starts at position 0 and increases sequentially.
	*/
	public void displayTour()
	{	
		//Call method to create a header for the display
		displayTourHeader();
		
		//Loop through board array returning values at the x_coord and y_coord
		for(int y_coord = 0; y_coord < boardHeight; ++y_coord)
		{
			//This line creates a vertical header so as to make it easier to determine position on display
			System.out.printf("%s%s",y_coord, ":");
			
			for(int x_coord = 0; x_coord < boardWidth; ++x_coord)
			{
				int position = (y_coord*boardWidth)+x_coord;
				
				if(board.get(position).getMoveNbr() != -1)
				{
					System.out.printf(" %2d ", board.get(position).getMoveNbr());
				}

				else
				{
					System.out.print("  * ");
				}
			}
			System.out.println();
		}
	} 
	
	/**
	* Method to display a header for the display of the tour that the Knight made to the user.  
	*/
	private void displayTourHeader()
	{	
		System.out.println("The results are as follows:");
		System.out.println();
		
		//Create a horizontal header so as to make it easier to determine position on display
		System.out.print("  ");
		
		for(int i = 0; i < boardWidth; ++i)
		{
			System.out.printf(" %2d ",i);
		}
		
		System.out.println();
		
		//Prints out a dashed line
		System.out.print("-");
		for(int i = 0; i < (boardWidth); ++i)
		{
			System.out.print("----");
		}
		
		System.out.println();
	}
	
}
