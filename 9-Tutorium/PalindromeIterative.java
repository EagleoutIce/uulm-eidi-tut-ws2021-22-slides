public class PalindromeIterative {
   public static boolean isPalindromeIterative(String s) {
      s = s.toLowerCase();
      for (int i = 0; i < s.length() / 2; i++) {
         if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;
      }
      return true;
   }

   public static boolean isPalindrome(String s) {
      return isPalindromeRecursive(s.toLowerCase(), 0);
   }

   private static boolean isPalindromeRecursive(String s, int i) {
      if (i >= s.length() / 2) // ! (i < s.length / 2)
         return true;
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) // if in for
         return false;
      // check next
      return isPalindromeRecursive(s, i + 1);
   }

   public static void main(String[] args) {
      String palindrome = "AbbaAbba";
      String noPalindrome = "Reittier";

      System.out.println(palindrome + " ist " + (isPalindromeIterative(palindrome) ? "ein" : "kein") + " Palindrom");
      System.out
            .println(noPalindrome + " ist " + (isPalindromeIterative(noPalindrome) ? "ein" : "kein") + " Palindrom");
   }
}
