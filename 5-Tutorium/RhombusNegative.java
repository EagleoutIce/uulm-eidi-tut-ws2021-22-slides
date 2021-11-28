public class RhombusNegative {
   public static void main(String[] args) {
      int N = 0;
      if (args.length == 1) {
         N = Integer.parseInt(args[0]);
      } else {
         System.exit(1);
      }

      for (int i = N - 1; i > -N; i--) {
         for (int j = 1; j <= Math.abs(i); j++) {
            System.out.print(" ");
         }

         for (int j = 1; j <= N - Math.abs(i); j++) {
            if ((j == 1) || (j == N - Math.abs(i)))
               System.out.print("* ");
            else
               System.out.print("  ");
         }
         System.out.println("");
      }
   }
}
