import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        // value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int idx = queue.poll();

                // reached end
                if (idx == n - 1) {
                    return steps;
                }

                // i - 1
                if (idx - 1 >= 0 && !visited[idx - 1]) {

                    visited[idx - 1] = true;
                    queue.offer(idx - 1);
                }

                // i + 1
                if (idx + 1 < n && !visited[idx + 1]) {

                    visited[idx + 1] = true;
                    queue.offer(idx + 1);
                }

                // same value jumps
                if (map.containsKey(arr[idx])) {

                    for (int next : map.get(arr[idx])) {

                        if (!visited[next]) {

                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    // IMPORTANT optimization
                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}
