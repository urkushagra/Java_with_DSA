class Solution {
    public int minimumBoxes(int n) {
        int total = 0;
        int layer = 0;

        // Step 1: Build full pyramid layers
        while (true) {
            int nextLayer = (layer + 1) * (layer + 2) / 2;
            if (total + nextLayer > n) break;
            total += nextLayer;
            layer++;
        }

        // Step 2: Add extra boxes on ground
        int base = layer * (layer + 1) / 2;
        int extra = 0;

        while (total < n) {
            extra++;
            total += extra;
        }

        return base + extra;
    }
}
