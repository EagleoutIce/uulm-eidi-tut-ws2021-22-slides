import java.util.NoSuchElementException;

public class BinaryTree {
    private IntegerNode root;

    public BinaryTree(int[] items) {
        this.root = buildTree(items, 0);
    }

    private static IntegerNode buildTree(int[] items, int index) {
        if (index >= items.length)
            return null;
        IntegerNode node = new IntegerNode(items[index]);
        node.setLeftChild(buildTree(items, 2 * index + 1)); // left
        node.setRightChild(buildTree(items, 2 * index + 2)); // right
        return node;
    }

    public void breadthFirstTraversal() {
        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            IntegerNode node = queue.dequeue();
            if(node == null) continue;

            queue.enqueue(node.getLeftChild());
            queue.enqueue(node.getRightChild());

            System.out.print(node.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        int[] elements = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        BinaryTree tree = new BinaryTree(elements);

        tree.breadthFirstTraversal();
    }
}
