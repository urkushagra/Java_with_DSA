public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "madam";
        System.out.println(s + " is palindrome? " + isPalindrome(s));
    }
}
