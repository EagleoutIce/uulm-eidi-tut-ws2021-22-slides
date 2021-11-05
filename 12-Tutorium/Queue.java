import java.util.Arrays;

public class Queue {
  private final BiNode[] memory;
  private int length;
  private int first;

  public Queue(int size) {
    if (size < 0)
      throw new IllegalArgumentException("Negative Speichergröße");

    this.memory = new BiNode[size];
    this.length = 0;
    this.first = 0;
  }

  public void write(BiNode element) throws IllegalStateException {
    if (this.length >= this.memory.length) {
      throw new IllegalStateException("Queue voll");
    }

    this.memory[(this.first + this.length) % this.memory.length] = element;
    this.length++;
  }

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

  public boolean isEmpty() {
    return this.length <= 0;
  }

  public String toString() {
    return "{"
      + "first" + ": " + this.first + ", "
      + "length" + ": " + this.length + ", "
      + "memory" + ": " + Arrays.toString(this.memory)
      + "}";
  }
}
