/**
 * 
 */
package assignment2 ;

/**
 * @author rjudd
 */
public class Heuristic
{
    /**
     * The number of rows on the chessboard
     */
    public static final int ROWS = 8 ;

    /**
     * The number of columns on the chessboard
     */
    public static final int COLUMNS = 8 ;

    /**
     * The number of possible moves that a knight can make.  
     * This is really just the length of the HORIZONTAL and VERTICAL arrays. 
     */
    public static final int MOVES = 8 ;

    /**
     * The possible moves that the knight can make horizonatally.  This is 
     * pairs up with the VERTICAL array.
     */
    public static final int[] HORIZONTAL = { 2, 1, -1, -2, -2, -1, 1, 2 } ;

    /**
     * The possible moves that the knight can make vertically.  This is 
     * pairs up with the HORIZONTAL array.
     */
    public static final int[] VERTICAL = { -1, -2, -2, -1, 1, 2, 2, 1 } ;

    /**
     * The internal representation of the chessboard.
     */
    private int[][] board = new int[ROWS][COLUMNS] ;

    /**
     * The accessibility matrix with the initial accessibility numbers.
     */
    private int[][] accessibility = { 
            { 2, 3, 4, 4, 4, 4, 3, 2 },
            { 3, 4, 6, 6, 6, 6, 4, 3 }, 
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 4, 6, 8, 8, 8, 8, 6, 4 }, 
            { 4, 6, 8, 8, 8, 8, 6, 4 },
            { 4, 6, 8, 8, 8, 8, 6, 4 }, 
            { 3, 4, 6, 6, 6, 6, 4, 3 },
            { 2, 3, 4, 4, 4, 4, 3, 2 } } ;

    /**
     * The current row.
     */
    private int currentRow ;

    /**
     * The current column.
     */
    private int currentCol ;

    /**
     * How many moves have been made in this tour.
     */
    private int moves = 0 ;

    /**
     * Create an instance of Heuristic and run a tour.  Each time you call this
     * you will get the same tour because the algorithm is deterministic.
     * 
     * @param row - the starting row
     * @param column - the starting column
     */
    public Heuristic(final int row, final int column)
    {
        currentRow = row ;
        currentCol = column ;
        for (int i = 0; i < ROWS; ++i)
        {
            for (int j = 0; j < COLUMNS; ++j)
            {
                board[i][j] = 0 ;
            }
        }

        moves = play() ;
        if (moves == 64)
        {
            if (closedTour(row, column))
            {
                System.out.println("Closed Tour!") ;
            }
            else
            {
                System.out.println("Full Tour!") ;
            }
        }
        printBoard() ;
        System.out.println() ;
    }

    /**
     * Accessor for the number of moves made in this tour.  If it is a full tour
     * then the number of moves made will be 64.
     * @return the number of moves in the tour.
     */
    public int getMoves()
    {
        return moves ;
    }

    /**
     * Play the game and return the number of moves made.
     * @return the number of moves made
     */
    private int play()
    {
        int move = 0 ;
        do
        {
            ++move ;
            board[currentRow][currentCol] = move ;
        }
        while (nextMove()) ;
        return move ;
    }

    /**
     * Calculate the next move and make it if there is a possible move.  If
     * more than one move is possible, then choose the first move with the 
     * lowest accessibility number.
     * @return true if a move was made and false otherwise.
     */
    private boolean nextMove()
    {
        int move = -1 ;
        int access = 9 ;
        for (int i = 0; i < MOVES; ++i)
        {
            int r = currentRow + HORIZONTAL[i] ;
            int c = currentCol + VERTICAL[i] ;
            if (legalMove(r, c))
            {
                if (accessibility[r][c] < access)
                {
                    access = accessibility[r][c] ;
                    move = i ;
                }
            }
        }

        if (move != -1)
        {
            reduceAccess() ;
            currentRow += HORIZONTAL[move] ;
            currentCol += VERTICAL[move] ;
            return true ;
        }
        else
        {
            return false ;
        }
    }

    /**
     * Determine if the given position is a legal move on the board.  The 
     * position must be on the board and not have been used yet.
     * @param row - the row of the position to test
     * @param col - the column of the position to test
     * @return true if the move is legal, false otherwise
     */
    private boolean legalMove(final int row, final int col)
    {
        if (onBoard(row, col) && board[row][col] == 0)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }

    /**
     * Check that the given position is on the board.  This is to avoid 
     * repeating the code in different methods.
     * @param row - the given row
     * @param col - the given column
     * @return true if the position is on the board, false otherwise.
     */
    private boolean onBoard(final int row, final int col)
    {
        return (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS) ;
    }

    /**
     * Lower the accessibility number of every position accessible
     * from the current position.  This must be called just before
     * the knight is moved to the next position.
     */
    private void reduceAccess()
    {
        for (int i = 0; i < MOVES; ++i)
        {
            int r = currentRow + HORIZONTAL[i] ;
            int c = currentCol + VERTICAL[i] ;
            if (onBoard(r, c) && accessibility[r][c] > 0)
            {
                --accessibility[r][c] ;
            }
        }

    }

    /**
     * Test the final position against the start position to see if this was a 
     * closed tour.  This makes no attempt to check if it was a full tour which
     * is why the method is private.  Also the start position must be passed in 
     * since we do not keep track of it.
     * @param beginRow - the start row
     * @param beginCol - the start column
     * @return true if the tour was closed, false otherwise
     */
    private boolean closedTour(final int beginRow, final int beginCol)
    {
        for (int i = 0; i < MOVES; ++i)
        {
            if (currentRow + HORIZONTAL[i] == beginRow
                    && currentCol + VERTICAL[i] == beginCol)
            {
                return true ;
            }
        }
        return false ;
    }

    /**
     * Display the board to the console.  (0, 0) is the top left.
     */
    public void printBoard()
    {
        printArray(board) ;
    }

    /**
     * Print any ROWS x COLUMNS integer array.  This is here to help with
     * debugging the accessibility matrix if necessary, although that turned
     * out to be fine
     * @param a - the array to display
     */
    private void printArray(final int[][] a)
    {
        for (int i = 0; i < ROWS; ++i)
        {
            for (int j = 0; j < COLUMNS; ++j)
            {
                System.out.printf("%2d ", a[i][j]) ;
            }
            System.out.println() ;
        }
    }

    /**
     * Run the ten possible tours for this algorithm and display the board.
     * @param args - any arguments are ignored
     */
    public static void main(String[] args)
    {
        Heuristic h = null ;
        for (int i = 0; i < ROWS / 2; ++i)
        {
            for (int j = (ROWS / 2 - 1); j >= i; --j)
            {
                h = new Heuristic(i, j) ;
            }
        }
    }

}
