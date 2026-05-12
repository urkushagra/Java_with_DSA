import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
        
        // Step 1: Sort by (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int energy = 0;
        int current = 0;
        
        // Step 2: Process tasks
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            // If current energy is not enough, increase it
            if (current < minimum) {
                energy += (minimum - current);
                current = minimum;
            }
            
            // Perform task
            current -= actual;
        }
        
        return energy;
    }
}
