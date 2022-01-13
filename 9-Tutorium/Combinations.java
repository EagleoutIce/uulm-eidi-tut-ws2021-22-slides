public class Combinations {
   public static void printArray(int[] combination, int i) {
       if(i < combination.length) {
           System.out.print(combination[i] + " ");
           printArray(combination, i + 1);
       } else {
           System.out.println();
       }
   }

   private static void helper(int[] array, int[] combination, int start, int index, int n) {
       if (index != n) {
           for (int i = start; i < array.length && array.length - i >= n - index; i++) {
               combination[index] = array[i];
               helper(array, combination, i + 1, index + 1, n);
           }
       } else {
           printArray(combination, 0);
       }
   }

   public static void printCombinations(int[] array, int n) {
       int[] combination = new int[n];
       helper(array, combination, 0, 0, n);
   }

   public static void main (String[] args) {
       int[] array = {1, 2, 3, 4, 5};
       int n = 3;
       System.out.print("Die Kombinationen ohne Wiederholung aus [");
       for(int i = 0; i < array.length -1; i++)
           System.out.print(array[i] + ",");
       System.out.println(array[array.length-1] + "] mit n=" + n + " sind:");

       printCombinations(array,  n);
   }
}
