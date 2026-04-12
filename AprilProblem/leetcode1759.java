class Solution {
    public int countHomogenous(String s) {
        long MOD = 1_000_000_007;
        long result = 0;

        int count = 0; // length of current streak

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            result = (result + count) % MOD;
        }

        return (int) result;
    }
}
