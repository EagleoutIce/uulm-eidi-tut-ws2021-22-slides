public class Horner {
  public static int convert(int base, int... digits) throws IllegalArgumentException {
    if (base < 2)
      throw new IllegalArgumentException("Basis muss groesser gleich 2 sein. Gegeben: " + base);
    if (digits.length <= 0) // oder '0' nach Definition
      throw new IllegalArgumentException("Keine Ziffern gegeben.");
    validateDigits(base, digits);
    return convert(digits, digits.length - 1, base);
  }

  private static void validateDigits(int base, int[] digits) {
    for (int digit : digits) {
      if (!(0 <= digit && digit < base))
        throw IllegalArgumentException("Ziffer " + digit + " nicht zwischen 0 und " + base);
    }
  }

  private static int convert(int[] digits, int index, int base) {
    return index < 0 ? 0 : convert(digits, index - 1, base) * base + digits[index];
  }

  public static void main(String... args) {
    System.out.println(convert(2, 1, 0, 1, 0));
    try {
      System.out.println(convert(2));
    } catch (IllegalArgumentException e) {
      System.err.println("Fehler: " + e.getMessage());
    }

    try {
      System.out.println(convert(1, 1, 0));
    } catch (IllegalArgumentException e) {
      System.err.println("Fehler: " + e.getMessage());
    }
  }
}
