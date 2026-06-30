class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // count[0]=a, count[1]=b, count[2]=c
        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            // Shrink window while it contains all a, b, c
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += (n - right);
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}
