class SwitchCaseControlledAlternate {
   public static void main(String[] args) {
      if (args.length != 1)
         System.exit(1);
      int x = Integer.parseInt(args[0]);
      switch (x) {
      case 0:
         System.out.println("D");
         break;
      case 1:
         System.out.println("A");
         break;
      case 2:
         System.out.println("B");
         break;
      default:
         System.out.println("C");
         break;
      }
   }
}