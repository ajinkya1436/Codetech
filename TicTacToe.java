import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
    private char currentPlayer;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }

    public void startGame() {
        currentPlayer = PLAYER_X;
        printBoard();

        while (true) {
            if (currentPlayer == PLAYER_X) {
                playerMove();
            } else {
                computerMove();
            }

            printBoard();

            if (checkForWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        board[row][col] = currentPlayer;
    }

    private void computerMove() {
        Random random = new Random();
        int row, col;

        System.out.println("Computer's move:");

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
            return false;
        }
        return true;
    }

    private boolean checkForWin() {
        // Check rows, columns, and diagonals for a win
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
}
