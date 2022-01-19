import java.util.Arrays;

public class BinarySearch {

   private static int binarySearch(int[] array, int left, int right, int element) {
      if (right < left) // If this is the case, the element is not present
         return -1;

      // compute the middle index of the current chunk
      int middle = left + (right - left) / 2;
      // check the element at the middle index because the array's length could be odd
      if (array[middle] == element)
         return middle;

      // In case the element is smaller than the array's middle element, continue with
      // the left chunk
      if (array[middle] > element)
         return binarySearch(array, left, middle - 1, element);
      // Otherwise, continue with the right chunk
      else
         return binarySearch(array, middle + 1, right, element);
   }

   public static int find(int[] array, int element) {
      int index = binarySearch(array, 0, array.length - 1, element);

      if (index == -1)
         return -1;

      return findLower(array, element, index, 1);
   }

   private static int findLower(int[] array, int element, int index, int i) {
      if (i > index) // ! (i <= index)
         return 0;
      if (array[index - i] != element) // if in for
         return index - i + 1;
      return findLower(array, element, index, i + 1);
   }

   public static void printArray(int[] array) {
      System.out.print("[");
      for (int i = 0; i < array.length - 1; i++)
         System.out.print(+array[i] + ", ");
      System.out.println(array[array.length - 1] + "]");
   }

   public static void main(String[] args) {
      int length = (int) (Math.random() * 10 + 11);
      int[] numbers = new int[length];

      for (int i = 0; i < length; i++)
         numbers[i] = (int) (Math.random() * 100 + 1);

      Arrays.sort(numbers);
      printArray(numbers);

      int number = (int) (Math.random() * 10 + 11);
      int index = find(numbers, number);
      if (index >= 0)
         System.out.println("Die Zahl " + number + " ist an der Position " + index + " im Array vorhanden.");
      else
         System.out.println("Die Zahl " + number + " ist nicht im Array vorhanden");
   }
}
