/**
 * Sichtbarkeit
 */
public class Sichtbar {

    static int x = 0;
    static int y = 0;
    static boolean z = false;

    @SuppressWarnings({ "java:S2234", "java:S106" })
    public static void main(String[] args) {
        // Zeitpunkt 1
        methode1(y, x);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        // Zeitpunkt 2
        methode2(x, y);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        // Zeitpunkt 3
        methode3(x, y, z);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
    }

    @SuppressWarnings({ "java:S1854", "java:S1226" })
    public static void methode1(int x, int y) {
        x = y + 2;
        y = x + 3;
    }

    @SuppressWarnings({ "java:S1854", "java:S1226" })
    public static void methode2(int a, int y) {
        a = y + 2;
        x = a + 3;
    }

    @SuppressWarnings({ "java:S1854", "java:S1226" })
    public static void methode3(int a, int b, boolean c) {
        a = y;
        b = a + 5;
        x = a + b;
        y = x * 5;
        if (y < x)
            c = true;
        else
            z = true;
    }
}