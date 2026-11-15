class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long odd = 0, even = 1; // empty prefix is even
        long sum = 0;
        long ans = 0;

        for (int num : arr) {
            sum += num;

            if ((sum & 1) == 1) {
                ans = (ans + even) % MOD;
                odd++;
            } else {
                ans = (ans + odd) % MOD;
                even++;
            }
        }
        return (int) ans;
    }
}
