public class Binom {
    public static int binomial(int n, int k) throws IllegalArgumentException {
      // Undefiniert für k < 0 oder k > n.
      if (!(0 <= k && k <= n))
        throw new IllegalArgumentException(
          "Ungültige Argumente {n: " + n + ", k: " + k + "}"
        );

      // Basisfall
      if (n == k || k == 0)
        return 1;

      // Rekursionsfall
      return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    public static void main(String... args) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j <= i; j++) {
          System.out.print(binomial(i, j) + " ");
        }
        System.out.println();
      }
    }
  }
