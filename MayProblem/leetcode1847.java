import java.util.*;

class Solution {

    public int[] closestRoom(int[][] rooms, int[][] queries) {

        // sort rooms by size descending
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);

        int k = queries.length;

        int[][] q = new int[k][3];

        for (int i = 0; i < k; i++) {

            q[i][0] = queries[i][0]; // preferred
            q[i][1] = queries[i][1]; // minSize
            q[i][2] = i;             // original index
        }

        // sort queries by minSize descending
        Arrays.sort(q, (a, b) -> b[1] - a[1]);

        int[] answer = new int[k];

        TreeSet<Integer> set = new TreeSet<>();

        int roomIndex = 0;

        for (int[] query : q) {

            int preferred = query[0];
            int minSize = query[1];
            int originalIndex = query[2];

            // add all rooms satisfying minSize
            while (roomIndex < rooms.length &&
                   rooms[roomIndex][1] >= minSize) {

                set.add(rooms[roomIndex][0]);
                roomIndex++;
            }

            // no valid rooms
            if (set.isEmpty()) {

                answer[originalIndex] = -1;
                continue;
            }

            Integer floor = set.floor(preferred);
            Integer ceil = set.ceiling(preferred);

            int best = -1;

            if (floor != null && ceil != null) {

                if (Math.abs(floor - preferred)
                    <= Math.abs(ceil - preferred)) {

                    best = floor;
                }
                else {
                    best = ceil;
                }
            }
            else if (floor != null) {

                best = floor;
            }
            else {

                best = ceil;
            }

            answer[originalIndex] = best;
        }

        return answer;
    }
}
