class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        // Step 1: Precompute palindrome table
        boolean[][] isPal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }

        // Step 2: Try all splits
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (isPal[0][i] && isPal[i + 1][j] && isPal[j + 1][n - 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
