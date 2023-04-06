public class Board {
    final private int FOUR_STONES = 1;
    final private int[] board = {FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, 0, FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, FOUR_STONES, 0};
    public int[] getBoard() {
        return board;
    }

    public void displayBoard(int[] board) {
        System.out.println("--------------------------------");
        System.out.println("Player 2 Pits");
        System.out.println("Pit  12  11  10   9   8   7");
        System.out.println("--------------------------------");
        System.out.println("     " + board[12] + "   " + board[11] + "   " + board[10] + "   " + board[9] + "   " + board[8] + "   " + board[7]);
        System.out.println("--------------------------------");
        System.out.println("M2   " + board[13] + "                      " + board[6] + "    M1");
        System.out.println("--------------------------------");
        System.out.println("      " + board[0] + "   " + board[1] + "   " + board[2] + "   " + board[3] + "   " + board[4] + "   " + board[5]);
        System.out.println("--------------------------------");
        System.out.println("Pit   0   1   2   3   4   5");
        System.out.println("Player 1 Pits");
        System.out.println("--------------------------------");
    }

}
