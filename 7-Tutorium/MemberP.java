import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class MemberP {
  // Als Beispiel für verwendbare Konstanten
  private static final String EMPTY_NAME = "Name ist leer";
  private static final String EMPTY_SURNAME = "Nachname ist leer";
  private static final String INVALID_DATE = "Kein gültiges Datum";

  private static final String DATE_FORMAT = "dd.MM.yyyy";
  private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

  // Die Namen einer Person können sich ändern.
  private String name;
  private String surname;

  // Der Geburtstag einer Person ändert sich nicht mehr.
  private final Date birthday;

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public Date getBirthday() {
    return (Date) this.birthday.clone();
  }

  public MemberP(String name, String surname, String birthday) {
    validateName(name);
    validateSurname(surname);

    this.name = name;
    this.surname = surname;
    try {
      this.birthday = dateFormat.parse(birthday);
    } catch(ParseException e) {
      // Exceptions kann eine andere Exception als Grund übergeben werden.
      throw new IllegalArgumentException(INVALID_DATE, e);
    }
  }

  public boolean equals(MemberP other) {
    if (other == null)
      throw new NullPointerException();

    return this.name.equals(other.name)
      && this.surname.equals(other.surname)
      && this.birthday.equals(other.birthday);
  }

  private void validateName(String name) {
    if (name.isEmpty())
      throw new IllegalArgumentException(EMPTY_NAME);
  }

  private void validateSurname(String surname) {
    if (surname.isEmpty())
      throw new IllegalArgumentException(EMPTY_SURNAME);
  }

  // Bis hier her hatten wir es schon

  // Die "simple" Variante
  public int compareTo(MemberP other) {
    int perName = this.name.compareTo(other.name);
    if(perName != 0) return perName;

    int perSurname = this.surname.compareTo(other.surname);
    if(perSurname != 0) return perSurname;

    int perBirthday = this.birthday.compareTo(other.birthday);
    if(perBirthday != 0) return perBirthday;

    return 0;
  }

  private static int compareStrings(String a, String b) {
      // Info: die eigentliche Implementation von String::compareTo ist komplexer ^^
      for(int i = 0; i < Math.min(a.length(), b.length()); i ++) {
          if(a.charAt(i) != b.charAt(i)) {
            return a.charAt(i) - b.charAt(i);
          }
      }
      // Unterscheide anhand der Länge
      return a.length() - b.length();
  }

  private static int compareDates(Date a, Date b) {
    long aTime = a.getTime();
    long bTime = b.getTime();
    if(aTime == bTime) return 0;
    return aTime > bTime ? 1 : -1;
  }
}
