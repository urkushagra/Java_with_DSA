import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Min-heap for available servers: sorted by weight, then by index
        // Stores: int[]{weight, index}
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Min-heap for busy servers: sorted by free_time
        // Stores: int[]{free_time, index}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initially, all servers are available at second 0
        for (int i = 0; i < n; i++) {
            available.add(new int[]{servers[i], i});
        }

        int currTime = 0;
        for (int j = 0; j < m; j++) {
            // Current time must be at least the arrival time of the j-th task
            currTime = Math.max(currTime, j);

            // 1. Move all servers that have finished their tasks by currTime to available
            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                int[] freed = busy.poll();
                int idx = freed[1];
                available.add(new int[]{servers[idx], idx});
            }

            // 2. If no available servers, fast-forward time to the next freeing server
            if (available.isEmpty()) {
                currTime = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                    int[] freed = busy.poll();
                    int idx = freed[1];
                    available.add(new int[]{servers[idx], idx});
                }
            }

            // 3. Assign the task to the top available server
            int[] server = available.poll();
            int serverIdx = server[1];
            ans[j] = serverIdx;

            // 4. Put the server into the busy heap with its new free time
            busy.add(new int[]{currTime + tasks[j], serverIdx});
        }

        return ans;
    }
}
