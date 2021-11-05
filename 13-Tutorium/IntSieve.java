public class IntSieve extends IntFilterQueue {
  private Set known;

  public IntSieve(int bufferSize) {
    super(bufferSize);
    this.known = new Set();
  }

  public boolean predicate(int v) {
    if (this.known.isElement(v))
      return false;
    this.known.write(v);
    return true;
  }
}
