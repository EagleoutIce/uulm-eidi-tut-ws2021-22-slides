public class WheelOfFortune {
   private String[] slots;
   private int nextSlot;

   public WheelOfFortune(int numSlots) {
       nextSlot = 0;
       slots = new String[Math.max(numSlots, 0)];
       for(int i = 0; i < slots.length; i++)
           slots[i] = "";
   }

   public boolean addEntry(String entry) {
       if(nextSlot == slots.length)
           return false;

       slots[nextSlot] = entry;
       nextSlot++;
       return true;
   }

   public boolean removeEntry() {
       if(nextSlot == 0)
           return false;

       nextSlot--;
       slots[nextSlot] = "";
       return false;
   }

   public int getNumEntries() {
       return nextSlot;
   }

   public String spin() {
       if(slots.length == 0)
           return "";

       int slot = (int) (Math.random() * nextSlot);
       return slots[slot];
   }

   public static void main(String[] args) {
       int numSlots = 6;
       WheelOfFortune wheel = new WheelOfFortune(numSlots);

       for(int i = 0; i < numSlots + 1; i++) {
         String entry = "Eintrag " + (char) ('A' + i);
         if(wheel.addEntry(entry))
               System.out.println("Eintrag " + entry + " hinzugefügt");
           else
               System.out.println("Eintrag " + entry + " konnte nicht hinzugefügt werden");
       }

       String result = wheel.spin();
       System.out.println("Ergebnis einer Drehung: " + result);

       while(wheel.getNumEntries() > 0)
           wheel.removeEntry();

       result = wheel.spin();
       System.out.println("Drehen des leeren Glücksrades ergibt: " + result);
   }
}
