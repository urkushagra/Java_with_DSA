import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        int n = arrival.length;
        
        // Min-heap: [finishTime, serverId]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        // Available servers
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        int[] handled = new int[k];
        int maxHandled = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Free servers
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] finished = busy.poll();
                available.add(finished[1]);
            }
            
            if (available.isEmpty()) continue; // drop request
            
            // Find server
            int start = i % k;
            Integer server = available.ceiling(start);
            
            if (server == null) {
                server = available.first();
            }
            
            // Assign
            available.remove(server);
            busy.add(new int[]{arrival[i] + load[i], server});
            
            handled[server]++;
            maxHandled = Math.max(maxHandled, handled[server]);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (handled[i] == maxHandled) {
                result.add(i);
            }
        }
        
        return result;
    }
}
