public class Node {
    Node left = null;
    Node right = null;
    int val;

    public Node(int value) {
        this.val = value;
    }

    public int max() {
        int maxValue = this.val;
        if(left != null)
            maxValue = Math.max(maxValue, left.max());
        if(right != null)
            maxValue = Math.max(maxValue, right.max());
        return maxValue;
    }

}