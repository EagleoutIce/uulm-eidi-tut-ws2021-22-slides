public class List {
    public final Node head;
    public final int length;

    public List(int... values) {
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        this.head = head;
        this.length = values.length;
    }

    private List(Node head, int length) {
        this.head = head;
        this.length = length;
    }

    public List() {
        this.head = null;
        this.length = 0;
    }

    public String toString() {
        if (head == null)
            return "[]";

        String toReturn = "[" + head.value;
        for (Node curr = head.tail; curr != null; curr = curr.tail) {
            toReturn += (", " + curr.value);
        }
        toReturn += "]";
        return toReturn;
    }

    public int getByIndex(int index) throws IndexOutOfBoundsException {
        Node n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.tail;
            if (n == null)
                throw new IndexOutOfBoundsException(index);
        }
        return n.value;
    }

    public List push(int value) {
        return new List(new Node(value, this.head), this.length + 1);
    }

    public List insertBefore(int index, int value) {
        return new List(insertBefore(head, index, value), this.length + 1);
    }

    private static Node insertBefore(Node node, int index, int value) {
        if (index <= 0 || node == null)
            return new Node(value, node);

        return new Node(node.value, insertBefore(node.tail, index - 1, value));
    }

    public static void main(String[] args) {
        List as = new List(1, 2, 3, 4, 5);
        List bs = as.insertBefore(0, 0);
        List cs = bs.insertBefore(3, 42);
        List ds = cs.insertBefore(10, 50);
        System.out.println(as);
        System.out.println(bs);
        System.out.println(cs);
        System.out.println(ds);
    }
}
