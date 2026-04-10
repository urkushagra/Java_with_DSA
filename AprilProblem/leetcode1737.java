class Solution {
    public int minCharacters(String a, String b) {

        int[] countA = new int[26];
        int[] countB = new int[26];

        for (char c : a.toCharArray()) countA[c - 'a']++;
        for (char c : b.toCharArray()) countB[c - 'a']++;

        int n = a.length(), m = b.length();

        int res = Integer.MAX_VALUE;

        // Condition 3: both same character
        for (int i = 0; i < 26; i++) {
            int ops = (n - countA[i]) + (m - countB[i]);
            res = Math.min(res, ops);
        }

        // Prefix sums
        int[] prefixA = new int[26];
        int[] prefixB = new int[26];

        prefixA[0] = countA[0];
        prefixB[0] = countB[0];

        for (int i = 1; i < 26; i++) {
            prefixA[i] = prefixA[i - 1] + countA[i];
            prefixB[i] = prefixB[i - 1] + countB[i];
        }

        // Condition 1 & 2
        for (int i = 0; i < 25; i++) {

            // a < b
            int changeA = n - prefixA[i]; // chars > i
            int changeB = prefixB[i];     // chars ≤ i
            res = Math.min(res, changeA + changeB);

            // b < a
            changeA = prefixA[i];
            changeB = m - prefixB[i];
            res = Math.min(res, changeA + changeB);
        }

        return res;
    }
}
