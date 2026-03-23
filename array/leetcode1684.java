class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        boolean[] allowedMap = new boolean[26];
        
        // Mark allowed characters
        for (char ch : allowed.toCharArray()) {
            allowedMap[ch - 'a'] = true;
        }
        
        int count = 0;
        
        // Check each word
        for (String word : words) {
            boolean isValid = true;
            
            for (char ch : word.toCharArray()) {
                if (!allowedMap[ch - 'a']) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) count++;
        }
        
        return count;
    }
}
