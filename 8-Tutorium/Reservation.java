import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Reservation {
   private final String name;
   private final Date dateAndtime;
   public static final double MS_IN_S = 1000;
   public static final double S_IN_MS = 60;

   public final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

   /**
    * @param date YYYY.MM.DD by ISO 8601
    * @param time hh:mm by ISO 8601
    * @throws ParseException If date and or time do not match the required format.
    */
   public Reservation(String name, String date, String time) throws ParseException {
      this.name = name;
      this.dateAndtime = dateFormat.parse(date + " " + time);
   }

   public static String toString(Reservation r) {
      return String.format(Locale.ENGLISH, "%s reserved a table for %2$tB %2$td, %2$tY at %2$tH:%2$tM", r.name,
            r.dateAndtime);
   }

   public String toString() {
      return toString(this);
   }

   public boolean equals(Reservation reservation) {
      return this == reservation || // identical or equal
            (Objects.equals(this.dateAndtime, reservation.dateAndtime)
                  && Objects.equals(this.name, reservation.name));
   }

   public boolean checkIn(Reservation reservation) {
      long otherStamp = reservation.dateAndtime.getTime();
      long thisStamp = this.dateAndtime.getTime();
      double diffInMinutes = (otherStamp - thisStamp) / (MS_IN_S * S_IN_MS);
      // is it between 5 and 15 minutes?
      return diffInMinutes >= -5 && diffInMinutes <= 15;
      // we coud check the person too
   }

   public static void main(String[] args) throws ParseException {
      Reservation reservation = new Reservation("Hugo", "2022.10.15", "14:32");
      System.out.println(reservation);
      System.out.println("same: " + reservation.equals(reservation));
      Reservation otherSame = new Reservation("Hugo", "2022.10.15", "14:32");
      System.out.println("other: " + reservation.equals(otherSame));
      Reservation otherDifferent = new Reservation("Hugo", "2022.01.15", "14:33");
      System.out.println("different: " + reservation.equals(otherDifferent));

      // checkIn Freuden
      Reservation before = new Reservation("Hugo", "2022.10.15", "14:27");
      System.out.println("before: " + reservation.checkIn(before));
      Reservation after = new Reservation("Hugo", "2022.10.15", "14:47");
      System.out.println("after: " + reservation.checkIn(after));

      Reservation tooSoon = new Reservation("Hugo", "2022.10.15", "14:26");
      System.out.println("tooSoon: " + reservation.checkIn(tooSoon));
      Reservation tooLate = new Reservation("Hugo", "2022.10.15", "14:48");
      System.out.println("tooLate: " + reservation.checkIn(tooLate));
   }
}
