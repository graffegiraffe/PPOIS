import by.rublevskaya.taggame.FifteenPuzzle;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class FifteenPuzzleTest {
   private FifteenPuzzle puzzle;

   @Before
   public void setUp() {
       puzzle = new FifteenPuzzle(4);
   }

   @Test
   public void testInitializeGameBoard() {

       assertEquals(4, puzzle.board.length);
       assertEquals(4, puzzle.board[0].length);

       boolean foundEmptyCell = false;
       for (int row = 0; row < puzzle.board.length; row++) {
           for (int col = 0; col < puzzle.board[row].length; col++) {
               if (puzzle.board[row][col] == FifteenPuzzle.EMPTY_CELL) {
                   foundEmptyCell = true;
                   break;
               }
           }
       }
       assertTrue(foundEmptyCell);
   }

   @Test
   public void testMoveSpecificTileValid() {

       int emptyRow = 0;
       int emptyCol = 0;

       for (int row = 0; row < puzzle.board.length; row++) {
           for (int col = 0; col < puzzle.board[row].length; col++) {
               if (puzzle.board[row][col] == FifteenPuzzle.EMPTY_CELL) {
                   emptyRow = row;
                   emptyCol = col;
               }
           }
       }

       boolean moved = false;
       if (emptyRow > 0) {
           moved = puzzle.moveSpecificTile(puzzle.board[emptyRow - 1][emptyCol]);
       } else if (emptyCol > 0) {
           moved = puzzle.moveSpecificTile(puzzle.board[emptyRow][emptyCol - 1]);
       }

       assertTrue(moved);
   }

   @Test
   public void testMoveSpecificTileInvalid() {

        assertFalse(puzzle.moveSpecificTile(-1));
        assertFalse(puzzle.moveSpecificTile(999));
    }

    @Test
    public void testDecisionMadeFalse() {

        assertFalse(puzzle.decisionMade());
    }

    @Test
    public void testDecisionMadeTrue() {

        for (int i = 0; i < puzzle.board.length; i++) {
            for (int j = 0; j < puzzle.board[i].length; j++) {
                if (i == puzzle.board.length - 1 && j == puzzle.board[i].length - 1) {
                    puzzle.board[i][j] = FifteenPuzzle.EMPTY_CELL;
                } else {
                    puzzle.board[i][j] = i * puzzle.board.length + j + 1;
                }
            }
        }
        assertTrue(puzzle.decisionMade());
    }

   @Test
   public void testFindSpecificPosition() {
        int[] position = puzzle.findSpecificPosition(FifteenPuzzle.EMPTY_CELL);
        assertNotNull(position);
        assertEquals(2, position.length);
    }

}
