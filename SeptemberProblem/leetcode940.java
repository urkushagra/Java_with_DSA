class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long total = 0;
        long[] last = new long[26]; // stores total count ending with each char
        
        for (char c : s.toCharArray()) {
            long newTotal = (2 * total + 1 - last[c - 'a'] + MOD) % MOD;
            last[c - 'a'] = (total + 1) % MOD;
            total = newTotal;
        }
        
        return (int) total;
    }
}
