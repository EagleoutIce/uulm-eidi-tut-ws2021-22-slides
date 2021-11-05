public class IntRange implements Readable {
  public final int min;
  public final int max;

  private int current;

  public IntRange(int min, int max) {
    this.min = min;
    this.max = max;

    this.current = min;
  }

  public boolean canRead() {
    return this.current < this.max;
  }

  public int read() {
    if (!this.canRead())
      throw new IllegalStateException("Interval consumed");
    return current++;
  }
}
