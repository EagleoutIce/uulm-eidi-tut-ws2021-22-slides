class SwitchCaseControlled {
   public static void main(String[] args) {
      int x = 0;
      switch(args.length) {
         case 1: x = Integer.parseInt(args[0]);
            break;
         default: System.exit(1);
            return;
      }
      switch (x) {
         case 1:
            System.out.println("A");
            break;
         case 2:
            System.out.println("B");
            break;
         case 3:
            System.out.println("C");
            break;
         default:
            System.out.println("D");
      }
   }
}