import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert to Integer array
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Custom sorting
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a) != freq.get(b)) {
                return freq.get(a) - freq.get(b); // increasing frequency
            } else {
                return b - a; // decreasing value
            }
        });

        // Convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}
