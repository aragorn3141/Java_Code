/**
 * 
 */
package assignment2 ;

import java.util.Random ;

/**
 * @author rjudd
 */
public class BruteForce
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
     * The number of possible moves that a knight can make. This is really just
     * the length of the HORIZONTAL and VERTICAL arrays.
     */
    public static final int MOVES = 8 ;

    /**
     * The possible moves that the knight can make horizonatally. This is pairs
     * up with the VERTICAL array.
     */
    public static final int[] HORIZONTAL = { 2, 1, -1, -2, -2, -1, 1, 2 } ;

    /**
     * The possible moves that the knight can make vertically. This is pairs up
     * with the HORIZONTAL array.
     */
    public static final int[] VERTICAL = { -1, -2, -2, -1, 1, 2, 2, 1 } ;

    /**
     * The internal representation of the chessboard.
     */
    private int[][] board = new int[ROWS][COLUMNS] ;

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
     * Random number generator in order to decide which legal move to make next.
     */
    private Random random = new Random() ;

    /**
     * Create an instance of BruteForce and run a tour. Each time you call this
     * you will get a different tour because of the random choice made for each
     * move.
     * 
     * @param row -
     *            the starting row
     * @param column -
     *            the starting column
     */
    public BruteForce(final int row, final int column)
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
            printBoard() ;
        }
    }

    /**
     * Accessor for the number of moves made in this tour. If it is a full tour
     * then the number of moves made will be 64.
     * 
     * @return the number of moves in the tour.
     */
    public int getMoves()
    {
        return moves ;
    }

    /**
     * Play the game and return the number of moves made.
     * 
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
     * Calculate the next move and make it if there is a possible move. If more
     * than one move is possible, then choose one at random.
     * 
     * @return true if a move was made and false otherwise.
     */
    private boolean nextMove()
    {
        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 } ;
        int position = 0 ;
        for (int i = 0; i < MOVES; ++i)
        {
            int r = currentRow + HORIZONTAL[i] ;
            int c = currentCol + VERTICAL[i] ;
            if (legalMove(r, c))
            {
                moves[position] = i ;
                ++position ;
            }
        }

        if (position > 0)
        {
            int m = random.nextInt(position) ;
            currentRow += HORIZONTAL[moves[m]] ;
            currentCol += VERTICAL[moves[m]] ;
            return true ;
        }
        else
        {
            return false ;
        }
    }

    /**
     * Determine if the given position is a legal move on the board. The
     * position must be on the board and not have been used yet.
     * 
     * @param row -
     *            the row of the position to test
     * @param col -
     *            the column of the position to test
     * @return true if the move is legal, false otherwise
     */
    private boolean legalMove(final int row, final int col)
    {
        if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS
                && board[row][col] == 0)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }

    /**
     * Test the final position against the start position to see if this was a
     * closed tour. This makes no attempt to check if it was a full tour which
     * is why the method is private. Also the start position must be passed in
     * since we do not keep track of it.
     * 
     * @param beginRow -
     *            the start row
     * @param beginCol -
     *            the start column
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
     * Display the board to the console. (0, 0) is the top left.
     */
    public void printBoard()
    {
        for (int i = 0; i < ROWS; ++i)
        {
            for (int j = 0; j < COLUMNS; ++j)
            {
                System.out.printf("%2d ", board[i][j]) ;
            }
            System.out.println() ;
        }
    }

    /**
     * Try up to 1,000,000 tours, stopping when a full tour is achieved.
     * 
     * @param args -
     *            any arguments are ignored
     */
    public static void main(String[] args)
    {
        BruteForce bf = null ;
        int i = 0 ;
        for (; i < 1000000; ++i)
        {
            bf = new BruteForce(0, 0) ;
            if (bf.getMoves() == 64)
            {
                break ;
            }
            if (i % 100000 == 0)
            {
                System.out.println(i / 100000) ;
            }
        }
        System.out.println("Trials: " + i) ;
    }

}
