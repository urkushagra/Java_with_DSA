class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] box = new int[46]; // max digit sum = 45
        int maxBalls = 0;

        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = digitSum(i);
            box[sum]++;
            maxBalls = Math.max(maxBalls, box[sum]);
        }

        return maxBalls;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
