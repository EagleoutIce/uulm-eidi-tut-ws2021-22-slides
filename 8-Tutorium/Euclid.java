import java.util.Scanner;

public class Euclid {
    public static int ggtRecursive(int a, int b) {
        if(b == 0)
            return a;
        else
            return ggtRecursive(b, a % b);
    }

    public static int ggtIterative(int a, int b) {
        while(b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();

        System.out.println(ggtIterative(a,b));
        System.out.println(ggtRecursive(a,b));

        scanner.close();
    }
}
