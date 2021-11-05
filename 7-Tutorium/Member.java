import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Member {
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

  public Member(String name, String surname, String birthday) {
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

  // P c)
  public boolean equals(Member other) {
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

  public void setName(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateSurname(String surname) {
    if (surname.isEmpty())
      throw new IllegalArgumentException(EMPTY_SURNAME);
  }

  public void setSurname(String surname) {
    validateSurname(surname);
    this.surname = surname;
  }
}
