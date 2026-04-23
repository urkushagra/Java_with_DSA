import java.util.*;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int MOD = 1_000_000_007;

        // Max heap for buy orders
        PriorityQueue<int[]> buy = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // Min heap for sell orders
        PriorityQueue<int[]> sell = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];

            if (type == 0) { // BUY
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] top = sell.poll();

                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;

                    if (top[1] > 0) {
                        sell.offer(top);
                    }
                }

                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }

            } else { // SELL
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] top = buy.poll();

                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;

                    if (top[1] > 0) {
                        buy.offer(top);
                    }
                }

                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
                }
            }
        }

        // Count remaining backlog
        long total = 0;

        for (int[] b : buy) total = (total + b[1]) % MOD;
        for (int[] s : sell) total = (total + s[1]) % MOD;

        return (int) total;
    }
}
