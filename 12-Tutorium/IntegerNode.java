public class IntegerNode {
    private int value;
    private IntegerNode left;
    private IntegerNode right;

    public void setRightChild(IntegerNode right) {
        this.right = right;
    }

    public void setLeftChild(IntegerNode left) {
        this.left = left;
    }

    public IntegerNode getRightChild() {
        return this.right;
    }

    public IntegerNode getLeftChild() {
        return this.left;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public IntegerNode(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
