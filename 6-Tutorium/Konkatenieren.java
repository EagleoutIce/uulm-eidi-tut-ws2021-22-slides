/**
 * Konkatenieren
 */
public class Konkatenieren {

    static String str1 = "  _._     _,-\"\"'-._     \n (,-.'._,'(      |\\'-/|  \n";
    static String str2 = "     '-.-'\\ )-'( , o o)  \n Katze    '-    \\'-'\"'-   ";

    private static String concat(char a, String sa) {
        return concat(String.valueOf(a), sa);
    }

    private static String concat(String sa, String sb) {
        String result = sa + sb;
        if (result.contains("Katze"))
            cat();
        return result;
    }

    private static void cat() {
        System.out.println(str1 + str2);
    }

    public static void main(String[] args) {
        char a = 'K';
        char b = 'H';

        String sa = "atze";
        String sb = "und";

        String e1 = concat(a, sa);
        String e2 = concat(b, sb);
        String e3 = concat(sa, sb);
        String e4 = concat(concat(a, sa), " " + sb + " " + concat(b, sb));

        System.out.println(e1); // => "Katze"
        System.out.println(e2); // => "Hund"
        System.out.println(e3); // => "atzeund"
        System.out.println(e4); // => "Katze und Hund"
    }
}