class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalWait = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int prepTime = customer[1];

            // If chef is idle, jump to arrival time
            if (currentTime < arrival) {
                currentTime = arrival;
            }

            // Chef prepares the order
            currentTime += prepTime;

            // Add waiting time
            totalWait += (currentTime - arrival);
        }

        return (double) totalWait / customers.length;
    }
}
