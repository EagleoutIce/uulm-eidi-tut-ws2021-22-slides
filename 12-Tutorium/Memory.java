abstract class Memory {
  protected final BiNode[] memory;
  protected int length;

  protected Memory(int size) {
    if(size < 0)
      throw new IllegalArgumentException("Negative Speichergröße");
    this.memory = new BiNode[size];
    this.length = 0;
  }

  public abstract void write(BiNode x) throws IllegalStateException;

  public abstract BiNode read() throws IllegalStateException;

  public abstract BiNode peek() throws IllegalStateException;

  public boolean isEmpty() {
    return this.length <= 0;
  }
}