public class CountVowelsExtreme {
    public static void main(String[] args) {
        String input = null;
        if (args.length == 1) {
            input = args[0];
        } else {
            System.exit(1);
        }

        char[] arr = input.toLowerCase().toCharArray();
        int[] counters = new int[26];

        for (int j = 0; j < arr.length; j++) {
            char c = arr[j];
            if ('a' <= c && c <= 'z')
                counters[c - 'a'] += 1;
        }

        for (char c : new char[] { 'a', 'e', 'i', 'o', 'u' }) {
            System.out.println(c + ": " + counters[c - 'a']);
        }
    }
}
