import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NestedRhombusOneLine {
    public static void main(String[] args) {
        // Map::Entry Key = Y, Value = X
        System.out.println( // we want to print the result
            args.length != 1 ? // argument guard
            "invalid argument" :
            IntStream.rangeClosed(-Integer.parseInt(args[0]) + 1, Integer.parseInt(args[0]) - 1) // for y from -N..N
            .boxed() // we could use a sorted skip and limit combination to avoid nested boxing
            // [-N [-N..N] .. N [-N..N]]
            .map(s -> Map.entry(s, IntStream.rangeClosed(-Integer.parseInt(args[0]) + 1, Integer.parseInt(args[0]) - 1).boxed()))
            .map(s -> s.getValue() // x = [-N..N]
                .map(x -> // for each y = s.key() and x = [-N..N]
                    Math.abs(s.getKey()) + Math.abs(x) <= (Integer.parseInt(args[0]) - 1)
                    && (Math.abs(s.getKey()) + Math.abs(x)) % 4 == (Integer.parseInt(args[0]) - 1) % 4
                    ? "*" : " " // this is the normal guard
                ).reduce("", (a, b) -> a + b) // join them to one string starting from ""
                // we could use both for both
            )
            .collect(Collectors.joining("\n")) // join them with newline
        );
    }
}
