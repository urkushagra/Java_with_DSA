class Solution {

    public int getMinSwaps(String num, int k) {

        char[] original = num.toCharArray();

        char[] target = num.toCharArray();

        // generate kth permutation
        while (k-- > 0) {
            nextPermutation(target);
        }

        int swaps = 0;

        char[] current = original.clone();

        for (int i = 0; i < current.length; i++) {

            // already correct
            if (current[i] == target[i]) {
                continue;
            }

            int j = i;

            // find matching digit
            while (current[j] != target[i]) {
                j++;
            }

            // bring it left using adjacent swaps
            while (j > i) {

                char temp = current[j];
                current[j] = current[j - 1];
                current[j - 1] = temp;

                swaps++;
                j--;
            }
        }

        return swaps;
    }

    // standard next permutation
    private void nextPermutation(char[] arr) {

        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);

        reverse(arr, i + 1, arr.length - 1);
    }

    private void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {

            swap(arr, left, right);

            left++;
            right--;
        }
    }
}
