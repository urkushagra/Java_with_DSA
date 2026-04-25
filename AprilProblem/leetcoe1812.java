class Solution {
    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a' + 1; // a→1, b→2...
        int row = coordinates.charAt(1) - '0';     // '1'→1, '2'→2...

        return (col + row) % 2 == 1;
    }
}
