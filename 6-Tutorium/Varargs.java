/**
 * Varargs
 */
public class Varargs {

    private static boolean isItChar(Object obj) {
        return obj instanceof Character;
    }

    private static String concat(Object a, Object b) {
        return objToString(a) + objToString(b);
    }

    private static String concat(Object... as) {
        String result = "";
        for (Object a : as)
            result += objToString(a);
        return result;
    }

    public static String objToString(Object o) {
        if (o instanceof String)
            return (String) o;
        else if (o instanceof Character)
            return String.valueOf(o);
        return null; // Fehlerfall
    }

    public static void main(String[] args) {
        System.out.println(isItChar('x'));
        System.out.println(isItChar("m"));
        System.out.println(isItChar((char) 13));
        System.out.println(isItChar(42));
        System.out.println(objToString('A'));
        System.out.println(objToString(13));
        System.out.println(objToString('m'));

        System.out.println(concat('a', 'b'));
        System.out.println(concat('a', "hallo"));
        System.out.println(concat("Hubert", "ida"));
        System.out.println(concat('a'));
        System.out.println(concat("b",'y', (char)39));
        System.out.println(concat('h',"amst",'e',"rpi",(char)101,"pse", 'r'));
    }
}