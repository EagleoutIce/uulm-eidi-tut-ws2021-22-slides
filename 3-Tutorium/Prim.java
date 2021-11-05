import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        scanner.close();

        int teiler = 1; // 1 für prim
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                teiler = i;
                break;
            }
        }

        if (teiler > 1) {
            System.out.format("%d ist keine Primzahl, da %d n teilt\n", n, teiler);
        } else {
            System.out.format("%d ist eine Primzahl\n", n);
        }
    }
}
