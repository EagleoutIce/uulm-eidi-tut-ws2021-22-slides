import java.util.Arrays;

public class Vector {

    private final double[] values;
    private final double magnitude;

    public double getMagnitude() {
        return magnitude;
    }

    public int getDimension() {
        return values.length;
    }

    @Override
    public String toString() {
        return "{ magnitude: " + magnitude + ", values: " + Arrays.toString(values) + " }";
    }

    // expects: valid vector
    private Vector(double[] values) {
        this.values = values; // to be completely sure: another copy
        this.magnitude = calculateMagnitude(values);
    }

    public static Vector create(double... values) {
        if(values.length <= 0)
            return null;
        return new Vector(values);
    }

    private static double calculateMagnitude(double[] values) {
        double sumOfSquares = 0;
        for (double value : values) {
            sumOfSquares += Math.pow(value, 2);
        }
        return Math.sqrt(sumOfSquares);
    }


    public double[] getValues() {
        return copyArray(this.values);
    }

    // Or system array copy
    private double[] copyArray(double[] arr) {
        double[] copy = new double[arr.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public Vector normalize() {
        double[] normalizedValues = new double[this.values.length];
        for (int i = 0; i < normalizedValues.length; i++) {
            normalizedValues[i] = this.values[i] / this.magnitude;
        }
        return Vector.create(normalizedValues);
    }

    public static void main(String... args) {
        Vector a = Vector.create(0, 2, 0, 0, 0);
        Vector b = Vector.create(13, 2.5, 3.2);
        System.out.println(a); // Ausgabe von toString()
        System.out.println(b);

        System.out.println(a.normalize());
        System.out.println(Vector.create()); // null
        double[] v = a.getValues();
        v[0] = 3.0;
        System.out.println(Arrays.toString(v));
        System.out.println(a);
    }


}
