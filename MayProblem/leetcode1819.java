class Solution {

    public int countDifferentSubsequenceGCDs(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] exists = new boolean[max + 1];

        for (int num : nums) {
            exists[num] = true;
        }

        int answer = 0;

        // try every possible gcd
        for (int g = 1; g <= max; g++) {

            int currentGCD = 0;

            // check multiples of g
            for (int multiple = g; multiple <= max; multiple += g) {

                if (exists[multiple]) {

                    currentGCD = gcd(currentGCD, multiple);

                    if (currentGCD == g) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
