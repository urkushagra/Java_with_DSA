class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder inside = stack.pop();
                inside.reverse();
                stack.peek().append(inside);
            } else {
                stack.peek().append(c);
            }
        }

        return stack.peek().toString();
    }
}
