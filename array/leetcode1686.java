import java.util.*;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        
        // Step 1: create array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Step 2: sort by (alice + bob) descending
        Arrays.sort(indices, (a, b) -> 
            (aliceValues[b] + bobValues[b]) - (aliceValues[a] + bobValues[a])
        );
        
        int aliceScore = 0;
        int bobScore = 0;
        
        // Step 3: alternate picking
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            
            if (i % 2 == 0) {
                aliceScore += aliceValues[idx];
            } else {
                bobScore += bobValues[idx];
            }
        }
        
        // Step 4: decide winner
        if (aliceScore > bobScore) return 1;
        if (bobScore > aliceScore) return -1;
        return 0;
    }
}
