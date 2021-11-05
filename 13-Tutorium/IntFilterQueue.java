public abstract class IntFilterQueue implements Readable, Writable {
  private final int[] buffer;

  private int first;
  private int length;

  protected abstract boolean predicate(int i);

  public IntFilterQueue(int bufferSize) {
    if (bufferSize < 0) {
      throw new IllegalStateException("Negative Puffergröße");
    }

    this.buffer = new int[bufferSize];
    this.first = 0;
    this.length = 0;
  }

  /****** Readable Methoden ****************************************/
  public boolean canRead() {
    return this.length > 0;
  }

  public int read() throws IllegalStateException {
    if (!this.canRead()) {
      throw new IllegalStateException("Queue leer");
    }
    int toReturn = this.buffer[this.first];
    this.first = (this.first + 1) % this.buffer.length;
    this.length--;
    return toReturn;
  }

  /****** Writable Methoden ****************************************/
  public boolean canWrite() {
    return this.length < this.buffer.length;
  }

  public void write(int i) {
    if (!this.canWrite()) {
      throw new IllegalStateException("Queue voll");
    }
    if (this.predicate(i)) {
      this.buffer[(this.first + this.length) % this.buffer.length] = i;
      this.length++;
    }
  }

}
