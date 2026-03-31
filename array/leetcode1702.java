class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] result = new char[n];

        // Step 1: Count zeros
        int zeroCount = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') zeroCount++;
        }

        // Step 2: If no zero → already max
        if (zeroCount <= 1) return binary;

        // Step 3: Find first zero index
        int firstZeroIndex = binary.indexOf('0');

        // Step 4: Fill result with '1'
        Arrays.fill(result, '1');

        // Step 5: Place the only '0'
        int zeroPosition = firstZeroIndex + zeroCount - 1;
        result[zeroPosition] = '0';

        return new String(result);
    }
}
