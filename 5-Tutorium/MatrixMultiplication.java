public class MatrixMultiplication {
   public static void main(String[] args) {
       int N = (int) (Math.random() * 8 + 3);
       int M = (int) (Math.random() * 8 + 3);

       int[][] matrix1 = new int[N][M];
       for(int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               matrix1[i][j] = (int) (Math.random() * 10);
               System.out.print(matrix1[i][j] + " ");
           }
           System.out.println("");
       }
       System.out.println("");

       int[][] matrix2 = new int[M][N];
       for(int i = 0; i < M; i++) {
           for (int j = 0; j < N; j++) {
               matrix2[i][j] = (int) (Math.random() * 10);
               System.out.print(matrix2[i][j] + " ");
           }
           System.out.println("");
       }
       System.out.println("");

       int[][] result = new int[N][N];
       for(int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               int tmp = 0;
               for (int k = 0; k < M; k++) {
                   tmp += matrix1[i][k] * matrix2[k][j];
               }
               result[i][j] = tmp;
               System.out.print(result[i][j] + " ");
           }
           System.out.println("");
       }

   }
}
