import java.math.BigInteger;

class Solution {

    public boolean splitString(String s) {

        int n = s.length();

        for (int i = 0; i < n - 1; i++) {

            BigInteger first = new BigInteger(s.substring(0, i + 1));

            if (dfs(s, i + 1, first)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(String s, int index, BigInteger prev) {

        if (index == s.length()) {
            return true;
        }

        BigInteger num = BigInteger.ZERO;

        for (int i = index; i < s.length(); i++) {

            num = num.multiply(BigInteger.TEN)
                     .add(BigInteger.valueOf(s.charAt(i) - '0'));

            // check if num == prev - 1
            if (num.equals(prev.subtract(BigInteger.ONE))) {

                if (dfs(s, i + 1, num)) {
                    return true;
                }
            }

            // pruning
            if (num.compareTo(prev) >= 0) {
                break;
            }
        }

        return false;
    }
}
