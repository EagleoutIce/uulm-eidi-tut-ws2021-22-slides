import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1:1 die Musterlösung.
public class EfficientMinimax {
    private static Scanner scanner;

    // This class is used to store the coordinates of the available moves
    public static class Move {
        int y;
        int x;
        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // This function is used to initiate the Minimax algorithm with a list of available moves
    public static char[][] computerMove(char[][] board, int numMoves) {
        List<Move> availableMoves = new ArrayList<Move>(numMoves);
        System.out.println("Computer ist am Zug");

        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (board[x][y] == 0)
                    availableMoves.add(new Move(x, y));

        int bestScore = -10;
        int bestX = -1;
        int bestY = -1;

        for (Move move : availableMoves) {
            board[move.x][move.y] = 'x';
            List<Move> remainingMoves = new ArrayList<Move>(availableMoves);
            remainingMoves.remove(move);

            int score = minimax(board,  remainingMoves, false);
            board[move.x][move.y] = 0;
            if (score > bestScore) {
                bestScore = score;
                bestX = move.x;
                bestY = move.y;
            }
        }

        char[][] newBoard = board.clone();
        for(int i = 0; i < board.length; i ++)
            newBoard[i] = board[i].clone();

        newBoard[bestX][bestY] = 'x';
        return newBoard;
    }

    // This function executes the actual Minimax algorithm
    public static int minimax(char[][] board, List<Move> availableMoves, boolean maximize) {
        // evaluate whether the game is over
        if (winningMove('x', board))
            return 10 - availableMoves.size();
        else if (winningMove('o', board))
            return -10 + availableMoves.size();
        else if (availableMoves.isEmpty())
            return 0;

        if (maximize) {
            int bestScore = -100;
            for (Move move : availableMoves) {
                board[move.x][move.y] = 'x';
                List<Move> remainingMoves = new ArrayList<Move>(availableMoves);
                remainingMoves.remove(move);

                int score = minimax(board,  remainingMoves, false);
                board[move.x][move.y] = 0;
                bestScore = Math.max(bestScore, score);
            }
            return bestScore;
        } else {
            int bestScore = 100;
            for (Move move : availableMoves) {
                board[move.x][move.y] = 'o';
                List<Move> remainingMoves = new ArrayList<Move>(availableMoves);
                remainingMoves.remove(move);

                int score = minimax(board,  remainingMoves, true);
                board[move.x][move.y] = 0;
                bestScore = Math.min(bestScore, score);
            }
            return bestScore;
        }
    }

    public static char[][] getMove(char[][] board) {
        System.out.println("Ihr nächster Zug:");
        while (true) {
            int move = scanner.nextInt();
            if ((move < 0) || (move > 9)) {
                System.out.println("Ungültige Auwahl");
                continue;
            }
            int x = (move - 1) / 3;
            int y = (move - 1) % 3;
            if (board[x][y] != 0) {
                System.out.println("Feld ist bereits belegt");
                continue;
            }

            char[][] newBoard = board.clone();
            for(int i = 0; i < board.length; i++)
                newBoard[i] = board[i].clone();

            newBoard[x][y] = 'o';
            return newBoard;
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println("+---+---+---+");
            for (char cell : row) {
                System.out.print("| " + (cell != 0 ? cell : ' ') + " ");
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+\n");
    }

    public static boolean winningMove(char c, char[][] board) {
        return horizontalWin(c, board) || verticalWin(c, board) || diagonalWin(c, board);
    }

    private static boolean horizontalWin(char c, char[][] board) {
        return ((board[0][0] == c) && (board[0][1] == c) && (board[0][2] == c)) ||
                ((board[1][0] == c) && (board[1][1] == c) && (board[1][2] == c)) ||
                ((board[2][0] == c) && (board[2][1] == c) && (board[2][2] == c));
    }

    private static boolean verticalWin(char c, char[][] board) {
        return ((board[0][0] == c) && (board[1][0] == c) && (board[2][0] == c)) ||
                ((board[0][1] == c) && (board[1][1] == c) && (board[2][1] == c)) ||
                ((board[0][2] == c) && (board[1][2] == c) && (board[2][2] == c));
    }

    private static boolean diagonalWin(char c, char[][] board) {
        return ((board[0][0] == c) && (board[1][1] == c) && (board[2][2] == c)) ||
                ((board[2][0] == c) && (board[1][1] == c) && (board[0][2] == c));
    }

    public static void initGame(char[][] board) {
        scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean nextGame = true;

        while(nextGame) {
            initGame(board);
            System.out.println("Bitte wählen Sie aus wer beginnen soll: (0) Computer, (1) Sie");
            boolean humanPlayer = scanner.nextInt() != 0;
            boolean win = false;
            // Game loop
            for (int i = 9; i >= 1; i--) {
                if (humanPlayer) {
                    board = getMove(board);
                    printBoard(board);
                    humanPlayer = false;
                    if (winningMove('o', board)) {
                        // this should now be unreachable
                        System.out.println("Sie haben gewonnen.");
                        win = true;
                        break;
                    }
                } else {
                    board = computerMove(board, i);
                    printBoard(board);
                    humanPlayer = true;
                    if (winningMove('x', board)) {
                        System.out.println("Computer hat gewonnen.");
                        win = true;
                        break;
                    }
                }
            }

            if(!win)
                System.out.println("Unentschieden!");

            System.out.println("\nErneut spielen? (0) Nein, (1) Ja");
            nextGame = scanner.nextInt() != 0;
        }
    }
}
