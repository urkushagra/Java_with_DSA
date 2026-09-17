class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int INF = Integer.MAX_VALUE / 2;

        
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0, sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            
            while (sum > target) {
                sum -= arr[left++];
            }

            
            
                if (sum == target) {
                int len = right - left + 1;

                
                if (left > 0) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                
                best[right] = Math.min(
                        right > 0 ? best[right - 1] : INF,
                        len
                );
            } else {
                
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}
