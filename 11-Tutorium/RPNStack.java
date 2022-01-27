import java.util.NoSuchElementException;

public class RPNStack {
   private class Element {
      private int value;
      private Element next;

      public Element(int value) {
         this.value = value;
         this.next = null;
      }

      public int getValue() {
         return this.value;
      }

      public void setNextElement(Element element) {
         this.next = element;
      }

      public Element getNextElement() {
         return this.next;
      }
   }

   private Element stackPointer;
   private int size;

   private enum Operation {
      ADD, SUB, MUL
   }

   public RPNStack() {
      this.stackPointer = null;
      this.size = 0;
   }

   public void push(int value) {
      Element top = new Element(value);
      top.setNextElement(this.stackPointer);
      this.stackPointer = top;
      size++;
   }

   public int pop() {
      if (size == 0)
         throw new NoSuchElementException();

      int value = this.stackPointer.getValue();
      this.stackPointer = this.stackPointer.next;
      size--;
      return value;
   }

   private void performOperation(Operation operation) {
      int a = this.pop();
      int b = this.pop();

      switch (operation) {
         case ADD:
            this.push(a + b);
            break;
         case SUB:
            this.push(b - a);
            break;
         case MUL:
            this.push(a * b);
      }
   }

   public void add() {
      if (size < 2)
         throw new NoSuchElementException();
      performOperation(Operation.ADD);
   }

   public void subtract() {
      if (size < 2)
         throw new NoSuchElementException();
      performOperation(Operation.SUB);
   }

   public void multiply() {
      if (size < 2)
         throw new NoSuchElementException();
      performOperation(Operation.MUL);
   }

   public void print() {
      Element element = this.stackPointer;
      if (size == 0) {
         System.out.println("Der Stack ist leer!");
         return;
      }
      while (element.next != null) {
         System.out.println("+----+");
         System.out.println((element.value / 10 > 0 ? "| " : "|  ") + element.value + " |");
         element = element.next;
      }
      System.out.println("+----+");
      System.out.println((element.value / 10 > 0 ? "| " : "|  ") + element.value + " |");
      System.out.println("+----+");
   }

   public static void main(String[] args) {
      RPNStack stack = new RPNStack();

      stack.push(2);
      stack.push(5);
      stack.add();

      stack.push(4);
      stack.push(1);
      stack.subtract();
      stack.multiply();

      int result = stack.pop();
      System.out.println("Die Auswertung von 2 5 + 4 1 - x ergibt: " + result);
   }

}
