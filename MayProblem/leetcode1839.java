class Solution {

    public int longestBeautifulSubstring(String word) {

        int n = word.length();

        int maxLen = 0;

        int count = 1;
        int start = 0;

        for (int i = 1; i < n; i++) {

            // order broken
            if (word.charAt(i) < word.charAt(i - 1)) {

                count = 1;
                start = i;
            }
            // new vowel encountered
            else if (word.charAt(i) > word.charAt(i - 1)) {

                count++;
            }

            // all 5 vowels present
            if (count == 5) {

                maxLen = Math.max(maxLen, i - start + 1);
            }
        }

        return maxLen;
    }
}
