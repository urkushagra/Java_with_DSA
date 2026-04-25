class Solution {
    static final int MOD = 1_000_000_007;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3) return primeFactors;

        long result;

        if (primeFactors % 3 == 0) {
            result = modPow(3, primeFactors / 3);
        } else if (primeFactors % 3 == 1) {
            result = modPow(3, primeFactors / 3 - 1) * 4 % MOD;
        } else {
            result = modPow(3, primeFactors / 3) * 2 % MOD;
        }

        return (int) result;
    }

    private long modPow(long base, int exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
