public class ListQueue {
  private Node first;
  private Node last;

  public ListQueue() {
    this.first = null;
    this.last = null;
  }

  public boolean isEmpty() {
    return this.first == null && this.last == null;
  }

  public void enqueue(int i) {
    if (isEmpty()) {
      this.first = new Node(i, null);
      this.last = this.first;
    } else if (this.first != null && this.last != null) {
      this.last.next = new Node(i, null);
      this.last = this.last.next;
    } else {
      // Sollte nicht passieren
      throw new IllegalStateException("Inkonsistente Zeiger");
    }
  }

  public int dequeue() throws IllegalStateException {
    if (isEmpty())
      throw new IllegalStateException("Queue leer");
    int toReturn = this.first.value;
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.next;
    }
    return toReturn;
  }

  public static void main(String[] args) {
    ListQueue lq = new ListQueue();
    lq.enqueue(3);
    lq.dequeue();
    lq.enqueue(4);
    System.out.println(lq.first.value);
  }
}