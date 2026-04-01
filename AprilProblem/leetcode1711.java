import java.util.*;

class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        int MOD = 1_000_000_007;

        for (int x : deliciousness) {
            // Try all powers of 2
            for (int i = 0; i <= 21; i++) {
                int power = 1 << i;
                int y = power - x;

                count = (count + map.getOrDefault(y, 0)) % MOD;
            }

            // Add current number to map
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return (int) count;
    }
}
