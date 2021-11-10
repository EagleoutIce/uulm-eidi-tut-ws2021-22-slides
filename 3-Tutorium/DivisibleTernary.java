public class DivisibleTernary {
   public static void main(String[] args) {
       int x = 0 ;
       if(args.length == 1) {
           x = Integer.parseInt(args[0]);
       } else {
           System.exit(1);
       }

       String output = (x % 2) == 0 ? " ist durch 2 teilbar"
                           : (x % 3) == 0 ? " ist durch 3 teilbar"
                           : " ist weder durch 2 noch 3 teilbar";
       System.out.println(x + output);
   }
}
