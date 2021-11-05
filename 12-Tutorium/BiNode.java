public class BiNode {
  public final int value;
  public BiNode left;
  public BiNode right;

  public BiNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public BiNode(int value, BiNode left, BiNode right){
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public String toString() {
    return "{ value: " + this.value + " }";
  }
}
