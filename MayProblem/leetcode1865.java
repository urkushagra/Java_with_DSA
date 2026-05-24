import java.util.HashMap;
import java.util.Map;

class FindSumPairs {

    private int[] nums1;
    private int[] nums2;

    // Frequency map for nums2
    private Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        freq = new HashMap<>();

        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        // Remove old value frequency
        freq.put(nums2[index], freq.get(nums2[index]) - 1);

        // Update nums2
        nums2[index] += val;

        // Add new value frequency
        freq.put(nums2[index],
                 freq.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;

        for (int num : nums1) {
            int need = tot - num;

            ans += freq.getOrDefault(need, 0);
        }

        return ans;
    }
}
