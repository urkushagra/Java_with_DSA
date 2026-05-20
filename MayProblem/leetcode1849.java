class Solution {

    public boolean splitString(String s) {

        int n = s.length();

        
        for (int i = 0; i < n - 1; i++) {

            long first = Long.parseLong(s.substring(0, i + 1));

            if (dfs(s, i + 1, first)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(String s, int index, long prev) {

    
        if (index == s.length()) {
            return true;
        }

        long num = 0;

        for (int i = index; i < s.length(); i++) {

            num = num * 10 + (s.charAt(i) - '0');

            // must be prev - 1
            if (num == prev - 1) {

                if (dfs(s, i + 1, num)) {
                    return true;
                }
            }

          
            if (num >= prev) {
                break;
            }
        }

        return false;
    }
}
