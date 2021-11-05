public class ReversePolishNotation {
    public static void main(final String[] args) {
        int[] stack = new int[100];
        int pointer = -1;

        for (String arg : args) {
            if (arg.equals("add")) {
                pointer -= 1;
                stack[pointer] += stack[pointer + 1];
            } else if (arg.equals("mult")) {
                pointer -= 1;
                stack[pointer] *= stack[pointer + 1];
            } else { // Annahme: Zahl
                pointer += 1;
                stack[pointer] = Integer.parseInt(arg);
            }
        }

        System.out.println(stack[pointer]);
    }
}
