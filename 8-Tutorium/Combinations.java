public class Combinations {
    public static void combinations(int length, char... symbols) {
      combinations(length, symbols, "");
    }

    private static void combinations(int length, char[] symbols, String acc) {
      if (acc.length() >= length) {
        System.out.println(acc);
        return;
      }

      for (char symbol: symbols) {
          combinations(length, symbols, acc + symbol);
      }
    }

    public static void main(String... args) {
      combinations(3, '0', '1');
    }
  }
