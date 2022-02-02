public class StringNode {
    private String item;
    private StringNode left;
    private StringNode right;

    public void setRightChild(StringNode right) {
        this.right = right;
    }

    public void setLeftChild(StringNode left) {
        this.left = left;
    }

    public StringNode getRightChild() {
        return this.right;
    }

    public StringNode getLeftChild() {
        return this.left;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public StringNode(String value) {
        this.item = value;
        this.right = null;
        this.left = null;
    }
}
