class Solution {
    public int reinitializePermutation(int n) {
        if (n == 2) return 1;

        int pos = 1;
        int steps = 0;

        do {
            pos = (2 * pos) % (n - 1);
            steps++;
        } while (pos != 1);

        return steps;
    }
}
