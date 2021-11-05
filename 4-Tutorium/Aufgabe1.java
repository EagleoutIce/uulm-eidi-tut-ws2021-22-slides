public class Aufgabe1 {
    public static void main(String[] args) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        double sum = 0;

        if (args.length <= 0) {
            System.err.println("Keine Argumente übergeben. Ende.");
            System.exit(1);
            return; // Nicht notwendig
        }

        for (String arg : args) {
            double val = Double.parseDouble(arg);
            min = val < min ? val : min;
            max = val > max ? val : max;
            sum += val;
        }

        System.out.println("     Minimum: " + min);
        System.out.println("     Maximum: " + max);
        System.out.format( "Durchschnitt: %f\n", (sum / args.length));
    }
}
