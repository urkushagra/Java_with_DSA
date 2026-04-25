import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: build map
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        // Step 2: parse string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                insideBracket = true;
                key.setLength(0); // reset key
            } else if (ch == ')') {
                insideBracket = false;
                String k = key.toString();
                result.append(map.getOrDefault(k, "?"));
            } else {
                if (insideBracket) {
                    key.append(ch);
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
