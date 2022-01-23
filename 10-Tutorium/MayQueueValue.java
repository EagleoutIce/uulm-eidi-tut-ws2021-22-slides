public class MayQueueValue {
   private final boolean stored;
   private final int value;

   public MayQueueValue(int value) {
       this.stored = true;
       this.value = value;
   }

   public MayQueueValue() {
      this.stored = false;
      this.value = -1;
   }
   public int getValue() { return this.value; }
   public boolean hasValue() { return this.stored; }
}