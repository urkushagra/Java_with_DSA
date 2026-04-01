import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // Insert number into Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Get max XOR with x
    private int getMaxXor(int x) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int opposite = 1 - bit;

            if (node.children[opposite] != null) {
                maxXor |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }

        return maxXor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        int[][] qArr = new int[q][3];

        // Store queries with index
        for (int i = 0; i < q; i++) {
            qArr[i][0] = queries[i][0]; // x
            qArr[i][1] = queries[i][1]; // m
            qArr[i][2] = i;             // original index
        }

        // Sort queries by m
        Arrays.sort(qArr, (a, b) -> a[1] - b[1]);

        int[] result = new int[q];
        int idx = 0;

        for (int[] query : qArr) {
            int x = query[0];
            int m = query[1];
            int originalIndex = query[2];

            // Insert valid nums
            while (idx < nums.length && nums[idx] <= m) {
                insert(nums[idx]);
                idx++;
            }

            // If no number inserted
            if (idx == 0) {
                result[originalIndex] = -1;
            } else {
                result[originalIndex] = getMaxXor(x);
            }
        }

        return result;
    }
}
