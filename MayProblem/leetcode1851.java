import java.util.*;

class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;

        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {

            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] answer = new int[n];

        // {size, end}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int i = 0;

        for (int[] query : q) {

            int value = query[0];
            int index = query[1];

            // add valid intervals
            while (i < intervals.length &&
                   intervals[i][0] <= value) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int size = right - left + 1;

                pq.offer(new int[]{size, right});

                i++;
            }

            // remove invalid intervals
            while (!pq.isEmpty() && pq.peek()[1] < value) {

                pq.poll();
            }

            if (pq.isEmpty()) {

                answer[index] = -1;
            }
            else {

                answer[index] = pq.peek()[0];
            }
        }

        return answer;
    }
}
