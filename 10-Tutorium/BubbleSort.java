public class BubbleSort {
   // recursive helper method
   private static void move(int[] array, int i, int n) {
       if (i < n - 1) {
           if (array[i] > array[i + 1])
               swap(array, i, i + 1);

           move(array, ++i, n);
       }
   }

   private static void swap(int[] array, int i, int j) {
       int tmp = array[i];
       array[i] = array[j];
       array[j] = tmp;
   }

   public static void bubbleSort(int[] array, int n) {
       if (n > 1) {
           move(array, 0, n);
           printArray(array);
           bubbleSort(array, n - 1);
       }
   }

   public static void printArray(int[] array) {
       System.out.print("[");
       for (int i = 0; i < array.length - 1; i++)
           System.out.print(+array[i] + ", ");
       System.out.println(array[array.length - 1] + "]");
   }

   public static void bubbleSort(int[] arr) {
       for (int i = arr.length; i > 1; i--) {
           for (int j = 0; j < i - 1; j++) {
               if (arr[j] > arr[j + 1]) { // Vertausche
                   int tmp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = tmp;
               }
           }
       }
   }

   public static void main(String[] args) {
       int length = (int) (Math.random() * 10 + 11);
       int[] array = new int[length];

       for (int i = 0; i < length; i++)
           array[i] = (int) (Math.random() * 99 + 1);

       System.out.println("Unsortiertes Array: ");
       printArray(array);

       System.out.println("\nSortieren:");
       bubbleSort(array, length);
       System.out.println("\nSortiertes Array: ");
       printArray(array);
   }
}
