public class MatrixMultiplication {
    public static void main(String[] args) {
        // Note: i shortened the maximum to 7 for my slides :/
        int N = (int) (Math.random() * 7 + 3);
        int M = (int) (Math.random() * 7 + 3);

        // Damit es schön untereinander ist, formatiere ich mit
        // System.out.format
        System.out.println("Matrix 1:");
        int[][] matrix1 = generateMatrix(N, M);
        System.out.println("Matrix 2:");
        int[][] matrix2 = generateMatrix(M, N);

        int[][] result = new int[N][N];
        System.out.println("Ergebnismatrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = 0;
                for (int k = 0; k < M; k++) {
                    tmp += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = tmp;
                System.out.format("%3d ", result[i][j]);
            }
            System.out.println("");
        }

    }

    // (https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax)
    private static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.format("%2d ", matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        return matrix;
    }
}
