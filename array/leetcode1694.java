class Solution {
    public String reformatNumber(String number) {
        
        // Step 1: remove spaces and dashes
        StringBuilder digits = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        int n = digits.length();
        int i = 0;
        
        // Step 2: process blocks
        while (n - i > 4) {
            result.append(digits.substring(i, i + 3)).append("-");
            i += 3;
        }
        
        // Step 3: handle remaining digits
        if (n - i == 4) {
            result.append(digits.substring(i, i + 2)).append("-");
            result.append(digits.substring(i + 2, i + 4));
        } else {
            result.append(digits.substring(i));
        }
        
        return result.toString();
    }
}
