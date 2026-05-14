import java.util.*;

class Solution {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        long sum = 0;

        int left = 0;
        int answer = 1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while ((long) nums[right] * (right - left + 1) - sum > k) {

                sum -= nums[left];
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
