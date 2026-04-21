class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int num = ch - '0';

                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }

        return second;
    }
}
