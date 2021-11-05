import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        int base = getBaseFromArgs(args);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();
            if (input.isEmpty())
                continue;
            int[] digits = stringToIntArray(input, base);
            if (digits == null) {
                System.err.println(input + " ist keine Zahl zur Basis " + base);
            } else {
                int number = intArrayToInt(digits, base);
                System.out.println(number);
            }
        }
        scanner.close();
    }

    private static int getBaseFromArgs(String[] args) {
        assertOnlyOneArgument(args);
        final int base = Integer.parseInt(args[0]);
        if (base < 2 || base > 36) {
            System.err.println("Geben Sie bitte eine Basis zwischen 2 und 36 an. Gegeben: " + base);
            System.exit(2);
        }
        return base;
    }

    private static void assertOnlyOneArgument(String[] args) {
        if (args.length != 1) {
            System.err.println("Es wurde 1 Kommandozeilenargument erwartet. Gegeben: " + args.length);
            System.exit(1);
        }
    }

    public static int[] stringToIntArray(String numberString, int base) {
        int begin = 0; // Start der eigentlichen Zahl im String
        while (numberString.length() > begin && numberString.charAt(begin) == ' ')
            begin += 1;
        if (begin >= numberString.length())
            return null;

        int[] digits = new int[numberString.length() - begin];
        for (int i = begin; i < numberString.length(); i++) {
            int digit;
            // ändert nichts an 0-9 aber an Buchstaben a-z
            final char c = Character.toUpperCase(numberString.charAt(i));
            if ('0' <= c && c <= '9') { // ist Zahl
                digit = c - '0';
            } else if ('A' <= c && c <= 'Z') {
                // c - 'A' => 0 für A, 1 für B
                // wir addieren 10 für A = 10
                digit = c - 'A' + 10;
            } else {
                return null;
            }

            // ist die Ziffer für die Basis überhaupt gültig?
            if (digit >= base || digit < 0)
                return null;
            digits[i - begin] = digit;
        }
        return digits;
    }

    public static int intArrayToInt(int[] digits, int base) {
        int sum = digits[0];
        for (int i = 1; i < digits.length; i++) {
            sum = sum * base + digits[i];
        }
        return sum;
    }

}