class Solution {

    public String maxValue(String n, int x) {

        char digit = (char)(x + '0');

        // Negative number
        if (n.charAt(0) == '-') {

            for (int i = 1; i < n.length(); i++) {

                // Insert before first digit greater than x
                if (n.charAt(i) - '0' > x) {
                    return n.substring(0, i)
                            + digit
                            + n.substring(i);
                }
            }

            return n + digit;
        }

        // Positive number
        else {

            for (int i = 0; i < n.length(); i++) {

                // Insert before first digit smaller than x
                if (n.charAt(i) - '0' < x) {
                    return n.substring(0, i)
                            + digit
                            + n.substring(i);
                }
            }

            return n + digit;
        }
    }
}
