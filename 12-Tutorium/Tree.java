public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if(current == null) // leaf or empty
            return new Node(value);
        if(value < current.val) current.left = insert(current.left, value);
        else if (value > current.val) current.right = insert(current.right, value);
        // else: Wert bereits enthalten
        return current;
    }

    public int max() {
        assert root != null : "Maximum of empty tree is undefined";
        return root.max();
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5); tree.insert(3);
        tree.insert(2); tree.insert(4);
        tree.insert(7); tree.insert(6);
        tree.insert(9); tree.insert(8);
        tree.insert(12);
        System.out.println("Maximum is: " + tree.max());
    }

}