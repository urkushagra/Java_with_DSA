import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    long[] fact = new long[3005];
    long[] invFact = new long[3005];

    public int makeStringSorted(String s) {

        int n = s.length();

        precompute(n);

        long ans = 0;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {

            int curr = s.charAt(i) - 'a';

            // try smaller characters
            for (int ch = 0; ch < curr; ch++) {

                if (freq[ch] == 0) continue;

                freq[ch]--;

                ans = (ans + countPermutations(n - i - 1, freq)) % MOD;

                freq[ch]++;
            }

            freq[curr]--;
        }

        return (int) ans;
    }

    private long countPermutations(int len, int[] freq) {

        long ways = fact[len];

        for (int f : freq) {
            ways = (ways * invFact[f]) % MOD;
        }

        return ways;
    }

    private void precompute(int n) {

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);

        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    private long modPow(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;

            b >>= 1;
        }

        return result;
    }
}
