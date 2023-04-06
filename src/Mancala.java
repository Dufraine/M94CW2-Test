import java.util.Scanner;
public class Mancala {
    static int currentPlayer;
    static int selectedPit;

    public void runGame(){

        Scanner sc = new Scanner(System.in);
        System.out.println("The game");
        Board newBoard = new Board();
        int[] board = newBoard.getBoard();

        currentPlayer = 1;

        boolean check = true;

        while (check) {

        // Display the current board state
        System.out.println("Player " + currentPlayer + "'s turn");

        newBoard.displayBoard(board);

        validateSelection(sc, board);

        distributeStones(board);

        check = checkGameStatus(board);

        // Switch to the next player
        currentPlayer = (currentPlayer == 1) ? 2 : 1;

        }


    }

    public static void validateSelection(Scanner sc, int[] board) {

        // Get the pit number selected by the player
        System.out.print("Select a pit: ");
        selectedPit = sc.nextInt();

        // Validate the pit number
        if (selectedPit < 0 || selectedPit >= 13) {
            System.out.println("Invalid pit number. Try again.");
            validateSelection(sc, board);
        }
        // Check if the selected pit belongs to the current player
        if (currentPlayer == 1 && selectedPit > 5) {
            System.out.println("Invalid pit. Try again.");
            validateSelection(sc, board);
        } else if (currentPlayer == 2 && selectedPit < 7) {
            System.out.println("Invalid pit. Try again.");
            validateSelection(sc, board);
        }

        // Check if the selected pit has any seeds
        if (board[selectedPit] == 0) {
            System.out.println("The pit is empty. Try again.");
            validateSelection(sc, board);
        }

    }

    public static void distributeStones(int[] board) {
        // Distribute the seeds from the selected pit
        int seeds = board[selectedPit];
        board[selectedPit] = 0;
        int i = selectedPit + 1;
        while (seeds > 0) {
            if (i == 14) {
                i = 0;
            }
            if ((currentPlayer == 1 && i != 13) || (currentPlayer == 2 && i != 6)) {
                board[i]++;
                seeds--;
            }
            i++;
        }
    }

    public static boolean checkGameStatus(int[] board) {

        // Check if the game is over
        int p1Seeds = 0;
        int p2Seeds = 0;
        for (int i = 0; i < 6; i++) {
            p1Seeds += board[i];
        }
        for (int i = 7; i < 13; i++) {
            p2Seeds += board[i];
        }
        if (p1Seeds == 0 || p2Seeds == 0) {
            System.out.println("Player 1: " + board[6] + " seeds");
            System.out.println("Player 2: " + board[13] + " seeds");
            if (board[6] > board[13]) {
                System.out.println("Player 1 wins!");
            } else if (board[6] < board[13]) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("It's a draw!");
            }
            return false;
        }

        return true;
    }
}
