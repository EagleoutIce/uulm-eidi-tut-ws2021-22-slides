import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTime {
   private final Date date;
   public final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

   public DateFormatTime(String date, String time) throws ParseException {
      this.date = dateFormat.parse(date + " " + time);
   }

   public long getTime() {
      return date.getTime();
   }

   public String toString() {
      return String.format(Locale.ENGLISH, "%1$tB %1$td, %1$tY at %1$tH:%1$tM", this.date);
   }

   public static void main(String[] args) throws ParseException {
      DateFormatTime time = new DateFormatTime("2015.11.17", "19:31");
      System.out.println(time);
   }
}
