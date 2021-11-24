import java.util.Arrays;

public class Statistics {
   public static void main(String[] args) {
      int length = (int) (Math.random() * 11 + 10);
      int[] randoms = new int[length];
      for (int i = 0; i < length; i++) {
         randoms[i] = (int) (Math.random() * 100 + 1);
      }

      // Aufsteigend sortieren
      Arrays.sort(randoms);

      // Das Minimum ist nun der erste Eintrag
      int min = randoms[0];
      // Das Maximum ist der letzte Eintrag
      int max = randoms[length - 1];

      // Mittelwert berechnen
      double avg = 0.0;
      for (int i = 0; i < length; i++) {
         avg += randoms[i];
      }
      avg /= length;

      // Median berechnen
      double med = 0.0;
      if (length % 2 == 1) {
         // Falls die Länge ungerade ist, ist es der mittlere Wert der Reihe
         med = randoms[(length / 2)];
      } else {
         // Falls nicht, der Durchschnitt der zwei mittleren Werte
         med += randoms[(length / 2) - 1];
         med += randoms[(length / 2)];
         med /= 2;
      }

      System.out.println("Minimum: " + min);
      System.out.println("Maximum: " + max);
      System.out.println("Mittelwert: " + avg);
      System.out.println("Median: " + med);
   }
}
