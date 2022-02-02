public class Queue {
    class Element {
        private final IntegerNode node;
        private Element next;

        public Element(IntegerNode node) {
            this.node = node;
            this.next = null;
        }

        public void setNextElement(Element nextElement) {
            this.next = nextElement;
        }

        public Element getNextElement() {
            return this.next;
        }

        public IntegerNode getNode() {
            return this.node;
        }
    }

    private Element first;
    private Element last;
    private int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void enqueue(IntegerNode node) {
        Element newElement = new Element(node);

        if(length == 0)
            this.first = newElement;
        else
            this.last.setNextElement(newElement);

        this.last = newElement;
        length++;
    }

    public IntegerNode dequeue() {
        if(length > 0) {
            IntegerNode front = this.first.getNode();
            this.first = this.first.getNextElement();
            length--;
            return front;
        }

        return null;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

}
