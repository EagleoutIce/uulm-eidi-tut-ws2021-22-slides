public class BinarySearch {

    public static void main(String[] args) {
        char[] arr = "Ich bin ein Toller String".toCharArray();
        System.out.println(binarySearch(arr, 'e'));
        arr = "Ich bin ein Toller String".toCharArray();
        System.out.println(binarySearch(arr, 'x'));
    }

    public static int binarySearch(char[] arr, char key) {
        // Wir arbeiten mit Zahlen
        int[] intArray = toLowerCaseIntArray(arr);
        bubbleSort(intArray);
        return binarySearchOnSortedArray(intArray, key);
    }

    private static int binarySearchOnSortedArray(int[] intArray, char key) {
        int min = 0;
        int max = intArray.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (intArray[middle] == key)
                return middle;
            else if (intArray[middle] > key)
                max = middle - 1;
            else
                min = middle + 1;
        }
        throw new IllegalArgumentException("Wert " + key + " ist im Array nicht vorhanden.");
    }

    private static int[] toLowerCaseIntArray(char[] arr) {
        int[] intArray = new int[arr.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Character.toLowerCase(arr[i]);
        }
        return intArray;
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        for (int i = 0; swapped && i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int j2) {
        int temp = arr[j2];
        arr[j2] = arr[j];
        arr[j] = temp;
    }

}
