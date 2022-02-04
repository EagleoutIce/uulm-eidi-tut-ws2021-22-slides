public class DrawTree {
    public static void draw(int[] array) {
        int height = (int) (Math.log(array.length) / Math.log(2));
        int width = (2 + 2) * (int) Math.pow(2, height);

        for (int i = 0; i <= height; i++) {
            drawNumbers(array, width, i);
            if (i < height)
                drawLines(array, width, i + 1);
        }
    }

    private static void drawNumbers(int[] array, int width, int currentHeight) {
        int levelSize = (int) Math.pow(2, currentHeight);
        int padding = width / levelSize;
        int leftPadding = width / (levelSize * 2) - 2;
        System.out.print(" ".repeat(leftPadding));
        for (int j = 0; j < levelSize; j++) { // "Breitendurchlauf"
            if (j > 0)
                System.out.print(" ".repeat(padding - 2));
            System.out.print(formatNumber(array, levelSize + j - 1));
        }
        System.out.println();
    }

    private static void drawLines(int[] array, int width, int currentHeight) {
        int levelSize = (int) Math.pow(2, currentHeight);
        int padding = width / levelSize;
        int leftPadding = width / (levelSize * 2) - 2;
        System.out.print(" ".repeat(leftPadding) + "+");
        for (int j = 0; j < levelSize; j++) {
            if (levelSize + j - 1 >= array.length) break;
            if (j > 0 && j % 2 == 0) // padding between
                System.out.print(" ".repeat(padding - 1) + "+");
            System.out.print("-".repeat((padding - 2) / 2) + "+");
        }
        System.out.println();
    }

    public static String formatNumber(int[] array, int i) {
        return i >= array.length ? "  " : String.format("%-2d", array[i]);
    }

    public static String formatNumberFancy(int[] array, int i) {
        if (i >= array.length)
            return " ".repeat(2);
        int number = array[i];
        int size = (int) Math.log10(number) + 1;
        return number + " ".repeat(Math.abs(2 - size));
    }

    private static void printArray(int[] array, int n) {
        System.out.print("[");
        for (int i = 0; i < n - 1; i++)
            System.out.print(+array[i] + ", ");
        System.out.println(array[n - 1] + "]");
    }

    public static void main(String[] args) {
        int length = (int) (Math.random() * 50 + 11);
        int[] array = new int[length];

        for (int i = 0; i < length; i++)
            array[i] = (int) (Math.random() * 99 + 1);

        System.out.print("Binary tree representation of: ");
        printArray(array, array.length);
        draw(array);
        System.out.println("\n\n");
    }
}
