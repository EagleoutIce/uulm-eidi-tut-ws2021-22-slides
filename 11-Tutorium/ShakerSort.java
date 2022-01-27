public class ShakerSort {

   private static boolean moveUp(int[] array, int index, int end, boolean swapped) {
       if (index < end) {
           if (array[index] < array[index - 1]) {
               swap(array, index, index - 1);
               swapped = true;
           }
           return moveUp(array, ++index, end, swapped);
       }
       return swapped;
   }

   private static boolean moveDown(int[] array, int index, int end, boolean swapped) {
       if (index > end) {
           if (array[index] < array[index -1]) {
               swap(array, index, index - 1);
               swapped = true;
           }
           return moveDown(array, --index, end, swapped);
       }
       return swapped;
   }

   private static void swap(int[] array, int i, int j) {
       int tmp = array[i];
       array[i] = array[j];
       array[j] = tmp;
   }

   public static void shakerSort(int[] array, int n) {
       int offset = array.length - n;
       if (n > array.length / 2) {
           if(!moveUp(array, offset + 1, n, false)) {
               System.out.println("Fertig, da keine Elemente mehr getauscht wurden!");
               return;
           }
           if(!moveDown(array, n-1, offset, false)) {
               System.out.println("Fertig, da keine Elemente mehr getauscht wurden!");
               return;
           }
           printArray(array);
           shakerSort(array, n - 1);
       }
   }

   public static void printArray(int[] array) {
       System.out.print("[");

       for (int i = 0; i < array.length - 1; i++)
           System.out.print(+array[i] + ", ");
       System.out.println(array[array.length - 1] + "]");
   }

   public static void main(String[] args) {
       int length = (int) (Math.random() * 10 + 11);
       int[] array = new int[length];

       for (int i = 0; i < length; i++)
           array[i] = (int) (Math.random() * 99 + 1);

       System.out.println("Unsortiertes Array: ");
       printArray(array);
       System.out.println("\nSortieren:");

       shakerSort(array, length);

       System.out.println("\nSortiertes Array: ");
       printArray(array);
   }
}
