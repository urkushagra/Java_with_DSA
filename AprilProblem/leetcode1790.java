class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count == 1) first = i;
                else if (count == 2) second = i;
                else return false; // more than 2 mismatches
            }
        }

        // Case 1: already equal
        if (count == 0) return true;

        // Case 2: exactly 2 mismatches
        return count == 2 &&
               s1.charAt(first) == s2.charAt(second) &&
               s1.charAt(second) == s2.charAt(first);
    }
}
