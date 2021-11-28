public class DotProduct {
    public static void main(String[] args) {
        int length = (int) (Math.random() * 8 + 3);

        int[] vector1 = new int[length];
        int[] vector2 = new int[length];

        for (int i = 0; i < length; i++) {
            vector1[i] = (int) (Math.random() * 11 - 5);
            vector2[i] = (int) (Math.random() * 11 - 5);
        }

        int d = 0;
        for (int i = 0; i < length; i++) {
            d += vector1[i] * vector2[i];
        }

        System.out.println("Vector1: " + vectorToString(vector1));
        System.out.println("Vector2: " + vectorToString(vector2));
        System.out.println("Das Skalarprodukt ist: " + d);
    }

    public static String vectorToString(int[] vector) {
        String result = "(";
        for (int i = 0; i < vector.length; i++) {
            if (i > 0)
                result += ", ";

            result += vector[i];
        }
        return result + ")";
    }
}
