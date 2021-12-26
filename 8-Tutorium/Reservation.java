import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Reservation {
   private String name;
   private Date reservationDate;
   public static final double MS_IN_S = 1000;
   public static final double S_IN_MS = 60;

   public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm");

   /**
    * @param date YYYY.MM.DD by ISO 8601
    * @param time hh:mm by ISO 8601
    * @throws ParseException If date and or time do not match the required format.
    */
   public Reservation(String name, String date, String time) throws ParseException {
      this.name = name;
      this.reservationDate = DATE_FORMAT.parse(date + " " + time);
   }

   public String toString() {
      return String.format(Locale.ENGLISH, "%s reserved a table for %2$tB %2$td, %2$tY at %2$tH:%2$tM", this.name, this.reservationDate);
   }

   public boolean equals(Reservation reservation) {
      return this == reservation || // identical or equal
         (Objects.equals(this.reservationDate, reservation.reservationDate)
         &&  Objects.equals(this.name, reservation.name));
   }

   public boolean checkIn(Reservation reservation) {
      long otherStamp = reservation.reservationDate.getTime();
      long thisStamp = this.reservationDate.getTime();
      double diffInSeconds =  (otherStamp - thisStamp) / (MS_IN_S * S_IN_MS);
      // is it between 5 and 15 minutes?
      return diffInSeconds >= -5  && diffInSeconds <= 15 ;
      // TODO: we coud check the person too
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
