public class CallBy {
    static String a = "Blumen";
    static int b = 20;
    static boolean c = false;

    @SuppressWarnings({ "java:S1854", "java:S1226" })
    static int m(String x, int y, boolean c) {
        x = "Ich habe " + y + " " + x;
        c = true;
        y = b + 10;
        return b;
    }
    @SuppressWarnings({ "java:S1854" })
    static void n(int i) {
        if (c)
            i = i + i;
        else
            i = i - 2;
    }

    public static void main(String[] args) {
        n(m(a,b,c));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
