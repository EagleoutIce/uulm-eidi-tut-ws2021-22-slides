public class CustomTime {
   public final int year;
   public final byte month;
   public final byte day;
   public final byte hour;
   public final byte minute;

   // Validity checks are not required as we can expect dates
   // to be correct
   public CustomTime(String date, String time) {
      this.year = Integer.parseInt(date.substring(0,4));
      this.month = Byte.parseByte(date.substring(5,7));
      this.day = Byte.parseByte(date.substring(8,10));

      this.hour = Byte.parseByte(time.substring(0,2));
      this.minute = Byte.parseByte(time.substring(3,5));
   }

   public String toString() {
      return "CustomTime [day=" + day + ", month=" + month + ", year=" + year
      + ", hour=" + hour + ", minute=" + minute + "]";
   }

   public static void main(String[] args) {
      CustomTime time = new CustomTime("2015.11.17", "19:31");
      System.out.println(time);
   }
}
