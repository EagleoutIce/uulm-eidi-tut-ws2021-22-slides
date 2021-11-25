public class NestedRhombusElegant {

    public static void main(String[] args) {
        if (args.length != 1) System.exit(1);
        int N = Integer.parseInt(args[0]) - 1;

        for (int y = -N; y <= N; y++) {
            for (int x = -N; x <= N; x++) {
                if (Math.abs(y) + Math.abs(x) <= N && (Math.abs(y) + Math.abs(x)) % 4 == N % 4)
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
