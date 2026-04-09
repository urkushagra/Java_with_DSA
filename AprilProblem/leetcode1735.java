import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    static final int MAX = 20000;

    long[] fact = new long[MAX];
    long[] invFact = new long[MAX];

    public Solution() {
        precompute();
    }

    // Precompute factorials and inverse factorials
    private void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    private long nCr(int n, int r) {
        if (r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public int[] waysToFillArray(int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];

            Map<Integer, Integer> factors = factorize(k);

            long ways = 1;

            for (int e : factors.values()) {
                ways = ways * nCr(n + e - 1, e) % MOD;
            }

            result[i] = (int) ways;
        }

        return result;
    }

    private Map<Integer, Integer> factorize(int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }

        if (k > 1) map.put(k, 1);

        return map;
    }
}
