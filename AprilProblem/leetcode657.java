class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0; // counts R and L
        int vertical = 0;   // counts U and D

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U': vertical++; break;
                case 'D': vertical--; break;
                case 'R': horizontal++; break;
                case 'L': horizontal--; break;
            }
        }

        // Robot returns to origin if horizontal and vertical movements cancel out
        return horizontal == 0 && vertical == 0;
    }
}
