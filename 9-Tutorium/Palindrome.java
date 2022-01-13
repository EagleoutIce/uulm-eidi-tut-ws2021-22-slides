public class Palindrome {
   private static boolean isPalindrome(String s) {
      return isPalindromeRecursive(s.toLowerCase());
   }

   private static boolean isPalindromeRecursive(String s) {
      if (s.length() < 2)
         return true;
      else if (s.charAt(0) != s.charAt(s.length() - 1))
         return false;
      else
         return isPalindromeRecursive(s.substring(1, s.length() - 1));
   }

   public static void main(String[] args) {
      String palindrome = "AbbaAbba";
      String noPalindrome = "Reittier";

      System.out.println(palindrome + " ist " + (isPalindrome(palindrome) ? "ein" : "kein") + " Palindrome");
      System.out.println(noPalindrome + " ist " + (isPalindrome(noPalindrome) ? "ein" : "kein") + " Palindrome");
   }
}
