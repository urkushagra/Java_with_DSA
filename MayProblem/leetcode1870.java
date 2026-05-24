class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {

        int n = dist.length;

        // Impossible case
        if (hour <= n - 1) {
            return -1;
        }

        int left = 1;
        int right = 10_000_000;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canReach(dist, hour, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canReach(int[] dist, double hour, int speed) {

        double time = 0.0;

        for (int i = 0; i < dist.length; i++) {

            double travel = (double) dist[i] / speed;

            // Last train does not require waiting
            if (i == dist.length - 1) {
                time += travel;
            } else {
                time += Math.ceil(travel);
            }
        }

        return time <= hour;
    }
}
