public class StringTime {
   public final String date;
   public final String time;

   public StringTime(String date, String time) {
      this.date = date;
      this.time = time;
   }

   public String toString() {
      return "StringTime [date=" + date + ", time=" + time + "]";
   }

   public static void main(String[] args) {
      StringTime time = new StringTime("2015.11.17", "19:31");
      System.out.println(time);
   }
}
