class Solution {
public:
    int minimumCost(vector<int>& A) {
        int fq[101] = {0};
        int n = A.size(), res = 0, k = 0;

        for (auto& a : A) fq[a]++;

        for (int i = 1; i < 101; i++)
            for (int j = 0; j < fq[i]; j++)
                if (k++ % 3 != n % 3)
                    res += i;

        return res;
    }
};
