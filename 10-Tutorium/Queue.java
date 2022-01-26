public class Queue {
   class Element {
       private final int value;
       private Element next;

       public Element(int value) {
           this.value = value;
           this.next = null;
       }

       public void setNextElement(Element nextElement) {
           this.next = nextElement;
       }

       public Element getNextElement() {
           return this.next;
       }

       public int getValue() {
           return this.value;
       }
   }

   private Element first;
   private Element last;
   private int length;

   public Queue() {
       this.first = this.last = null;
       this.length = 0;
   }

   public void enqueue(int value) {
       Element newElement = new Element(value);

       if(length == 0) {
           this.first = newElement;
           this.last = newElement;
       } else {
           this.last.setNextElement(newElement);
           this.last = newElement;
       }
       length++;
   }

   public boolean dequeue() {
       if(length > 0) {
           this.first = this.first.getNextElement();
           length--;
           if(length == 0)
                this.last = null;
           return true;
       }
       return false;
   }

   public int getLength() {
       return this.length;
   }

   public Integer getFirst() {
       if(length > 0)
           return first.getValue();
       return null;
   }

   public Integer getLast() {
       if(length > 0)
           return last.getValue();
       return null;
   }

   public String toString() {
       String s = "[";
       if(length > 0) {
           Element current = this.first;
           while (current.getNextElement() != null) {
               s += current.getValue() + ", ";
               current = current.getNextElement();
           }
           s += current.getValue();
       }
       s += "]";
       return s;
   }

   public static void main(String[] args) {
       Queue queue = new Queue();
       queue.enqueue(3);
       queue.enqueue(1);
       queue.enqueue(7);
       queue.enqueue(5);
       queue.enqueue(9);

       System.out.println("Die Queue: " + queue.toString() + " hat eine Länge von " + queue.getLength());
       if(queue.dequeue())
           System.out.println("Das erste Element wurde entfernt");
       else
           System.out.println("Entfernen des ersten Elements war nicht möglich");

       if(queue.getFirst() != null)
           System.out.println("Das neue erste Element ist: " + queue.getFirst());

       if(queue.getLast() != null)
           System.out.println("Das letzte Element ist immer noch: " + queue.getLast());
   }
}
