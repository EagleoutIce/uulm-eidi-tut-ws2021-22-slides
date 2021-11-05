import java.util.Scanner;

public class BizzFuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        scanner.close();
        int bizzes = 0;
        int fuzzes = 0;
        int bizzfuzzes = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                bizzfuzzes++;
            else if (i % 5 == 0)
                bizzes++;
            else if (i % 3 == 0)
                fuzzes++;
        }
        System.out.format("fuzzes: %d, bizzes: %d, bizzfuzz: %d\n", fuzzes, bizzes, bizzfuzzes);
    }
}
