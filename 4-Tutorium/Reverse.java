public class Reverse {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] b = reverse(a);
        reverseInPlace(a);
        System.out.println("i\ta\tb");
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "\t" + a[i] + "\t" + b[i]);
            assert a[i] == b[i]; // benötigt Java Assertions aktiv :D
        }
    }

    public static int[] reverse(int[] toReverse) {
        int[] newArr = new int[toReverse.length];
        for (int i = 0; i < toReverse.length; i++) {
            newArr[newArr.length - i - 1] = toReverse[i];
        }
        return newArr;
    }

    public static void reverseInPlace(int[] reverse) {
        for (int i = 0; i < reverse.length / 2; i++) {
            // swap i and length-i-1
            int tmp = reverse[i];
            reverse[i] = reverse[reverse.length - i - 1];
            reverse[reverse.length - i - 1] = tmp;
        }
    }

}