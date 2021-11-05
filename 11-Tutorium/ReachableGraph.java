public class ReachableGraph {
  public static boolean[] reachable(int[][] adjacencyList, int source) {
    ArrayQueue queue = new ArrayQueue(adjacencyList.length);

    boolean[] reached = new boolean[adjacencyList.length];
    queue.enqueue(source);
    while (!queue.isEmpty()) {
      int current = queue.dequeue();
      for (int next : adjacencyList[current]) {
        if (!reached[next]) {
          reached[next] = true;
          queue.enqueue(next);
        }
      }
    }
    return reached;
  }
}