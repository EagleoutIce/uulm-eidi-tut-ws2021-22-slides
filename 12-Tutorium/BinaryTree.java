public class BinaryTree {
  private BiNode root;

  public BinaryTree() {
    this.root = null;
  }

  public BinaryTree(int... elements) {
    this.root = null;

    for (int element: elements) {
      this.insert(element);
    }
  }

  public void insert(int element) {
    this.root = insert(this.root, element);
  }

  public static BiNode insert(BiNode current, int element) {
    if(current == null) { // Leaf
      return new BiNode(element);
    } else if (element < current.value) { // left
      current.left = insert(current.left, element);
    } else if (element > current.value) { // right
      current.right = insert(current.right, element);
    }
    return current; // already present
  }

  public int nodes() {
    return nodes(this.root);
  }

  public static int nodes(BiNode current) {
    if(current == null) {
      return 0;
    } else {
      return 1 + nodes(current.left) + nodes(current.right);
    }
  }

  public boolean isElement(int value) {
    return isElement(this.root, value);
  }

  public static boolean isElement(BiNode current, int value) {
    if(current == null) {
      return false;
    } else if (current.value == value) {
      return true;
    } else if(value < current.value) { // left
      return isElement(current.left, value);
    } else {// right
      return isElement(current.right, value);
    }
  }


  /** Zur Zusatzaufgabe *******************************************************/
  private int[] traverse(Memory memory) {
    if (memory == null) throw new NullPointerException();
    if (this.root == null) return new int[]{};
    int[] arr = new int[this.nodes()];
    memory.write(this.root);

    int i = 0;

    while(!memory.isEmpty()) {
      BiNode current = memory.read();
      arr[i++] = current.value;
      if (current.right != null) {
        memory.write(current.right);
      }
      if (current.left != null) {
        memory.write(current.left);
      }
    }

    return arr;
  }

  public int[] traverseQ() {
    return this.traverse(new MemoryQueue(this.nodes()));
  }

  public int[] traverseS() {
    return this.traverse(new MemoryStack(this.nodes()));
  }
}
