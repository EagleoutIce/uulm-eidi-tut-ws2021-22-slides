public class Pyramid {
   public static void main(String[] args) {
      if (args.length != 1)
         System.exit(1);
      int n = Integer.parseInt(args[0]);
      // Oder auch gerne 'n'

      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n - i; j++) {
            System.out.print(" ");
         }
         for (int j = 1; j <= i; j++) {
            System.out.print("* "); // zusätzlichen Leerzeichen
         }
         System.out.println(); // Zeilenumbruch
      }
   }
}
