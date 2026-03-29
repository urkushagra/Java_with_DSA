import java.util.*;

class Solution {
    
    class DSU {
        int[] parent;
        
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        // Step 1: sort edges by distance
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        // Step 2: attach index to queries
        int q = queries.length;
        int[][] newQueries = new int[q][4];
        
        for (int i = 0; i < q; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i; // original index
        }
        
        Arrays.sort(newQueries, (a, b) -> a[2] - b[2]);
        
        // Step 3: DSU
        DSU dsu = new DSU(n);
        boolean[] result = new boolean[q];
        
        int i = 0; // edge pointer
        
        for (int[] query : newQueries) {
            int u = query[0], v = query[1], limit = query[2], idx = query[3];
            
            // Add all edges with distance < limit
            while (i < edgeList.length && edgeList[i][2] < limit) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            
            // Check connectivity
            result[idx] = (dsu.find(u) == dsu.find(v));
        }
        
        return result;
    }
}
