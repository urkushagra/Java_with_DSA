class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[] bit1 = new int[n];
        int[] bit2 = new int[n];

        for (int i = 0; i < n; i++) {
            int mask1 = 0, mask2 = 0;
            for (int j = 0; j < n; j++) {
                mask1 = (mask1 << 1) | img1[i][j];
                mask2 = (mask2 << 1) | img2[i][j];
            }
            bit1[i] = mask1;
            bit2[i] = mask2;
        }

        int maxOverlap = 0;

        for (int xShift = -n + 1; xShift < n; xShift++) {
            for (int yShift = -n + 1; yShift < n; yShift++) {
                int overlap = 0;

                for (int i = 0; i < n; i++) {
                    int j = i + xShift;
                    if (j < 0 || j >= n) continue;

                    int row1 = bit1[i];
                    int row2 = bit2[j];

                    if (yShift > 0) {
                        row1 >>= yShift;
                    } else if (yShift < 0) {
                        row1 <<= -yShift;
                    }

                    overlap += Integer.bitCount(row1 & row2);
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}
