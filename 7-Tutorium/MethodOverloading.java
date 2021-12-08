public class MethodOverloading {

   public static int[] separateDigits(String number) {
      int numDigits = number.length();
      int[] digits = new int[numDigits];

      for (int i = 0; i < numDigits; i++) {
         digits[i] = Integer.parseInt(number.substring(i, i + 1));
         // Alternative:
         // digits[i] = number.charAt(i) - 48;
      }

      return digits;
   }

   public static int[] separateDigits(int number) {
      int numDigits = (int) (Math.log10(number) + 1);
      int[] digits = new int[numDigits];
      for (int i = numDigits - 1; i >= 0; i--) {
         digits[i] = number % 10;
         number /= 10;
      }
      return digits;
   }

   public static void main(String[] args) {
      int[] digits = separateDigits(123456);
      for (int d : digits)
         System.out.print(d + " ");
      System.out.println();

      digits = separateDigits("123456");
      for (int d : digits)
         System.out.print(d + " ");
      System.out.println();
   }
}
