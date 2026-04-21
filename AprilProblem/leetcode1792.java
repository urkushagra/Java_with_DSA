import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        // Max heap based on gain
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // initialize heap
        for (int[] c : classes) {
            double gain = gain(c[0], c[1]);
            pq.offer(new double[]{gain, c[0], c[1]});
        }

        // assign extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();

            double pass = top[1];
            double total = top[2];

            pass++;
            total++;

            pq.offer(new double[]{gain(pass, total), pass, total});
        }

        // compute result
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            sum += c[1] / c[2];
        }

        return sum / classes.length;
    }

    private double gain(double p, double t) {
        return (p + 1) / (t + 1) - (p / t);
    }
}
