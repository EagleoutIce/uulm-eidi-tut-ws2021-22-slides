public class DrawTree {
    public static int drawNodes(int[] array, int arrayIndex, int arrayLength, int height, int depth) {
        int indentation = (int) (Math.pow(2, height - depth +1) - 2);
        int spacing = (int) (Math.pow(2, height - depth + 2) - 1);
        int numValues = (int) Math.pow(2, depth);

        for(int j = 0; j < numValues && arrayIndex < arrayLength; j++, arrayIndex++) {
            if(j == 0) {
                for (int k = 0; k < indentation; k++)
                    System.out.print(" ");
            }
            else {
                // Check whether the given number has one or two digits
                int offset = array[arrayIndex - 1] / 10 > 0 ? 1 : 0;
                for (int k = 0; k < spacing - offset; k++)
                    System.out.print(" ");
            }

            System.out.print(array[arrayIndex]);
        }
        System.out.println();
        return arrayIndex;
    }

    public static void drawLines(int arrayLength, int arrayIndex, int height, int depth) {
        int indentation = (int) (Math.pow(2, height - depth +1) - 2);
        int spacing = (int) (Math.pow(2, height - depth + 2) - 1);
        int numValues = (int) Math.pow(2, depth);

        for(int j = 0; j < numValues && arrayIndex <= arrayLength; j++, arrayIndex++) {
            if(j == 0) {
                for (int k = 0; k < indentation; k++)
                    System.out.print(" ");
            } else {
                if (j % 2 == 0) {
                    for (int k = 0; k < spacing; k++)
                        System.out.print(" ");
                } else {
                    for (int k = 0; k < spacing; k++) {
                        if (k == (spacing / 2)) {
                            System.out.print("+");
                            if (arrayIndex == arrayLength)
                                break;
                        } else {
                            System.out.print("-");
                        }
                    }
                }
            }

            if(arrayIndex != arrayLength)
                System.out.print("+");
        }
        System.out.println();
    }

    public static void draw(int[] array, int n) {
        int height = (int) (Math.log(n) / Math.log(2));
        int arrayIndex = 0;

        for(int i = 0; i <= height; i++) {
            arrayIndex = drawNodes(array, arrayIndex, n, height, i);
            if(i < height)
                drawLines(n, arrayIndex, height, i+1);
        }
    }

    private static void printArray(int[] array, int n) {
        System.out.print("[");
        for(int i = 0; i < n - 1; i++)
            System.out.print( + array[i] + ", ");
        System.out.println(array[n-1] + "]");
    }

    public static void main(String[] args) {
        int length = (int) (Math.random() * 10 + 11);
        int[] array = new int[length];

        for(int i = 0; i < length; i++)
            array[i] = (int) (Math.random() * 100 + 1);

        for(int i = 1; i <= array.length; i++) {
            System.out.print("Binary tree representation of: ");
            printArray(array, i);
            draw(array, i);
            System.out.println("\n\n");
        }
    }
}
