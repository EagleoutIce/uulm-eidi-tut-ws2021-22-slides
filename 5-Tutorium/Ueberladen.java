public class Ueberladen {

    public static void print(short   a)   {
        System.out.println("Short: " + a);
    }
    public static void print(int     a)   {
        System.out.println("Int: " + a);
    }
    public static void print(float   a)   {
        System.out.println("Float: " + a);
    }
    public static void print(double  a)   {
        System.out.println("Double: " + a);
    }

    public static void main(String[] args) {
        print(2); print('a'); print(0.25); print(0.1f); 
        print((byte) 15); // <-- !
    }
}