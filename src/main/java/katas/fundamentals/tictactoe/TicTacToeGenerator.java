package katas.fundamentals.tictactoe;

/*
Do you have in mind the good old TicTacToe?

Assuming that you get all the data in one array, you put a space around each value, | as a columns separator and multiple - as rows separator, with something like ["O", "X", " ", " ", "X", " ", "X", "O", " "] you should be returning this structure (inclusive of new lines):

 O | X |
-----------
   | X |
-----------
 X | O |

Now, to spice up things a bit, we are going to expand our board well beyond a trivial 3 x 3 square and we will accept rectangles of big sizes, still all as a long linear array.

For example, for "O", "X", " ", " ", "X", " ", "X", "O", " ", "O"] (same as above, just one extra "O") and knowing that the length of each row is 5, you will be returning

 O | X |   |   | X
-------------------
   | X | O |   | O

And worry not about missing elements, as the array/list/vector length is always going to be a multiple of the width.

 */
public class TicTacToeGenerator {
    public static String displayBoard(final char[] board, int width) {
        StringBuilder sb = new StringBuilder();
        String separator = "\n"+"-".repeat(width * 3 + (width -1)) + "\n";
        int index = 0;
        while (index < board.length) {
            if ((index + width) % width == 0 && index != 0) {
                sb.append(separator);
            }
            for(int col = index; col < index + width; col++) {
                sb.append(" ")
                        .append(board[col])
                        .append(" ");
                if (col < index +width - 1) {
                    sb.append("|");
                }
            }
            index += width;
        }
        return sb.toString(); //your code here
    }

}
