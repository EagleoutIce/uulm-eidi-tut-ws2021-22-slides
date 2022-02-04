import java.util.NoSuchElementException;

public class DoublyLinkedList implements SeekAndRemove {
    private class Element {
        public final int value;
        public Element prev = null, next = null;
        public Element(int value, Element prev, Element next) {
            this.value = value; this.prev = prev; this.next = next;
        }
    }

    private Element head = null;
    private Element tail = null;
    private int length = 0;

    public DoublyLinkedList() { }

    public void addFront(int value) {
        Element element = new Element(value, null, this.head);
        if(length == 0) this.tail = element;
        else this.head.prev = element;

        this.head = element;
        this.length++;
    }

    public void addBack(int value) {
        Element element = new Element(value, tail, null);
        if(length == 0) this.head = element;
        else this.tail.next = element;

        this.tail = element;
        this.length++;
    }

    // Private helper method
    private void removeElement(Element element) {
        if(element == this.head)
            this.head = element.next;
        if(element == this.tail)
            this.tail = element.prev;

        if(element.prev != null)
            element.prev.next = element.next;

        if(element.next != null)
            element.next.prev = element.prev;

        this.length--;
    }

    @Override
    public void removeFirst(int value) {
        Element current = head;
        while(current != null) {
            if(current.value == value) {
                removeElement(current);
                break;
            }
            current = current.next;
        }
    }

    @Override
    public void removeLast(int value) {
        Element current = tail;
        while(current != null) {
            if(current.value == value) {
                removeElement(current);
                break;
            }
            current = current.prev;
        }
    }

    @Override
    public void removeAll(int value) {
        Element current = head; // tail to head wäre genauso möglich
        while(current != null) {
            if(current.value == value)
                removeElement(current);

            current = current.next;
        }
    }

    public static void printList(DoublyLinkedList list) {
        System.out.print("[");
        Element current = list.head;

        while(current.next != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println(current.value + "]");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 1; i <= 9; i++) {
            list.addFront(i);
            list.addBack(i);
        }
        printList(list);
        list.removeFirst(9);
        printList(list);
        list.removeLast(9);
        printList(list);
        list.removeAll(1);
        printList(list);
    }
}
