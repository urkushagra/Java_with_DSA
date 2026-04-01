class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // Sort by units per box (descending)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            int boxesToTake = Math.min(truckSize, numberOfBoxes);

            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;

            if (truckSize == 0) break;
        }

        return totalUnits;
    }
}
