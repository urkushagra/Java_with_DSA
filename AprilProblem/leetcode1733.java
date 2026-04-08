import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        int m = languages.length;

        // Step 1: convert to sets
        List<Set<Integer>> langSet = new ArrayList<>();
        for (int[] lang : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : lang) set.add(l);
            langSet.add(set);
        }

        // Step 2: find bad users
        Set<Integer> badUsers = new HashSet<>();

        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;

            boolean canCommunicate = false;

            for (int lang : langSet.get(u)) {
                if (langSet.get(v).contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            if (!canCommunicate) {
                badUsers.add(u);
                badUsers.add(v);
            }
        }

        // Step 3: try each language
        int result = Integer.MAX_VALUE;

        for (int l = 1; l <= n; l++) {
            int count = 0;

            for (int user : badUsers) {
                if (!langSet.get(user).contains(l)) {
                    count++;
                }
            }

            result = Math.min(result, count);
        }

        return result;
    }
}
