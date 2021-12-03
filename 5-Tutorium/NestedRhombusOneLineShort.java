import java.util.Map;
import java.util.stream.IntStream;

public class NestedRhombusOneLineShort {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]) - 1;
      // for y from 0..(2N)^2
      IntStream.rangeClosed(0, 4 * N * (N + 1) + 1).boxed()
      .map(s -> Map.entry(Math.floorMod(s, 2*N + 1) - N, s / (2*N + 1) - N))
      .filter(s -> Math.abs(s.getValue()) + Math.abs(s.getKey()) <= N
      && (Math.abs(s.getValue()) + Math.abs(s.getKey())) % 4 == N % 4)
      .forEachOrdered(s ->
         System.out.printf("\033[%d;%dH*", s.getValue() + N+1, s.getKey()+ N+1)
      );
  }
}
