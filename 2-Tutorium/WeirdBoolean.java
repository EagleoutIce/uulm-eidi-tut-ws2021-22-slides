class WeirdBoolean {
   public static void main(String[] args) {
       int a = 42;
       int b = 21;
       boolean c = true;
       boolean d = false;

       if((22 >= b) && (a > b)) {
           if((c || d) && !(c && d)) {
               if(((a - b) == 21) && !c) {
                   if((a == 2*b) && (!c || !d)) {
                       System.out.println("A");
                   }
               } else {
                   System.out.println("B");
               }
           } else {
               System.out.println("C");
           }
       } else {
           System.out.println("D");
       }
   }
}
