import java.util.*;

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int reach = 0;

        for (int coin : coins) {
            if (coin > reach + 1) break;
            reach += coin;
        }

        return reach + 1;
    }
}
