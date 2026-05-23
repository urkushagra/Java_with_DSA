class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] population = new int[101];

        // Mark birth and death changes
        for(int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        int maxPop = 0;
        int year = 1950;
        int currentPop = 0;

        // Prefix sum traversal
        for(int i = 0; i < 101; i++) {

            currentPop += population[i];

            if(currentPop > maxPop) {
                maxPop = currentPop;
                year = 1950 + i;
            }
        }

        return year;
    }
}
