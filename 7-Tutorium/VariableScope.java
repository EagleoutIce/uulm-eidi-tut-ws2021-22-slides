public class VariableScope {
   static final int a = 12;
   static int b = 47;

   public static void print() {
      System.out.println("a=" + a + ", b=" + b + "\n");
   }

   public static void print(int b, int a) {
      System.out.println("a=" + a + ", b=" + b + "\n");
   }

   public static void main(String[] args) {
      int a = 17;
      int b = 24;
      print();
      print(a, 14);
      System.out.println("a=" + a + ", b=" + b);
   }
}
