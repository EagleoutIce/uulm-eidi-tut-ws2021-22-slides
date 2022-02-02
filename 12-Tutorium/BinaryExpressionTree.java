public class BinaryExpressionTree {
    private StringNode root;

    public BinaryExpressionTree(String[] items) {
        this.root = buildTree(items, 0);
    }

    private static StringNode buildTree(String[] items, int index) {
        if (index >= items.length)
            return null;
        StringNode node = new StringNode(items[index]);
        node.setLeftChild(buildTree(items, 2 * index + 1)); // left
        node.setRightChild(buildTree(items, 2 * index + 2)); // right
        return node;
    }

    // Post-Order Traversal
    public double traverse(StringNode node) {
        if (node == null)
            throw new IllegalStateException("Traversing empty");

        if (!node.isLeaf()) {
            double valueLeft = traverse(node.getLeftChild());
            double valueRight = traverse(node.getRightChild());

            // Get the Operator
            switch (node.getItem()) {
                case "+":
                    return valueLeft + valueRight;
                case "-":
                    return valueLeft - valueRight;
                case "*":
                    return valueLeft * valueRight;
                case "/":
                    return valueLeft / valueRight;
                default:
                    throw new IllegalArgumentException("Unknown Operator: " + node.getItem());
            }
        }
        return Double.parseDouble(node.getItem());
    }

    public double evaluate() {
        return traverse(root);
    }

    public static void main(String[] args) {
        String[] items = { "*", "+", "-", "2", "5", "4", "1" };
        BinaryExpressionTree tree = new BinaryExpressionTree(items);

        double result = tree.evaluate();
        System.out.println(result);
    }
}
