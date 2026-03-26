import java.util.*;

class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        
        int[] p = new int[n + 1]; // ports
        int[] w = new int[n + 1]; // weights
        
        for (int i = 1; i <= n; i++) {
            p[i] = boxes[i - 1][0];
            w[i] = boxes[i - 1][1];
        }
        
        // prefix weight sum
        int[] weightSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weightSum[i] = weightSum[i - 1] + w[i];
        }
        
        // prefix port change count
        int[] diff = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            diff[i] = diff[i - 1] + (p[i] != p[i - 1] ? 1 : 0);
        }
        
        int[] dp = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.offer(0);
        
        for (int i = 1; i <= n; i++) {
            
            // remove invalid j (constraints)
            while (!deque.isEmpty() &&
                   (i - deque.peekFirst() > maxBoxes ||
                   weightSum[i] - weightSum[deque.peekFirst()] > maxWeight)) {
                deque.pollFirst();
            }
            
            int j = deque.peekFirst();
            
            // compute dp[i]
            dp[i] = dp[j] + diff[i] - diff[j + 1] + 2;
            
            if (i == n) break;
            
            // maintain monotonic queue
            while (!deque.isEmpty() &&
                   dp[deque.peekLast()] - diff[deque.peekLast() + 1] >= dp[i] - diff[i + 1]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }
        
        return dp[n];
    }
}
