import java.util.Random;

public class IntRandom implements Readable {
  private Random rng;
  private int max;

  public IntRandom(int max) {
    this.rng = new Random();
    this.max = max;
  }

  public boolean canRead() {
    return true;
  }

  public int read() {
    return rng.nextInt(this.max + 1);
  }
}
