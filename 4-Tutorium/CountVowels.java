public class CountVowels {
   public static void main(String[] args) {
      String input = null;
      if (args.length == 1) {
         input = args[0];
      } else {
         System.exit(1);
      }

      int a = 0, e = 0, i = 0, o = 0, u = 0;

      for (int j = 0; j < input.length(); j++) {
         switch (input.toLowerCase().charAt(j)) {
         case 'a':
            a++;
            break;
         case 'e':
            e++;
            break;
         case 'i':
            i++;
            break;
         case 'o':
            o++;
            break;
         case 'u':
            u++;
            break;
         }
      }

      System.out.println("a: " + a);
      System.out.println("e: " + e);
      System.out.println("i: " + i);
      System.out.println("o: " + o);
      System.out.println("u: " + u);
   }
}
