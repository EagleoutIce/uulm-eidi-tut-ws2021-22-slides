import java.util.Scanner;

public class TicTacToe {
   private static Scanner scanner;

   public static char[][] getMove(int player, char[][] board) {
      System.out.println("Spieler " + player + " ist am Zug:");
      int move = 0;
      do {
         move = scanner.nextInt();
      } while (!isMoveValid(board, move));
      return makeMove(board, move, player);
   }

   public static boolean isMoveValid(char[][] board, int move) {
      return move >= 0 && move <= 9 && board[getY(move)][getX(move)] == 0;
   }

   public static int getX(int cellNumber) {
      return (cellNumber - 1) % 3;
   }

   public static int getY(int cellNumber) {
      return (cellNumber - 1) / 3;
   }

   private static char[][] makeMove(char[][] board, int cellNumber, int player) {
      char[][] newBoard = new char[3][3];
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            newBoard[i][j] = board[i][j];
         }
      }
      newBoard[getY(cellNumber)][getX(cellNumber)] = getPlayerSymbol(player);
      return newBoard;
   }

   public static char getPlayerSymbol(int player) {
      return (player == 1) ? 'x' : 'o';
   }

   public static void printBoard(char[][] board) {
      for (char[] row : board) {
         System.out.println("+---+---+---+");
         for (char cell : row)
            System.out.print("| " + (cell != 0 ? cell : ' ') + " ");
         System.out.println("|");
      }
      System.out.println("+---+---+---+\n");
   }

   public static boolean winningMove(int player, char[][] board) {
      char c = getPlayerSymbol(player);
      return winsHorizontal(board, c) || winsVertical(board, c) || winsDiagonal(board, c);
   }

   private static boolean winsHorizontal(char[][] board, char player) {
      return ((board[0][0] == c) && (board[0][1] == c) && (board[0][2] == c)) ||
            ((board[1][0] == c) && (board[1][1] == c) && (board[1][2] == c)) ||
            ((board[2][0] == c) && (board[2][1] == c) && (board[2][2] == c));
   }

   private static boolean winsVertical(char[][] board, char player) {
      return ((board[0][0] == c) && (board[1][0] == c) && (board[2][0] == c)) ||
            ((board[0][1] == c) && (board[1][1] == c) && (board[2][1] == c)) ||
            ((board[0][2] == c) && (board[1][2] == c) && (board[2][2] == c));
   }

   private static winsDiagonal(char[][] board, char player) {
      return ((board[0][0] == c) && (board[1][1] == c) && (board[2][2] == c)) ||
            ((board[2][0] == c) && (board[1][1] == c) && (board[0][2] == c));
   }

   public static char[][] emptyTicTacToeBoard() {
      char[][] board = new char[3][3];
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            board[i][j] = 0;
         }
      }
      return board;
   }

   public static int otherPlayer(int player) {
      return player == 1 ? 2 : 1;
   }

   public static void main(String[] args) {
      scanner = new Scanner(System.in);
      int player = 1;
      char[][] board = emptyTicTacToeBoard();

      // Game loop
      for (int i = 0; i < 9; i++) {
         board = getMove(player, board);
         printBoard(board);

         if (winningMove(player, board)) {
            System.out.println("Spieler " + player + " hat gewonnen!");
            return;
         }

         player = otherPlayer(player);
      }
      System.out.println("Unentschieden");
      scanner.close(); // wichtig
   }
}
