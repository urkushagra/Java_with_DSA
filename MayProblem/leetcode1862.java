class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int MOD = 1_000_000_007;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Frequency array
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Prefix sum array
        int[] prefix = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }

        long ans = 0;

        // For every possible divisor
        for (int x = 1; x <= max; x++) {
            if (freq[x] == 0) continue;

            // Find all ranges where floor(y / x) = k
            for (int k = 1; k * x <= max; k++) {
                int left = k * x;
                int right = Math.min(max, (k + 1) * x - 1);

                int count = prefix[right] - prefix[left - 1];

                ans = (ans + 1L * freq[x] * count * k) % MOD;
            }
        }

        return (int) ans;
    }
}
