class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            int count = 0;

            for (int[] point : points) {

                int px = point[0];
                int py = point[1];

                int dx = px - x;
                int dy = py - y;

                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
