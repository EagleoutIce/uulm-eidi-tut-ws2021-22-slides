import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

public class RingBuffer {
   class Element {
      private int value;
      private Element next;

      public Element() {
         this.next = null;
      }

      public void setNextElement(Element nextElement) {
         this.next = nextElement;
      }

      public Element getNextElement() {
         return this.next;
      }

      public void setValue(int value) {
         this.value = value;
      }

      public int getValue() {
         return this.value;
      }
   }

   private Element head;
   private Element tail;
   private boolean isFull;

   public RingBuffer(int capacity) {
      this.isFull = capacity <= 0;
      if (this.isFull)
         return;

      Element current = new Element(); // Magic-Number-Standard
      this.head = this.tail = current;

      for (int i = 1; i < capacity; i++) {
         Element next = new Element();
         current.setNextElement(next);

         if (i == capacity - 1)
            next.setNextElement(head);

         current = next;
      }
   }

   public void addValue(int value) {
      if ((head == tail) && isFull)
         throw new BufferOverflowException();

      tail.setValue(value);
      tail = tail.getNextElement();

      if (tail == head)
         isFull = true;
   }

   public int getValue() {
      if ((head == tail) && !isFull)
         throw new NoSuchElementException();

      isFull = false;
      int value = head.getValue();
      head = head.getNextElement();

      return value;
   }

   public static void main(String[] args) {
      RingBuffer buffer = new RingBuffer(5);

      buffer.addValue(5);
      buffer.addValue(4);

      // System.out.println(buffer.getValue());
      // System.out.println(buffer.getValue());

      buffer.addValue(3);
      buffer.addValue(2);
      // System.out.println(buffer.getValue());
      // System.out.println(buffer.getValue());
      buffer.addValue(1);
      System.out.println(buffer.getValue());
      System.out.println(buffer.getValue());
      System.out.println(buffer.getValue());
      System.out.println(buffer.getValue());
      buffer.addValue(3);
      buffer.addValue(42);
      System.out.println(buffer.getValue());
      System.out.println(buffer.getValue());
      System.out.println(buffer.getValue());

   }
}
