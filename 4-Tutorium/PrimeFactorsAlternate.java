public class PrimeFactorsAlternate {
   public static void main(String[] args) {
      if (args.length != 1)
         System.exit(1);

      int N = Integer.parseInt(args[0]);
      if (N < 1) {
         System.exit(1);
      } else if (N == 1) {
         System.out.println("Die Zahl 1 besitzt keine Primfaktorzerlegung");
         return;
      }

      // Berechnung der Primfaktorzerlegung
      System.out.print("Die Primfaktorzerlegung von " + N + " lautet: ");
      int max = N;
      for (int i = 2; i <= max; i++) {
            while ((N % i) == 0) {
               N /= i;
               System.out.print((N >= 2) ? i + " * " : i);
            }
      }
      System.out.println("");
   }
}
