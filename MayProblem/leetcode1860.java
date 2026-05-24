class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int time = 1;

        while (true) {
            // Check if allocation is possible
            if (memory1 < time && memory2 < time) {
                return new int[]{time, memory1, memory2};
            }

            // Allocate memory to the stick with more memory
            if (memory1 >= memory2) {
                memory1 -= time;
            } else {
                memory2 -= time;
            }

            time++;
        }
    }
}
