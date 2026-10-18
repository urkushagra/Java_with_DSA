import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;
    private long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations
        comb = new long[n][n];
        for (int i = 0; i < n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        return (int)((dfs(list) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) return 1;

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }

        long leftWays = dfs(left) % MOD;
        long rightWays = dfs(right) % MOD;

        int L = left.size();
        int R = right.size();

        long ways = comb[L + R][L];

        return (((ways * leftWays) % MOD) * rightWays) % MOD;
    }
}
