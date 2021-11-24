public class Flippin {
   public static void flipInPlace(char[] flipMyLetters) {
      int shift = 'a' - 'A';
      for (int i = 0; i < flipMyLetters.length; i++) {
         if ('A' <= flipMyLetters[i] && flipMyLetters[i] <= 'Z') {
            flipMyLetters[i] += shift;
         } else if ('a' <= flipMyLetters[i] && flipMyLetters[i] <= 'z') {
            flipMyLetters[i] -= shift;
         }
      }
   }

   public static char[] flipInCopy(char[] flipMyLetters) {
      char[] copy = flipMyLetters.clone();
      flipInPlace(copy);
      return copy;
   }

   public static void main(String[] args) {
      String sentence = "DieSeR SatZ HaT EinE merKwüRdige Groß- und KleinschreibunG.";
      System.out.println(sentence);

      char[] flipMyLetters = sentence.toCharArray();

      String inCopy = String.valueOf(flipInCopy(flipMyLetters));
      System.out.println(inCopy);
      System.out.println(flipMyLetters);

      flipInPlace(flipMyLetters);
      String inPlace = String.valueOf(flipMyLetters);
      System.out.println(inPlace);
   }
}