import java.util.Arrays;

public class Stack {
  private int length;
  private final BiNode[] memory;

  public Stack(int size) {
    if (size < 0)
      throw new IllegalArgumentException("Negative Speichergröße");

    this.memory = new BiNode[size];
    this.length = 0;
  }

  public void write(BiNode x) throws IllegalStateException {
    if (this.length >= this.memory.length) {
      throw new IllegalStateException("Stack voll");
    }

    this.memory[this.length++] = x;
  }

  public BiNode read() throws IllegalStateException {
    if (this.length < 0) {
      throw new IllegalStateException("Stack leer");
    }

    return this.memory[--this.length];
  }

  public BiNode peek() throws IllegalStateException {
    if (this.length < 0) {
      throw new IllegalStateException("Stack leer");
    }

    return this.memory[this.length-1];
  }

  public boolean isEmpty() {
    return this.length <= 0;
  }

  public String toString() {
    return "{"
      + "length" + ": " + this.length + ", "
      + "memory" + ": " + Arrays.toString(this.memory)
      + "}";
  }
}
