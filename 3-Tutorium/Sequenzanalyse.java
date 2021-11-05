import java.util.Scanner;

public class Sequenzanalyse {
    // Hinweis: die wiederholte Ausgabe von i
    // ist primär für die Präsentation und nicht
    // gefordert :)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prev;
        int i = scanner.nextInt();
        System.out.print(i + " ");
        boolean accept = true;
        while(i > 0 && accept) {
            prev = i;
            i = scanner.nextInt();
            System.out.print(i + " ");
            if (i <= 0)
                break;

            accept = check(prev, i);
        }
        scanner.close();
        System.out.println();
        System.out.println(accept ? "Akzeptiert" : "Abgelehnt");
    }

    static boolean check(int prev, int i) {
        if(prev % 2 == i % 2)
            return prev <= i;
        else
            return prev > i;
    }
}
