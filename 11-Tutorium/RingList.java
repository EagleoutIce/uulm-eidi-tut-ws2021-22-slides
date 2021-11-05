public class RingList {
    private Elem head = null;
    private int capacity;

    public RingList(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        assert(head != null);
        return head.val;
    }

    public void addAtNextPosition(int i) {
        if (isEmpty())
            addInitialElement(i);
        else
            addNewElement(i);
    }

    public static int nNacci(int n, int k){
        RingList ringlist = new RingList(n);
        if(k == 0) return 0;
        if(k == 1) return 1;
        ringlist.addAtNextPosition(1);
        for(int i = 2; i < k; i++){
            ringlist.addAtNextPosition(ringlist.getSum());
        }
        return ringlist.getSum();
    }

    public static void main(String[] args) {
        System.out.println(nNacci(5, 5));
    }

    private void addNewElement(int i) {
        Elem second = head.next;
        head.next = new Elem(i);
        if(capacity <= 0) // überschreiben
            head.next.next = second.next;
        else { // anfügen
            head.next.next = second;
            capacity--;
        }
    }

    private void addInitialElement(int i) {
        this.head = new Elem (i);
        this.head.next = this.head;
        capacity--;
    }

    public int getSum() {
        if (isEmpty())
            return 0;
        int sum = 0;
        Elem current = this.head;
        do {
            sum = sum + current.val;
            current = current.next;
        } while (current != head);
        return sum;
    }
}