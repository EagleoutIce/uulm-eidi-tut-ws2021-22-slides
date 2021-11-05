class Chunk {
  public static final int CHUNK_SIZE = 1024;

  public Integer[] hash;
  public Chunk next;

  public Chunk() {
    this.hash = new Integer[CHUNK_SIZE];
    this.next = null;
  }
}

public class Set implements Writable {
  public static final int MAX_TRIES = 10;

  private Chunk chunks;

  public Set() {
    this.chunks = new Chunk();
  }

  public boolean canWrite() {
    return true;
  }


  public void write(int v) {
    Integer value = new Integer(v);
    int hashValue = Math.abs(value.hashCode());
    Chunk current = this.chunks;

    while(true) {
      for (int i = 0; i < MAX_TRIES; i++) {
        int index = (hashValue + i) % Chunk.CHUNK_SIZE;
        if (current.hash[index] == null) {
          current.hash[index] = value;
          return;
        } else if (current.hash[index].equals(value)) {
          return;
        }
      }

      if (current.next == null) {
        current.next = new Chunk();
      }

      current = current.next;
    }
  }

  public boolean isElement(int v) {
    Integer value = new Integer(v);
    int hashValue = Math.abs(value.hashCode());
    for (Chunk current = this.chunks; current != null; current = current.next) {
      for (int i = 0; i < MAX_TRIES; i++) {
        int index = (hashValue + i) % Chunk.CHUNK_SIZE;
        if (current.hash[index] != null && current.hash[index].equals(value)) {
          return true;
        }
      }
    }
    return false;
  }
}
