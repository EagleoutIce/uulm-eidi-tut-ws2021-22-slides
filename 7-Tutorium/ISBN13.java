/**
 * Klasse zur Repräsentation einer ISBN13 Nummer.
 *
 * @author Sascha Rechenberger
 * @version 1.0
 * @see https://de.wikipedia.org/wiki/Internationale_Standardbuchnummer#ISBN-13
 */
public class ISBN13 {
    private static final int LENGTH = 13;

    private static final String
      INVALID_ISBN_STRING = "Keine gültige ISBN-13",
      INVALID_LENGTH      = "Ungültige Länge (ungleich " + LENGTH + ")",
      INVALID_DIGIT       = "Ungültiges Zeichen (nicht in {'0'..'9'})",
      INVALID_CHECKSUM    = "Prüfsumme ungültig (nicht durch 10 teilbar)";

    private final int[] digits = new int[13];

    /**
     * Prüft die Prüfsumme der ISBN.
     *
     * Es wird auf prüfen der Zahl an Ziffern verzichtet, da
     * diese Methode nur von innerhalb eines Validen Objekts
     * ausgeführt werden kann.
     *
     * @param digits Ziffern der ISBN
     * @return {@code true}, wenn die ISBN-13 gültig ist; {@code false} andernfalls.
     * @since 1.0
     */
    private static boolean checksum(int... digits) {
      int sum = 0;
      boolean toggle = false;

      for (int digit: digits) {
        sum += (toggle ? 3 : 1) * digit;
        toggle = !toggle;
      }

      return sum % 10 == 0;
    }

    /**
     * Stringrepräsentation des ISBN ohne Bindestriche.
     *
     * @return String {@code "ISBN-13 XXXXXXXXXXXXX"}
     * @since 1.0
     */
    public String toString() {
      String sum = "ISBN-13 ";

      for(int digit: this.digits) {
        sum += digit;
      }

      return sum;
    }

    /**
     * Vergleicht zwei ISBNs Ziffernweise.
     *
     * @return {@code true}, wenn beide Nummern ziffernweise identisch sind, {@code false} anderfalls.
     * @throws NullPointerException, falls die Übergebene ISBN ein {@code null} ist.
     * @since 1.0
     */
    public boolean equals(ISBN13 other) throws NullPointerException {
      if (other == null) throw new NullPointerException();

      for (int i = 0; i < LENGTH; i++) {
        if (this.digits[i] != other.digits[i]) {
          return false;
        }
      }

      return true;
    }

    /**
     * Konstruktor.
     *
     * @param isbn String der ISBN-13, möglicherweise mit Bindestrichen.
     * @throws IllegalArgumentException Falls der übergebene String keine valide ISBN-13 darstellt.
     * @since 1.0
     */
    public ISBN13(String isbn) throws IllegalArgumentException {
      char[] digitChars = isbn.replaceAll("-", "").toCharArray();

      if (digitChars.length != LENGTH)
        throw new IllegalArgumentException(
          INVALID_ISBN_STRING + ": " + isbn + ": " + INVALID_LENGTH
        );

      for (int i = 0; i < digitChars.length; i++) {
        if(!Character.isDigit(digitChars[i]))
          throw new IllegalArgumentException(
            INVALID_ISBN_STRING + ": " + isbn + ": " + INVALID_DIGIT
          );
        this.digits[i] = digitChars[i] - '0';
      }

      if (!checksum(digits))
        throw new IllegalArgumentException(
          INVALID_ISBN_STRING + ": " + isbn + ": " + INVALID_CHECKSUM
        );
    }
  }
