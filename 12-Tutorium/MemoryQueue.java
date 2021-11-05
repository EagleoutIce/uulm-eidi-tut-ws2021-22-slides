public class MemoryQueue extends Memory {
  private int first;

  public MemoryQueue(int size) {
    super(size);
    this.first = 0;
  }

  @Override
  public void write(BiNode x) throws IllegalStateException {
    if (this.length >= this.memory.length) {
      throw new IllegalStateException("Queue voll");
    }
    this.memory[(this.first + this.length) % this.memory.length] = element;
    this.length++;
  }

  @Override
  public BiNode read() throws IllegalStateException {
    if (this.length <= 0) {
      throw new IllegalStateException("Queue leer");
    }
    BiNode toReturn = this.memory[this.first];
    this.first++;
    this.first %= this.memory.length;
    this.length--;
    return toReturn;
  }

  public BiNode peek() throws IllegalStateException {
    if (this.length <= 0) {
      throw new IllegalStateException("Queue leer");
    }
    return this.memory[this.first];
  }

  public String toString() {
    return "{" + "first" + ": " + this.first + ", " + "length" + ": " + this.length + ", " + "memory" + ": "
        + Arrays.toString(this.memory) + "}";
  }

}
