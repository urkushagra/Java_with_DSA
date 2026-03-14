class Solution {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        dfs(n, k, new StringBuilder(), ' ');
        return result;
    }

    private void dfs(int n, int k, StringBuilder sb, char prev) {
        if (!result.isEmpty()) return; // early stop

        if (sb.length() == n) {
            count++;
            if (count == k) {
                result = sb.toString();
            }
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != prev) {
                sb.append(ch);
                dfs(n, k, sb, ch);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
