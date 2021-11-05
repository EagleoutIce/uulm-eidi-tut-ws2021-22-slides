public class MemoryStack extends Memory {
  public MemoryStack(int size) {
    super(size);
  }

  @Override
  public void write(BiNode x) throws IllegalStateException {
    if (this.length >= this.memory.length)
      throw new IllegalStateException("Stack voll");

    this.memory[this.length++] = x;
  }

  @Override
  public BiNode read() throws IllegalStateException {
    if (this.length < 0)
      throw new IllegalStateException("Stack leer");
    return this.memory[--this.length];
  }

  @Override
  public BiNode peek() throws IllegalStateException {
    if (this.length < 0)
      throw new IllegalStateException("Stack leer");
    return this.memory[this.length - 1];
  }

  public String toString() {
    return "{" + "length" + ": " + this.length + ", " + "memory" + ": " + Arrays.toString(this.memory) + "}";
  }
}