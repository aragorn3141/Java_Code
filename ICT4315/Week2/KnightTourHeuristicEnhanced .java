import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

	/**
	* @author Frederick McGovern
	* @version 1.2
	* @since 2014-04-06
	* 
	* This class attempts to solve the Knights Tour problem through
	* the use of a heuristic algorithm where it gets an accessibility matrix value
	*/

public class KnightTourHeuristicEnhanced 
{
	private final int boardWidth;
    private final int boardHeight;
    private final int knightMoves[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private int board[][][];
    private int currXPos;
    private int currYPos;
    private int currMove;
    private static Random random = new Random();
    
/**Constructors*/
    
    /**
    * Default constructor.  Creates standard 8*8 board with randomly assigned starting position
    */
    public KnightTourHeuristicEnhanced()
    {
    	this.boardWidth = 8;
    	this.boardHeight = 8;
    	this.board = new int[8][8][2];
    	InitializeBoard();
    	setInitialPosition();
    }
    
    /**
     * Creates board of users dimensions with randomly assigned starting position
     * @param width
     * @param height
     */
    public KnightTourHeuristicEnhanced(int width, int height)
    {
    	this.boardWidth = width;
    	this.boardHeight = height;
    	this.board = new int[width][height][2];
    	InitializeBoard();
    	setInitialPosition(); 
    }
    
    /**
     * Creates board of user dimensions with user defined starting position
     * Assigns starting position based on parameters if valid else randomly assigns
     * @param width
     * @param height
     * @param startXPos
     * @param startYPos
     */
    public KnightTourHeuristicEnhanced(int width, int height, int startXPos, int startYPos)
    {
    	this.boardWidth = width;
    	this.boardHeight = height;
    	this.board = new int[width][height][2];
    	InitializeBoard();
    	setInitialPosition(startXPos, startYPos);
    }
    
    
/**Getters*/
    
    /**
    * Method to return the existing board width.  
    * No setter method as private member set as final.  
    * Value set via constructor only
    * @return
    */
  	public int getBoardWidth()
  	{
  		return this.boardWidth;
  	}
	
  	/**
     * Method to return the existing board height.  
     * No setter method as private member set as final.  
     * Value set via constructor only
     * @return
     */
   	public int getBoardHeight()
   	{
   		return this.boardHeight;
   	}
	
  	/**
  	* Method used to return the current x axis position on the board
  	* @return
  	*/
    public int getXPosition() 
    {
	    return this.currXPos;
    }
    
	/**
	* Method used to return the current y axis position on the board
	* @return
	*/ 
    public int getYPosition() 
    {
	    return this.currYPos;
    }
    
    /**
    * Method to get the horizontal (x index) move value based on a specific move number
    * @return
    */
    public int getXMove(int moveNumber)
    {
    	return this.knightMoves[moveNumber][0];
    }
    
    /**
    * Method to get the vertical (y index) move value based on a specific move number
    * @return
    */
    public int getYMove(int moveNumber)
    {
    	return this.knightMoves[moveNumber][1];
    }
    
	/**
	* Method used to return the current move number.
	* @return
	*/
    public int getCurrMove()
    {
    	return this.currMove;
    }
    
    /**
    * Method used to return the move number assigned to a specified position on the board
    * @param xPos
    * @param yPos
    * @return
    */
    public int getPositionMoveNbr(int xPos, int yPos)
    {
    	return this.board[xPos][yPos][0];
    }
    
    /**
     * Method to return the accessibility number for a given x, y position
     * @param xPos
     * @param yPos
     * @return
     */
    private int getAccessibilityNbr(int xPos, int yPos)
    {
    	return board[xPos][yPos][1];
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

	/**Setters*/

	/**
	* Private method to set the X axis position on the board.  Not available to user - utilized internally
	* If parameter is not valid a IndexOutOfBoundsException is manually thrown.
	* @param currXPos
	*/
	private void setCurrXPos(int currXPos) 
	{
		try
		{
			if((currXPos >=0)&&(currXPos < this.boardWidth))
			{
				this.currXPos = currXPos;
			}
			else
			{
				throw new IndexOutOfBoundsException("An attempt was made to set the X position on the board to a value outside the board width");
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	* Private method to set the Y axis position on the board.  Not available to user - utilized internally
	* If parameter is not valid a IndexOutOfBoundsException is manually thrown.
	* @param currYPos
	*/
	private void setCurrYPos(int currYPos) 
	{
		try
		{
			if((currYPos >=0)&&(currYPos < this.boardHeight))
			{
				this.currYPos = currYPos;
			}
			else
			{
				throw new IndexOutOfBoundsException("An attempt was made to set the Y position on the board to a value outside the board height");
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	* Private method to set the current square equal to the private member field currMoveNbr.  
	* Not available to user - utilized internally
	* If parameter is not valid a IndexOutOfBoundsException is manually thrown.
    * @param currMoveNbr
	*/
	private void setCurrMoveNbr(int currMoveNbr) 
	{
		try
		{
			if((currMoveNbr >=0)&&(currMoveNbr < (this.boardWidth * this.boardHeight)))
			{
				this.currMove = currMoveNbr;
				this.board[this.currXPos][this.currYPos][0] = currMoveNbr;
			}
			else
			{
				throw new IndexOutOfBoundsException("An attempt was made to set the move number greater than the maximum possible moves on the board " +
						"which is " + (getBoardWidth() * getBoardHeight() -1));
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
    
	/**
	 * This method randomly assigns a starting position on the board within the dimensions of the board.
	 * The valid range is:
	 * X Value - range is from 0 to one less than the board width
	 * Y Value - range is from 0 to one less than the board height 
	 * Since value is one less we don't include the standard + 1 seen in most random number generators
	 */
	public void setInitialPosition()
	{
		setCurrXPos(getRandom(this.boardWidth));
		setCurrYPos(getRandom(this.boardHeight));
		setCurrMoveNbr(0);
	}
	
	/**
  	* This overloaded method sets a starting position on the board based on parameters if valid. 
  	* If parameters result in an invalid position, a IndexOutOfBoundsException is manually thrown, 
  	* and a random starting position is assigned instead.
  	* @param xPos
  	* @param yPos
  	* Valid parameters are:
  	* X Value - range is from 0 to one less than the board width
  	* Y Value - range is from 0 to one less than the board height
  	*/
	public void setInitialPosition(int xPos, int yPos)
	{
		if (xPos >= 0 && xPos < this.boardWidth && yPos >= 0 && yPos < this.boardHeight)
		{
			setCurrXPos(xPos);
			setCurrYPos(yPos);
			setCurrMoveNbr(0);
		}
		else
		{
			setInitialPosition();
		}
		
		//Set accessibility matrix value to zero as at that location already
		this.board[currXPos][currYPos][1] = 0;
	}
	
	/**
	 * This method sets the accessibility number for every position on the board by
	 * cycling through all moves and counting the number of legal moves found
	 */
	private void setAccessibility()
	{
		int counter;
		
		for(int y_coord = 0; y_coord < this.boardHeight; y_coord++)//number of rows
		{
			for(int x_coord = 0; x_coord < this.boardWidth; x_coord++)//number of columns
			{
				counter = 0;
				
				//If haven't visit square calculate how many legal moves are available to get you to that square
				if (this.board[x_coord][y_coord][0] == -1)
				{
					//Loop through all available moves.  If the move number is valid, add it to the validMoves List
					for(int i = 0; i < this.knightMoves.length; ++i)
					{
						if (IsValidMove(x_coord, y_coord, i))
						{
							counter++;
						}
					}
					
					//Set accessibility number equal to number of moves available
					this.board[x_coord][y_coord][1]= counter;
				}
				else
				{
					this.board[x_coord][y_coord][1] = 0;
				}
			}
		}
		
		//If we have moved set current position to zero as we have been there so its no longer accessible
		if(this.currMove > 0)
		{
			this.board[currXPos][currYPos][1]= 0;
		}
	}
	
	
/**Other methods*/

	/**
	* Method to initialize board so that all values are set to a default value of -1
	*/
    public void InitializeBoard()
	{
		for(int y_coord = 0; y_coord < this.boardHeight; y_coord++)//number of rows
		{
			for(int x_coord = 0; x_coord < this.boardWidth; x_coord++)//number of columns
			{
				this.board[x_coord][y_coord][0] = -1;
			}
		}
		//Initialize the underlying accessibility matrix
		setAccessibility();
	}
    
	/**
	* Method to check if an existing move number would be valid.  
	* @param xPos
	* @param yPos
	* @param moveNumber
	* @return
	* The move number corresponds to the first column of the knightsMoves two column array.  Using it we can
	* determine what the xPos and yPos we should add to the existing current xPos and current yPos.
	* We then need to check that the field hasn't already been moved to by checking to see if that square 
	* has a position move nbr assigned to it.  Non visited squares have a value of -1
	*/
    public boolean IsValidMove(int xPos, int yPos, int moveNumber)
    {
    	if ((xPos + this.knightMoves[moveNumber][0] >= 0) && (xPos + this.knightMoves[moveNumber][0] < this.boardWidth) && 
    	   ((yPos + this.knightMoves[moveNumber][1] >= 0) && (yPos + this.knightMoves[moveNumber][1] < this.boardHeight)) &&
    	   (this.board[xPos + this.knightMoves[moveNumber][0]][yPos + this.knightMoves[moveNumber][1]][0] == -1))
    	{
    		return true;

    	}
    	else
    	{
    		return false;
    	}
    }
    
    /**
     * Method to move the knight
     * @param moveNumber
     */
	private void moveKnight(int moveNumber)
	{
		setCurrXPos(this.currXPos + this.knightMoves[moveNumber][0]);
		setCurrYPos(this.currYPos + this.knightMoves[moveNumber][1]);
		this.currMove++;	
		setCurrMoveNbr(this.currMove);
	}
	
	private int getFutureAccessibilityNbr(int xPos, int yPos)
	{
		ArrayList< Integer > validMoves = new ArrayList< Integer>();
		ArrayList< Integer > accessNbr = new ArrayList< Integer>();
				
		int minAccessNbr = 0;
		
		//Loop through all available moves.  If the move number is valid, add it to the validMoves List
		for(int i = 0; i < knightMoves.length; i++)
		{
			if (IsValidMove(xPos, yPos, i))
			{
				validMoves.add(i);
					
				//Rule number is i so get xPos, yPos for that rule and add to currXPos and currYPos to get accessibility number
				accessNbr.add(getAccessibilityNbr(xPos + knightMoves[i][0],yPos + knightMoves[i][1]));
			}
		}
		  
		if (validMoves.size() > 0)
		{
			//Move is available to be made so determine what index contains the lowest accessibility number
			minAccessNbr = Collections.min(accessNbr);
		}
	
		return minAccessNbr;
	}
	
	/**
	 * Method to attempt to complete a tour.
	 * @return
	 */
    public boolean attemptTour()
	{
    	ArrayList< Integer > validMoves = new ArrayList< Integer>();
		ArrayList< Integer > accessNbr = new ArrayList< Integer>();
		
		int minAccessNbr;
		int listSelection;
		
		while(true)
		{			
			//Reset the list after each successful move.
			validMoves.clear();
			accessNbr.clear();
		
			//Loop through all available moves.  If the move number is valid, add it to the validMoves List
			for(int i = 0; i < knightMoves.length; i++)
			{
				if (IsValidMove(getXPosition(), getYPosition(), i))
				{
					validMoves.add(i);
					
					//Rule number is i so get xPos, yPos for that rule and add to currXPos and currYPos to get accessibility number
					accessNbr.add(getAccessibilityNbr(this.currXPos + this.knightMoves[i][0],this.currYPos + this.knightMoves[i][1]));
				}
			}

			if (validMoves.size() > 0)
			{
				//Move is available to be made so determine what index contains the lowest accessibility number
				minAccessNbr = Collections.min(accessNbr);
				
				//if first index location of minimum value is less than last index location then we know we have
				//at least two moves with the same accessibility values so we need to determine the tie breaker
				if (accessNbr.indexOf(minAccessNbr) < accessNbr.lastIndexOf(minAccessNbr))
				{
					int i = 0;
					int minIndex = 0;
					int minAccValue = 99;
					int newAccValue = 0;
					
					while(i < accessNbr.size())
					{
						
						//If the index corresponds to a location that has a minimum access nbr then get the future accessibility number
						if(accessNbr.get(i) == minAccessNbr);
						{
							newAccValue = getFutureAccessibilityNbr((currXPos + knightMoves[i][0]),(currXPos + knightMoves[i][1]));
							if(newAccValue < minAccValue)
							{
								minAccValue = newAccValue;
								minIndex = i;
							}
						}
						++i;
					}
					
					listSelection = minIndex;
				}
				else
				{
					//Having the minAccessNbr find the index in the accessNbr array corresponding to this value
					listSelection = accessNbr.indexOf(minAccessNbr);
				}		
				
				//Move the knight to the position specified by the retrieved rule
				moveKnight(validMoves.get(listSelection));
			}
			else
			{
				break;
			}
		}
		
		return (this.currMove == ((this.boardWidth * this.boardHeight) - 1));
	}
	
	/**
	* Method to display the tour that the Knight made to the user.  
	* The knight starts at position 0 and increases sequentially.
	*/
	public void displayTour()
	{	
		System.out.println("The results are as follows:");
		System.out.println();
		
		//Create a horizontal header so as to make it easier to determine position on display
		System.out.print("  ");
		
		for(int i = 0; i < getBoardWidth(); i++)
		{
			System.out.printf(" %2d ",i);
		}
		
		System.out.println();
		
		//Prints out a dashed line
		System.out.print("-");
		for(int i = 0; i < (getBoardWidth()); i++)
		{
			System.out.print("----");
		}
		
		System.out.println();
		
		//Loop through board array returning values at the x_coord and y_coord
		for(int y_coord = 0; y_coord < getBoardHeight(); y_coord++)
		{
			//This line creates a vertical header so as to make it easier to determine position on display
			System.out.printf("%s%s",y_coord, ":");
			
			for(int x_coord = 0; x_coord < getBoardWidth(); x_coord++)
			{
				if(board[x_coord][y_coord][0] != -1)
				{
					System.out.printf(" %2d ", board[x_coord][y_coord][0]);
				}
				else
				{
					System.out.print("  * ");
				}
				
			}
			System.out.println();
		}
	}
	
	//Method to display the accessibility matrix for every square.
	public void displayAccessibilityMatrix()
	{	
		System.out.println("The accessibility matrix is as follows:");
		System.out.println();
		
		//Create a horizontal header so as to make it easier to determine position on display
		System.out.print("  ");
		
		for(int i = 0; i < getBoardWidth(); i++)
		{
			System.out.printf(" %2d ",i);
		}
		
		System.out.println();
		
		//Prints out a dashed line
		System.out.print("-");
		for(int i = 0; i < (getBoardWidth()); i++)
		{
			System.out.print("----");
		}
		
		System.out.println();
		
		//Loop through board array returning values at the x_coord and y_coord
		for(int y_coord = 0; y_coord < getBoardHeight(); y_coord++)
		{
			//This line creates a vertical header so as to make it easier to determine position on display
			System.out.printf("%s%s",y_coord, ":");
			
			for(int x_coord = 0; x_coord < getBoardWidth(); x_coord++)
			{
				System.out.printf(" %2d ", board[x_coord][y_coord][1]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) 
	{
		boolean tourSuccess;
		
		//Create a new knightTour of class KnightTourViaBruteForce.  Uses one of the three constructors available
		KnightTourHeuristicEnhanced knightTour = new KnightTourHeuristicEnhanced(); 

		int counter = 0;
		
		//Begin the Knights Tour
		while(true)
		{
			tourSuccess = knightTour.attemptTour();
			counter++;
			
			if ((tourSuccess == true)||((counter > 1)||(knightTour.getCurrMove() > 62)))
			{
				break;
			}
			else
			{
				knightTour.InitializeBoard();
				knightTour.setInitialPosition();
			}
		}

		if (tourSuccess == true)
		{
			System.out.println("A successful tour was found.");
		}
		else
		{
			System.out.printf("%s\n%s %2d %s %2d %s\n", "The tour was not successful.","It made only", knightTour.getCurrMove(), 
					"moves out of a possible", (knightTour.getBoardHeight() * knightTour.getBoardWidth() - 1), "moves.");
		}
		
		//Display the tour to the users
		knightTour.displayTour();
		
		//Display the accessibility matrix for testing
		//knightTour.displayAccessibilityMatrix();
	}
    
	
}
