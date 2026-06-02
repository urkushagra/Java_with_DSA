class Solution {

    public int minOperationsToFlip(String expression) {
        Stack<int[]> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == '0') {
                nums.push(new int[]{0, 1});
            } else if (ch == '1') {
                nums.push(new int[]{1, 1});
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {

                while (ops.peek() != '(') {
                    calc(nums, ops.pop());
                }

                ops.pop();
            } else { // '&' or '|'

                while (!ops.isEmpty() && ops.peek() != '(') {
                    calc(nums, ops.pop());
                }

                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            calc(nums, ops.pop());
        }

        return nums.peek()[1];
    }

    private void calc(Stack<int[]> nums, char op) {

        int[] b = nums.pop();
        int[] a = nums.pop();

        int value;
        int cost;

        if (op == '&') {

            value = a[0] & b[0];

            if (a[0] == 1 && b[0] == 1) {
                cost = Math.min(a[1], b[1]);
            } else if (a[0] == 0 && b[0] == 0) {
                cost = Math.min(a[1] + b[1], Math.min(a[1], b[1]) + 1);
            } else {
                cost = 1;
            }

        } else {

            value = a[0] | b[0];

            if (a[0] == 0 && b[0] == 0) {
                cost = Math.min(a[1], b[1]);
            } else if (a[0] == 1 && b[0] == 1) {
                cost = Math.min(a[1] + b[1], Math.min(a[1], b[1]) + 1);
            } else {
                cost = 1;
            }
        }

        nums.push(new int[]{value, cost});
    }
}
