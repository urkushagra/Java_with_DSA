class Solution {
    public int minSwaps(String s) {
        int zeros = 0, ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
            else ones++;
        }

        // Impossible case
        if (Math.abs(zeros - ones) > 1) {
            return -1;
        }

        // If zeros are more, pattern must start with 0
        if (zeros > ones) {
            return countSwaps(s, '0');
        }

        // If ones are more, pattern must start with 1
        if (ones > zeros) {
            return countSwaps(s, '1');
        }

        // If equal, take minimum of both patterns
        return Math.min(countSwaps(s, '0'),
                        countSwaps(s, '1'));
    }

    private int countSwaps(String s, char expected) {
        int mismatch = 0;

        for (char c : s.toCharArray()) {
            if (c != expected) {
                mismatch++;
            }

            // Alternate expected character
            expected = (expected == '0') ? '1' : '0';
        }

        // Each swap fixes 2 mismatches
        return mismatch / 2;
    }
}
