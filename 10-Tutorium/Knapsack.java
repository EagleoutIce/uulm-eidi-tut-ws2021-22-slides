public class Knapsack {
    private static int helper(int W, int i, int[] weights, int[] values) {
        if (i == weights.length || W == 0)
            return 0;

        if (weights[i] > W)
            return helper(W, i + 1, weights, values);
        else
            return Math.max(helper(W, i + 1 , weights, values),
                            helper(W - weights[i], i + 1,  weights, values) + values[i]);
    }

    public static int knapsack(int W, int[] weights, int[] values) {
        if(weights.length != values.length)
            return -1;

        return helper(W, 0, weights, values);
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i=0; i < array.length-1; i++)
            System.out.print(array[i] + ", ");
        System.out.println(array[array.length-1] + "]");
    }

    public static void main(String args[]) {
        // Generate values for a random number of objects
        int length = (int) (Math.random() * 6 + 5);
        int[] values = new int[length];
        int[] weights = new int[length];

        int sumOfWeights = 0;
        // Generate random positive values and weights for the objects
        for(int i = 0; i < length; i++) {
            values[i] = (int) (Math.random() * 100 + 1);
            weights[i] = (int) (Math.random() * 100 + 1);
            sumOfWeights += weights[i];
        }

        System.out.print("Werte: ");
        printArray(values);

        System.out.print("Gewichte: ");
        printArray(weights);

        // Compute a reasonable target weight
        int W = 2 * sumOfWeights / length;
        System.out.println("Kapazität: " + W + "\n");

        // Execute the actual knapsack algorithm
        System.out.println("Maximaler Wert: " + knapsack(W, weights, values));
    }
}
