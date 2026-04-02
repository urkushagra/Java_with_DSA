import java.util.*;

class Solution {
    public int minOperations(int[] target, int[] arr) {

        // Step 1: map target values to indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        // Step 2: build mapped array
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            if (map.containsKey(x)) {
                list.add(map.get(x));
            }
        }

        // Step 3: find LIS
        List<Integer> lis = new ArrayList<>();

        for (int num : list) {
            int idx = Collections.binarySearch(lis, num);

            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) {
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }

        // Step 4: result
        return target.length - lis.size();
    }
}
