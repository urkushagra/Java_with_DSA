class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxPile = Math.max(a, Math.max(b, c));

        return Math.min(sum / 2, sum - maxPile);
    }
}
