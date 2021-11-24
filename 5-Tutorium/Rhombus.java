public class Rhombus {
   public static void main(String[] args) {
       int N = 0;
       if(args.length == 1) {
           N = Integer.parseInt(args[0]);
       } else {
           System.exit(1);
       }

       // Oberes Dreieck
       for(int i = 1; i <= N; i++) {
           for(int j = 1; j <= N-i; j++) {
               System.out.print(" ");
           }

           for(int j = 1; j <= i; j++) {
               if((j == 1) || (j == i))
                   System.out.print("* ");
               else
                   System.out.print("  ");
           }
           System.out.println("");
       }

       // Unteres Dreieck
       for(int i = N; i > 1; i--) {
           for(int j = i-1; j < N; j++) {
               System.out.print(" ");
           }
           for(int j = i; j >= 2; j--) {
               if((j == 2) || (j == i))
                   System.out.print("* ");
               else
                   System.out.print("  ");
           }
           System.out.println("");
       }
   }
}
