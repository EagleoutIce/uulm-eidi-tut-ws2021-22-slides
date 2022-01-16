public class CombinationsStringShort {

   public static void printCombinations(int[] array, int n) {
      if (n <= 0 || n > array.length)
         return; // Nicht notwendig :)
      helper(array, n, 0, "");
   }

   private static void helper(int[] array, int n, int index, String prefix) {
      if (index == array.length)
         return;

      if (n == 1)
         System.out.println(prefix + array[index]);
      else
         helper(array, n - 1, index + 1, prefix + array[index] + " ");

      helper(array, n, index + 1, prefix);
   }

   public static void main(String[] args) {
      int[] array = { 1, 2, 3, 4, 5 };
      int n = 1;
      System.out.print("Die Kombinationen ohne Wiederholung aus [");
      for (int i = 0; i < array.length - 1; i++)
         System.out.print(array[i] + ",");
      System.out.println(array[array.length - 1] + "] mit n=" + n + " sind:");

      printCombinations(array, n);
   }
}
