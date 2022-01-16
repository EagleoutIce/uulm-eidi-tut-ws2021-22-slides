public class CombinationsRepetition {
    public static void printArray(int[] combination, int i) {
        if (i < combination.length) {
            System.out.print(combination[i] + " ");
            printArray(combination, i + 1);
        } else {
            System.out.println();
        }
    }

    private static void helper(int[] array, int n, int[] combination, int index) {
        if (index == n) {
            printArray(combination, 0);
        } else {
            for (int i = 0; i < array.length; i++) {
                combination[index] = array[i];
                helper(array, n, combination, index + 1);
            }
        }
    }

    public static void printCombinations(int[] array, int n) {
        if (n <= 0 || n > array.length)
            return; // Nicht notwendig :)
        int[] combination = new int[n];
        helper(array, n, combination, 0);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        int n = 3;
        System.out.print("Die Kombinationen mit Wiederholung aus [");
        for (int i = 0; i < array.length - 1; i++)
            System.out.print(array[i] + ",");
        System.out.println(array[array.length - 1] + "] mit n=" + n + " sind:");

        printCombinations(array, n);
    }
}
