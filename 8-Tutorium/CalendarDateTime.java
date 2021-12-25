import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarDateTime {
   private final Date date;

   public CalendarDateTime(String date, String time) {
      CustomTime custom = new CustomTime(date, time);
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.set(custom.year, custom.month - 1, custom.day,
         custom.hour, custom.minute);
      this.date = calendar.getTime();
   }

   public long getTime() {
      return date.getTime();
   }

   public String toString() {
      return String.format(Locale.ENGLISH, "%1$tB %1$td, %1$tY at %1$tH:%1$tM", this.date);
   }

   public static void main(String[] args) {
      CalendarDateTime time = new CalendarDateTime("2015.11.17", "19:31");
      System.out.println(time);
   }
}
