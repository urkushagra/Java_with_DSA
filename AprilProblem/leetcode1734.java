class Solution {
    public int[] decode(int[] encoded) {

        int n = encoded.length + 1;

        // Step 1: total XOR of 1..n
        int totalXor = 0;
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }

        // Step 2: XOR of encoded at odd indices
        int oddXor = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            oddXor ^= encoded[i];
        }

        // Step 3: find perm[0]
        int[] perm = new int[n];
        perm[0] = totalXor ^ oddXor;

        // Step 4: reconstruct
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }

        return perm;
    }
}
