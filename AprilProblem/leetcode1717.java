class Solution {
    public int maximumGain(String s, int x, int y) {

        // Step 1: Decide priority
        if (x > y) {
            return remove(s, 'a', 'b', x, y);
        } else {
            return remove(s, 'b', 'a', y, x);
        }
    }

    private int remove(String s, char first, char second, int high, int low) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        // Step 2: remove higher priority substring
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == first &&
                c == second) {

                sb.deleteCharAt(sb.length() - 1);
                score += high;
            } else {
                sb.append(c);
            }
        }

        // Step 3: remove lower priority substring
        StringBuilder sb2 = new StringBuilder();

        for (char c : sb.toString().toCharArray()) {
            if (sb2.length() > 0 &&
                sb2.charAt(sb2.length() - 1) == second &&
                c == first) {

                sb2.deleteCharAt(sb2.length() - 1);
                score += low;
            } else {
                sb2.append(c);
            }
        }

        return score;
    }
}
