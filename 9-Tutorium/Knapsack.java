public class Knapsack {
    public static int knapsack(int capacity, int[] values, int[] weights)
    throws IllegalArgumentException {
      if (capacity < 0) throw new IllegalArgumentException(
        "Negative Kapazität"
      );

      if (values.length != weights.length) throw new IllegalArgumentException(
        "Arraylängen stimmen nicht überein."
      );

      return knapsack(capacity, 0, values, weights);
    }

    private static int knapsack(
      int capacity,
      int index,
      int[] values,
      int[] weights
    ) {
      // i > n
      if (index >= values.length)
        return 0;

      // W < w_i
      if (capacity < weights[index])
        return knapsack(capacity, index+1, values, weights);

      int withItem = values[index]
        + knapsack(capacity - weights[index], index+1, values, weights);
      int withoutItem = knapsack(capacity, index+1, values, weights);

      // max(knapsack(W, i+1), v_i + knapsack(W-w_i, i+1))
      return Math.max(withItem, withoutItem);
    }

    public static void main(String... args) {
      int[] values = new int[]{55, 10, 47, 5, 4, 50, 6, 61, 85, 87};
      int[] weights = new int[]{95, 4, 60, 32, 23, 72, 80, 62, 65, 46};

      int r = knapsack(269, values, weights);

      System.out.println(r);
    }
  }
