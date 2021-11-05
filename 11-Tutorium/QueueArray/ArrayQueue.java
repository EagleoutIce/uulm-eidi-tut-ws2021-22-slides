public class ArrayQueue {
  private final int[] buffer;
  private int first;
  private int length;

  public ArrayQueue(int bufferSize) throws IllegalArgumentException {
    if (!(0 < bufferSize && bufferSize <= Integer.MAX_VALUE))
      throw new IllegalArgumentException("Puffergröße " + bufferSize + " nicht zwischen 0 und " + Integer.MAX_VALUE);
    buffer = new int[bufferSize];
    first = 0;
    length = 0;
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public void enqueue(int n) throws IllegalStateException {
    if (this.length >= this.buffer.length)
      throw new IllegalStateException("Queue voll");
    /*
     * Die nächste Stelle, an die ein Wert geschrieben werden kann befindet sich
     * immer 'this.length' entfernt von 'this.first'. Da diese Position potenziell
     * über das Arrayende hinausgeht, nutzen wir den Modulooperator '%' für einen
     * "Wrap Around", d.h. wir betrachten Stellen die über das Arrayende
     * hinausgehen, als vom Arrayanfang beginnend.
     */
    buffer[(this.first + this.length) % this.buffer.length] = n;
    this.length++;
  }

  public int dequeue() throws IllegalStateException {
    if (this.length <= 0)
      throw new IllegalStateException("Queue leer");
    this.length--;
    int oldFirst = this.first;
    this.first = (this.first + 1) % this.buffer.length;
    return this.buffer[oldFirst];
  }
}
