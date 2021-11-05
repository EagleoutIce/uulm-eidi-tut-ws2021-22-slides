import java.util.Objects;
import java.util.Scanner;

public class User {
    private static int nextId = 0;
    public final int id; // oder mit Getter

    private String userName;
    private int passwordHash;
    private boolean loggedIn;

    @Override
    public String toString() {
        return "User [id=" + id + ", loggedIn=" + loggedIn + ", passwordHash=" + passwordHash + ", userName=" + userName
                + "]";
    }

    private User(String userName, String password) {
        this.id = nextId;
        nextId += 1; // This is bad. Why?
        this.userName = userName;
        this.passwordHash = password.hashCode();
        this.loggedIn = false;
    }

    public static User create(String userName, String password) {
        if(!isUsernameValid(userName) || !isPasswordValid(password))
            return null;
        return new User(userName, password);
    }

    private static boolean isUsernameValid(String userName) {
        if(userName == null || userName.length() <= 0)
            return false;
        for (char c : userName.toCharArray()) {
            if(!isCharInUsernameValid(c))
                return false;
        }
        return true;
    }

    private static boolean isCharInUsernameValid(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private static boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6;
    }


    // why Objects.* ?
    public boolean verify(String userName, String password) {
        return Objects.equals(this.userName, userName) &&
            this.passwordHash == Objects.hashCode(password);
    }

    public void login(String userName, String password) {
        if(this.verify(userName, password)) {
            this.loggedIn = true;
            System.out.println("Nutzer " + this.id + " erfolgreich eingeloggt.");
        } else {
            System.err.println("Kein Nutzer mit dieser Nutzernamen/Passwort-Kombination gefunden.");
        }
    }

    public void logout(String userName) {
        if(Objects.equals(this.userName, userName)) {
            this.loggedIn = false;
            System.out.println("Nutzer " + this.id + " erfolgreich ausgeloggt.");
        } else {
            System.err.println("Kein Nutzer mit Namen " + userName + " eingeloggt.");
        }
    }

    public void changePassword(String userName, String oldPassword, String newPassword) {
        if(this.verify(userName, oldPassword) && isPasswordValid(newPassword)) {
            this.passwordHash = newPassword.hashCode();
            System.out.println("Passwort erfolgreich geändert!");
        } else {
            System.err.println("Kein Nutzer mit dieser Nutzernamen/Passwort-Kombination gefunden.");
        }
    }

    public void changePassword(String userName, String oldPassword) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Neues Passwort: ");
        String newPassword = scanner.nextLine();
        System.out.print("Passwort wiederholen: ");
        String repetition = scanner.nextLine();
        scanner.close();
        if(!Objects.equals(newPassword, repetition)) {
            System.err.println("Das Passwort und die Wiederholung stimmen nicht überein!");
            return;
        }
        changePassword(userName, oldPassword, newPassword);
    }
}
