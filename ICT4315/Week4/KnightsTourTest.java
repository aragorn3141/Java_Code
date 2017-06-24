package assignment4;



public class KnightsTourTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//-----------------Square Class----------------------
		
		System.out.println("-----------------Square Class Testing----------------------");
		System.out.printf("\n\n");
		
		//Check creation of Square object
		System.out.println("Creating a square instance.....");
		Square square = new Square(0, 0, 8);
		
		System.out.printf("%s%s\n", "The xPos is: ", square.getXPos());
		System.out.printf("%s%s\n", "The yPos is: ", square.getYPos());
		System.out.printf("%s%s\n", "The ID is: ", square.getId());
		System.out.printf("%s%s\n", "The square has been visited: ", square.isVisited());
		System.out.printf("%s%s\n", "The move number is: ", square.getMoveNbr());
		System.out.printf("%s%s\n", "The accessibility number is: ", square.getAccessibityNbr());
		System.out.printf("\n\n");
		
		System.out.println("Updating values.....");
		square.setMoveNbr(25);
		square.setAccessibityNbr(8);
		
		System.out.println();
		System.out.printf("%s%s\n", "The square has now been visited: ", square.isVisited());
		System.out.printf("%s%s\n", "The move number is now: ", square.getMoveNbr());
		System.out.printf("%s%s\n", "The accessibility number is now: ", square.getAccessibityNbr());
		System.out.printf("\n\n");
		
		//Lets check another square
		System.out.println("Let's create a new square to check id.");
		Square square2 = new Square(4, 7, 8);
		System.out.printf("%s%s\n", "The xPos is: ", square2.getXPos());
		System.out.printf("%s%s\n", "The yPos is: ", square2.getYPos());
		System.out.printf("%s%s\n", "The ID is: ", square2.getId());
		System.out.printf("\n\n");
		
		//Check of to_string method
		System.out.print(square2.toString());
		System.out.printf("\n\n");


		//-----------------Board Class----------------------
		
		System.out.println("-----------------Board Class Testing----------------------");
		System.out.printf("\n\n");
		
		//Lets create a board
		System.out.println("Creating a board instance.....");
		
		Board board = Board.getInstance();
		
		//Lets output some data
		System.out.printf("%s%s\n",  "The board height is: ", board.getBoardHeight());
		System.out.printf("%s%s\n",  "The board width is: ", board.getBoardWidth());
		System.out.printf("%s%s\n",  "The number of squares on the board is: ", board.getBoardSize());
		System.out.printf("\n\n");
		
		
		//Lets display the board
		board.displayTour();
		System.out.printf("\n\n");
		
		//-----------------Knight Class----------------------
		
		System.out.println("-----------------Knight C Testing----------------------");
		System.out.printf("\n\n");
		
		//Testing of Knight class
		System.out.println("Creating a knight instance.....");
		
		Knight knight = Knight.getInstance(square2);
		System.out.println();
		
		System.out.println("Creating a square instance to store current location......");
		Square square3 =knight.getLocation();
		System.out.printf("\n\n");
		
		//Output square3 data.  This should match square 2 data
		System.out.print(square3.toString());
		System.out.printf("\n\n");
		
		//Test setting of knight location
		System.out.println("Change knight current location to (0,0) ......");
		
		knight.setLocation(square);
		System.out.printf("\n\n");
		
		//Output square data.  
		System.out.print(square.toString());
		System.out.printf("\n\n");
		
		//Check if specific {-2, -1} is valid
		System.out.println("Checking if move {-2, -1} is valid from current location (0,0) ......");
		System.out.println();
		System.out.printf("%s%s\n", "This move is legal: ", knight.IsValidMove(board, board.getSquare(0), 0));
		System.out.println();
		
		//Check if specific {1, 2} is valid
		System.out.println("Checking if move {1, 2} is valid from current location (0,0) ......");
		System.out.println();
		System.out.printf("%s%s\n", "This move is legal: ", knight.IsValidMove(board, board.getSquare(0), 5));
		System.out.println();
		
		//-----------------KnightsTour ---------------------------
		
		System.out.println("-----------------KnightsTour Testing----------------------");
		System.out.printf("\n\n");
		
		//Create a strategy - initial set to Brute Force
		NextMove strategy1 = new BruteForceStrategy();
		NextMove strategy2 = new HeuristicStrategy();
		
		//Create an instance of the tour
		KnightsTour knightsTour = new KnightsTour(strategy1);
		
		//Testing of KnightsTour class
		System.out.println("Creating a knightsTour instance using Brute Force strategy.....");
		
		//Lets display the board to make sure that a moveNbr = 0 was made
		System.out.printf("\n\n");
		System.out.println("Here is what our board looks like after initialization");
		board.displayTour();
		System.out.printf("\n\n\n\n");
		
		//Executing an initial tour
		System.out.println("Attempting a tour using the Brute Force strategy.....");
		knightsTour.executeTour();
		board.displayTour();
		System.out.printf("\n\n\n\n");
		
		//Lets change the strategy
		System.out.println("Attempting a tour using the Heuristic strategy.....");
		knightsTour.setNextMoveStrategy(strategy2);
		knightsTour.resetBoard();
		knightsTour.executeTour();
		board.displayTour();
		System.out.printf("\n\n\n\n");
		
		//Lets change the strategy back to Brute Force and run tour until successful
		System.out.println("Reattempting a tour using the Brute Force strategy until successful or maximum runs reached.....");
		knightsTour.setNextMoveStrategy(strategy1);
		knightsTour.resetBoard();
		System.out.printf("\n\n");
		
		boolean tourSuccess = false;
		int toursAttempted = 0;	
		
		while(true)
		{
			tourSuccess = knightsTour.executeTour();
			++toursAttempted;
			
			if((tourSuccess == true)||(toursAttempted > 1000000))
			{
				break;
			}
			else
			{			
				//reset board so we can re-execute the tour
				knightsTour.resetBoard();
			}
		}
		
		if (tourSuccess == true)
		{
			System.out.printf("%s%s%s\n", "A successful tour was found after making ", toursAttempted, " tour attempts.");
			board.displayTour();
		}
		else
		{
			System.out.printf("%s\n%s %2d %s %2d %s\n", "A successful tour was not found after making 1,000,000 tour attempts.","The last tour made only ", knight.getMove(), 
					" moves out of a possible", (board.getBoardSize() - 1), " moves.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
