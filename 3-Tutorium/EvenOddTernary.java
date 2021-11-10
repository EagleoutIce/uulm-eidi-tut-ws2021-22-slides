public class EvenOddTernary {
   public static void main(String[] args) {
       int x = 0;
       if(args.length == 1) {
           x = Integer.parseInt(args[0]);
       } else {
           System.exit(1);
       }

       System.out.println(x + ((x % 2) == 0 ? " ist gerade" : " ist ungerade"));
   }
}
