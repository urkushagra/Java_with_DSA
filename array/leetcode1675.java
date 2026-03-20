import java.util.*;

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int min = Integer.MAX_VALUE;
        
        // Step 1: make all numbers even
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            maxHeap.offer(num);
            min = Math.min(min, num);
        }
        
        int deviation = Integer.MAX_VALUE;
        
        // Step 2: reduce max
        while (true) {
            int max = maxHeap.poll();
            
            deviation = Math.min(deviation, max - min);
            
            // If max is odd → cannot reduce further
            if (max % 2 == 1) break;
            
            // Reduce max
            max /= 2;
            min = Math.min(min, max);
            maxHeap.offer(max);
        }
        
        return deviation;
    }
}
