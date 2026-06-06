import java.util.*;

class Solution {

    private Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n,
                                   int firstPlayer,
                                   int secondPlayer) {

        return dfs(n, firstPlayer, secondPlayer);
    }

    private int[] dfs(int n, int a, int b) {

        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        if (a + b == n + 1) {
            return new int[]{1, 1};
        }

        String key = n + "," + a + "," + b;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;

        int nextN = (n + 1) / 2;

        for (int na = 1; na <= nextN; na++) {
            for (int nb = na + 1; nb <= nextN; nb++) {

                if (!reachable(n, a, b, na, nb)) {
                    continue;
                }

                int[] res = dfs(nextN, na, nb);

                earliest = Math.min(earliest, res[0] + 1);
                latest = Math.max(latest, res[1] + 1);
            }
        }

        int[] ans = new int[]{earliest, latest};
        memo.put(key, ans);
        return ans;
    }

    private boolean reachable(int n,
                              int a,
                              int b,
                              int na,
                              int nb) {

        int leftA = a - 1;
        int middle = b - a - 1;
        int right = n - b;

        int countA = 0;
        int countB = 0;

        for (int x = 0; x <= leftA; x++) {

            int y = na - 1 - x;

            if (y < 0 || y > middle) {
                continue;
            }

            int remainMiddle = middle - y;

            for (int z = 0; z <= remainMiddle; z++) {

                int posB =
                        x + y + 1 + z + 1;

                if (posB == nb) {
                    return true;
                }
            }
        }

        return false;
    }
}
