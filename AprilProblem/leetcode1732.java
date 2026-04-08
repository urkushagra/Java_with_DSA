class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = 0;

        for (int g : gain) {
            current += g;
            max = Math.max(max, current);
        }

        return max;
    }
}
