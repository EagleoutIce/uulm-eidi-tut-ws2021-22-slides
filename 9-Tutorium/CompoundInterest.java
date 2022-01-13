public class CompoundInterest {

   public static double compoundInterest(double capital, double interestRate, int years) {
       if(years == 0)
           return capital;
       else
           return compoundInterest(capital * (1 + interestRate), interestRate, --years);
   }


   public static void main(String[] args) {
       double capital = 1000;
       double interestRate = 0.05;
       int years = 10;

       double result = compoundInterest(capital, interestRate, years);
       System.out.println("Ein Startkapital von " + capital +"€"
               + " ergibt mit einem Zinssatz von " + interestRate*100 + "%"
               + " eine Summe von " + String.format("%.2f", result) + "€"
               + " nach " + years + " Jahren.");
   }
}
