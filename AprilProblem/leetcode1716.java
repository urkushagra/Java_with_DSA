class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;         // number of complete weeks
        int remainingDays = n % 7; // days in the incomplete week
        
        int total = (weeks * 28) + (7 * weeks * (weeks - 1) / 2);

        for (int i = 0; i < remainingDays; i++) {
            total += weeks + 1 + i;
        }

        return total;
    }
}
