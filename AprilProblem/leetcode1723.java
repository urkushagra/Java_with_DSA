import java.util.*;

class Solution {

    int result = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {

        Arrays.sort(jobs);
        reverse(jobs);

        int[] workers = new int[k];
        backtrack(jobs, workers, 0);

        return result;
    }

    private void backtrack(int[] jobs, int[] workers, int index) {

        if (index == jobs.length) {
            int max = 0;
            for (int w : workers) {
                max = Math.max(max, w);
            }
            result = Math.min(result, max);
            return;
        }

        for (int i = 0; i < workers.length; i++) {

            // pruning: skip duplicate states
            if (i > 0 && workers[i] == workers[i - 1]) continue;

            workers[i] += jobs[index];

            // pruning: only proceed if promising
            if (workers[i] < result) {
                backtrack(jobs, workers, index + 1);
            }

            workers[i] -= jobs[index];

            // pruning: if worker was empty, break
            if (workers[i] == 0) break;
        }
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
