public class Book {
    private static final String EMPTY_TITLE = "Titel leer";
    private static final String EMPTY_AUTHOR = "Autor leer";
    private static final String INVALID_EDITION = "Ungültige Ausgabennummer";
    private static final String INVALID_ISBN = "Ungültige ISBN";
    private static final String INVALID_RELEASE_YEAR = "Ungültiges Veröffentlichungsjahr";
    private static final String CURRENTLY_LENT = "Buch derzeit verliehen";
    private static final String INVALID_BORROWER = "Buch wurde nicht an den Rückgeber verliehen";

    // 2 a)
    public final ISBN13 isbn;
    public final String title;
    public final String author;
    public final int edition;
    public final int releaseYear;

    private Member lastLentBy;
    private boolean currentlyLent;

    public Member getLastLentBy() {
      return lastLentBy;
    }

    public boolean getCurrentlyLent() {
      return currentlyLent;
    }


    // 2 b)
    public Book(String title, String author, int edition, String isbn, int releaseYear) {
      validateArguments(title, author, edition, releaseYear);

      try {
        this.isbn = new ISBN13(isbn);
      } catch(IllegalArgumentException e) {
        throw new IllegalArgumentException(INVALID_ISBN, e);
      }

      this.title = title;
      this.author = author;
      this.releaseYear = releaseYear;
      this.edition = edition;

      this.lastLentBy = null;
      this.currentlyLent = false;
    }

    private void validateArguments(String title, String author, int edition, int releaseYear) {
        validateTitle(title);
          validateAuthor(author);
          validateEdition(edition);
          validateReleaseYear(releaseYear);
    }

    private void validateReleaseYear(int releaseYear) {
        if (releaseYear < 0)
            throw new IllegalArgumentException(INVALID_RELEASE_YEAR);
    }

    private void validateEdition(int edition) {
        if (edition <= 0)
            throw new IllegalArgumentException(INVALID_EDITION);
    }

    private void validateAuthor(String author) {
        if (author.length() <= 0)
            throw new IllegalArgumentException(EMPTY_AUTHOR);
    }

    private void validateTitle(String title) {
        if (title.length() <= 0)
            throw new IllegalArgumentException(EMPTY_TITLE);
    }

    // 2 c)
    public void lendTo(Member member) {
      if (currentlyLent)
        throw new IllegalStateException(CURRENTLY_LENT);

      this.lastLentBy = member;
      this.currentlyLent = true;
    }


    // 2 d)
    public void returnFrom(Member member) {
      if (!Objects.equals(this.lastLentBy, member))
        throw new IllegalStateException(INVALID_BORROWER);

      this.currentlyLent = false;
    }


    // Optional
    public String toString() {
      return "{ "
        + "title: " + this.title + ", "
        + "author: " + this.author + ", "
        + "releaseYear: " + this.releaseYear + ", "
        + "edition: " + this.edition + ", "
        + "isbn: " + this.isbn + ", "
        + "lastLentBy: " + this.lastLentBy + ", "
        + "currentlyLent: " + this.currentlyLent
        + " }";
    }

    public static void main(String... args) {
      Book metro = new Book("Metro 2033", "Dmitry Glukhovsky", 9, "978-3-453-52968-7", 2018);
      System.out.println(metro);
      Member horst = new Member("Horst", "Wachtelmann", "3.12.1990");
      metro.lendTo(horst);
      System.out.println(metro);
      Member monika = new Member("Monika", "Musterfrau", "2.5.1986");
      metro.returnFrom(horst);
      System.out.println(metro);
    }
  }
