import java.util.*;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0] // sort by expiry day
        );

        int n = apples.length;
        int day = 0;
        int eaten = 0;

        while (day < n || !pq.isEmpty()) {

            // Step 1: add today's apples
            if (day < n && apples[day] > 0) {
                pq.offer(new int[]{day + days[day], apples[day]});
            }

            // Step 2: remove rotten apples
            while (!pq.isEmpty() && pq.peek()[0] <= day) {
                pq.poll();
            }

            // Step 3: eat apple
            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                eaten++;

                if (top[1] > 1) {
                    pq.offer(new int[]{top[0], top[1] - 1});
                }
            }

            day++;
        }

        return eaten;
    }
}
