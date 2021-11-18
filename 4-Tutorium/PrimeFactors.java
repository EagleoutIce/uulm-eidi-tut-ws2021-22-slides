public class PrimeFactors {
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

      // Sieb des Eratosthenes
      boolean marker[] = new boolean[N + 1];
      for (int i = 0; i <= N; i++)
         marker[i] = false;

      for (int i = 2; i < Math.sqrt(N); i++) {
         if (!marker[i]) {
            for (int j = 2 * i; j <= N; j += i) {
               marker[j] = true;
            }
         }
      }

      // Berechnung der Primfaktorzerlegung
      System.out.print("Die Primfaktorzerlegung von " + N + " lautet: ");
      for (int i = 2; i < marker.length; i++) {
            if (marker[i]) continue;
            while ((N % i) == 0) {
               N /= i;
               System.out.print((N >= 2) ? i + " * " : i);
            }
      }
      System.out.println("");
   }
}
