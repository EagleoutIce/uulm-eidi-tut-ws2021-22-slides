public class NestedRhombusElegant {

    public static void main(String[] args) {
        if (args.length != 1)
            System.exit(1);
        int N = Integer.parseInt(args[0]) - 1;

        for (int i = -N; i <= N; i++) {
            for (int j = -N; j <= N; j++) {
                if (Math.abs(i) + Math.abs(j) == N)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
