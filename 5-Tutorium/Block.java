public class Block {
static int test = 0;
public static void main(String[] args){
    System.out.print(test + " ");
    {
        int test = 15; // Überschreibe lokal
        System.out.print(test + " ");
    }
    System.out.print(test);
}
}