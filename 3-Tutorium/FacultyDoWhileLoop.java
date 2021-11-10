class FacultyDoWhileLoop {
   public static void main(String[] args) {
      if (args.length != 1)
         System.exit(1);
      int n = Integer.parseInt(args[0]);

      int faculty = 1;
      int i = 0;
      do {
         if (i != 0) {
            faculty *= i;
         }
         System.out.println(i + "! = " + faculty);
         i++;
      } while (i <= n);
   }
}
