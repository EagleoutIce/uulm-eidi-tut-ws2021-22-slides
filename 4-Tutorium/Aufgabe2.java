public class Aufgabe2 {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(reverse(arg));
        }
    }

    public static String reverse(final String arg) {
        char[] orig = arg.toCharArray();
        char[] rev = new char[orig.length];

        for (int i = 0; i < orig.length; i++) {
            rev[orig.length - i - 1] = orig[i];
        }
        return new String(rev);
    }
}
