public class NestedRhombus {
   public static void main(String[] args) {
       int N = 0;
       if(args.length == 1) {
           N = Integer.parseInt(args[0]);
       } else {
           System.exit(1);
       }

       // Oberes Dreieck
       for(int i = 1; i <= N; i++) {
           for(int j = 1; j <= N-i; j++)
               System.out.print(" ");

           if(i % 2 == 1) {
               for (int j = 1; j <= i; j++) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }
           }
           else {
               // Linke Hälfte
               for (int j = 1; j <= i / 2; j++) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }
               // Rechte Hälfte
               for (int j = i/2; j >= 1; j--) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }
           }
           System.out.println("");
       }

       // Unteres Dreieck
       for(int i = N-1; i >= 1; i--) {
           for(int j = i; j < N; j++) System.out.print(" ");

           if(i % 2 == 1) {
               for (int j = 1; j <= i; j++) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }
           }
           else {
               // Linke Hälfte
               for (int j = 1; j <= i / 2; j++) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }

               // Rechte Hälfte
               for (int j = i/2; j >= 1; j--) {
                   if (j % 2 == 1) System.out.print("* ");
                   else System.out.print("  ");
               }
           }
           System.out.println("");
       }
   }
}
