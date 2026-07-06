class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );

        int count = 0;
        int prevEnd = 0;

        for (int[] interval : intervals) {
            int end = interval[1];

            // If not covered
            if (end > prevEnd) {
                count++;
                prevEnd = end;
            }
        }

        return count;
    }
}
