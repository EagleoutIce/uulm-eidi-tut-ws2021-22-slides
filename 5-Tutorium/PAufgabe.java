/**
 * PAufgabe
 */
public class PAufgabe {
    static int a = 5;
    static int b = 10;
    static boolean c = true;

    public static void main(String[] args) {
        methode1(b, a);
        methode2(a, c);
    }

    static void methode1(int a, int b) {
        boolean c = false;
        b = b*a;
        System.out.println(a + " " + b + " " + c);
    }

    static void methode2(int b, boolean d) {
        b = a - b;
        System.out.println(a + " " + b + " " +
                            c + " " + d);
    }
}