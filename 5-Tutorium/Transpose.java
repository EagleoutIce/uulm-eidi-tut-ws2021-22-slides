public class Transpose {
   public static void main(String[] args) {
       int N = (int) (Math.random() * 8 + 3);
       int M = (int) (Math.random() * 8 + 3);

       int[][] matrix = new int[N][M];
       for(int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               matrix[i][j] = (int) (Math.random() * 10);
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println("");
       }

       System.out.println("\nTransponierte Matrix\n");
       int[][] transposed = new int[M][N];
       for (int i = 0; i <M; i++) {
           for (int j = 0; j < N; j++) {
               transposed[i][j] = matrix[j][i];
               System.out.print(transposed[i][j] + " ");
           }
           System.out.println("");
       }
   }
}
