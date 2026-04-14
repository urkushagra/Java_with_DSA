class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int count = 0;
        int ops = 0;

        // Left to right
        for (int i = 0; i < n; i++) {
            answer[i] += ops;

            if (boxes.charAt(i) == '1') {
                count++;
            }

            ops += count;
        }

        // Reset
        count = 0;
        ops = 0;

        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += ops;

            if (boxes.charAt(i) == '1') {
                count++;
            }

            ops += count;
        }

        return answer;
    }
}
