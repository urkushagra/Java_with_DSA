import java.util.*;

class Solution {
    int batchSize;
    Map<String, Integer> memo = new HashMap<>();

    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;

        int[] count = new int[batchSize];

        for (int g : groups) {
            count[g % batchSize]++;
        }

        int res = count[0]; // all divisible are happy

        // pair complements
        for (int i = 1; i <= batchSize / 2; i++) {
            if (i == batchSize - i) {
                res += count[i] / 2;
                count[i] %= 2;
            } else {
                int min = Math.min(count[i], count[batchSize - i]);
                res += min;
                count[i] -= min;
                count[batchSize - i] -= min;
            }
        }

        return res + dfs(count, 0);
    }

    private int dfs(int[] count, int remain) {
        String key = Arrays.toString(count) + "," + remain;
        if (memo.containsKey(key)) return memo.get(key);

        int max = 0;

        for (int i = 1; i < batchSize; i++) {
            if (count[i] == 0) continue;

            count[i]--;

            int newRemain = (remain + i) % batchSize;
            int happy = (remain == 0 ? 1 : 0);

            max = Math.max(max, happy + dfs(count, newRemain));

            count[i]++; // backtrack
        }

        memo.put(key, max);
        return max;
    }
}
