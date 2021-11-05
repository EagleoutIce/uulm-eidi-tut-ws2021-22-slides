import java.util.Arrays;

public class PriorityQueue {
    private final String[] heap;
    private int next;

    public PriorityQueue(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Negative Queuegröße.");
        this.heap = new String[size];
        next = 0;
    }

    private void swap(int i, int j) throws IndexOutOfBoundsException {
        if (!(0 <= i && i < this.heap.length))
            throw new IndexOutOfBoundsException(i);
        if (!(0 <= j && j < this.heap.length))
            throw new IndexOutOfBoundsException(j);
        String tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }

    private void percolate(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int t = i;
        if (r < next) {
            t = this.heap[l].length() <= this.heap[r].length() ? l : r;
        } else if (l < next) {
            t = l;
        }
        if (t != i && this.heap[t].length() <= this.heap[i].length()) {
            swap(i, t);
            percolate(t);
        }
    }

    public void put(String str) throws IllegalStateException {
        if (next >= this.heap.length)
            throw new IllegalStateException("Queue voll.");
        this.heap[next] = str;
        /*
         * Zunächst wird das neue Element nach oben getauscht, bis die Heapeigenschaft
         * mit einem Elternknoten nicht mehr verletzt ist.
         */
        int curr = next;
        while (curr > 0) {
            int parent = (curr - 1) / 2;
            // Heapeigenschaft bzgl. des Elternknotens nicht verletzt.
            if (this.heap[parent].length() <= this.heap[curr].length())
                break;
            // Sonst: Nach oben tauschen
            swap(curr, parent);
            curr = parent;
        }
        /*
         * Da das neue Element jetzt potenziell die Heapeigenschaft mit einem Kindknoten
         * verletzt, nutzen wir 'percolate', um dies zu korrigieren.
         */
        percolate(curr);
        next++;
    }

    public String peek() throws IllegalStateException {
        if (next <= 0)
            throw new IllegalStateException("Queue leer.");
        return this.heap[0];
    }

    public String get() throws IllegalStateException {
        if (next <= 0)
            throw new IllegalStateException("Queue leer.");
        String toReturn = this.heap[0];
        this.heap[0] = this.heap[next - 1];
        next--;
        percolate(0);
        return toReturn;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, next));
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(12);
        System.out.println(pq);
        pq.put("Hallo");
        System.out.println(pq);
        pq.put("x");
        System.out.println(pq);
        System.err.println(pq.get());
        System.out.println(pq);
        System.err.println(pq.get());
        System.out.println(pq);
    }
}
