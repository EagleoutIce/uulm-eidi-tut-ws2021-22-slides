import java.util.Scanner;

public class Minimax {
    private static final int LOSE_HUMAN = 10;
    private static final int WIN_HUMAN = -10;
    private static final int DRAW = 0;
    private static final char PLAYER_COMP = 'X';
    private static final char PLAYER_HUMAN = 'O';
    private static final char EMPTY = 0;
    private static Scanner scanner;

    // This function is used to initiate the Minimax algorithm with a list of
    // available moves
    public static char[][] computerMove(char[][] board) {
        System.out.println("Computer ist am Zug:");
        int bestScore = WIN_HUMAN;
        int bestMove = 1;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (board[y][x] == EMPTY) {
                    board[y][x] = PLAYER_COMP;
                    int score = minimax(board, PLAYER_HUMAN);
                    board[y][x] = EMPTY;
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = y * 3 + x + 1;
                    }
                }
            }
        }

        return makeMove(board, bestMove, PLAYER_COMP);
    }

    // This function executes the actual Minimax algorithm
    public static int minimax(char[][] board, char player) {
        if (winningMove(PLAYER_HUMAN, board))
            return WIN_HUMAN;
        else if (winningMove(PLAYER_COMP, board))
            return LOSE_HUMAN;
        else if (isFull(board))
            return DRAW;

        int bestScore = player == PLAYER_HUMAN ? LOSE_HUMAN : WIN_HUMAN;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (board[y][x] != EMPTY)
                    continue;
                board[y][x] = player;
                int score = minimax(board, otherPlayer(player));
                board[y][x] = EMPTY;
                if(player == PLAYER_HUMAN)
                    bestScore = Math.min(score, bestScore);
                else
                    bestScore = Math.max(score, bestScore);
            }
        }
        return bestScore;
    }

    private static char otherPlayer(char player) {
        return player == PLAYER_HUMAN ? PLAYER_COMP : PLAYER_HUMAN;
    }

    public static boolean isFull(char[][] board) {
        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                if (board[y][x] == EMPTY)
                    return false;
        return true;
    }

    public static boolean isMoveValid(char[][] board, int move) {
        return move >= 1 && move <= 9 && board[getY(move)][getX(move)] == 0;
     }

     public static int getX(int cellNumber) {
        return (cellNumber - 1) % 3;
     }

     public static int getY(int cellNumber) {
        return (cellNumber - 1) / 3;
     }

     public static char[][] getMove(char player, char[][] board) {
        System.out.println("Spieler " + player + " ist am Zug:");
        int move = 0;
        do {
           move = scanner.nextInt();
        } while (!isMoveValid(board, move));
        return makeMove(board, move, PLAYER_HUMAN);
     }

     private static char[][] makeMove(char[][] board, int cellNumber, char player) {
        char[][] newBoard = new char[3][3];
        for (int y = 0; y < 3; y++) {
            newBoard[y] = board[y].clone();
        }
        newBoard[getY(cellNumber)][getX(cellNumber)] = player;
        return newBoard;
     }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println("+---+---+---+");
            for (char cell : row) {
                System.out.print("| " + (cell != EMPTY ? cell : ' ') + " ");
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
        for (int y = 0; y < 3; y++)
            for (int j = 0; j < 3; j++)
                board[y][j] = 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean nextGame = true;
        scanner = new Scanner(System.in);

        while (nextGame) {
            initGame(board);
            System.out.println("Bitte wählen Sie aus wer beginnen soll: (0) Computer, (1) Sie");
            boolean humanPlayer = scanner.nextInt() != 0;
            boolean win = false;
            // Game loop
            for (int i = 9; i >= 1; i--) {
                if (humanPlayer) {
                    board = getMove(PLAYER_HUMAN, board);
                    printBoard(board);
                    humanPlayer = false;
                    if (winningMove(PLAYER_HUMAN, board)) {
                        // this should now be unreachable
                        System.out.println("Sie haben gewonnen.");
                        win = true;
                        break;
                    }
                } else {
                    board = computerMove(board);
                    printBoard(board);
                    humanPlayer = true;
                    if (winningMove(PLAYER_COMP, board)) {
                        System.out.println("Computer hat gewonnen.");
                        win = true;
                        break;
                    }
                }
            }

            if (!win)
                System.out.println("Unentschieden!");

            System.out.println("\nErneut spielen? (0) Nein, (1) Ja");
            nextGame = scanner.nextInt() != 0;
        }
        scanner.close();
    }
}
