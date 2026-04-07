import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Step 1: compute pair products
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        int result = 0;

        // Step 2: calculate combinations
        for (int count : map.values()) {
            if (count >= 2) {
                result += 8 * (count * (count - 1) / 2);
            }
        }

        return result;
    }
}
