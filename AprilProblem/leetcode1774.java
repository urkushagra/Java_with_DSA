class Solution {
    int result = Integer.MAX_VALUE;
    int target;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;

        for (int base : baseCosts) {
            dfs(toppingCosts, 0, base);
        }

        return result;
    }

    private void dfs(int[] toppings, int index, int currentCost) {
        // Update result
        if (Math.abs(currentCost - target) < Math.abs(result - target) ||
           (Math.abs(currentCost - target) == Math.abs(result - target) && currentCost < result)) {
            result = currentCost;
        }

        // Stop conditions
        if (index == toppings.length) return;

        // Pruning
        if (currentCost > target && currentCost > result) return;

        // 3 choices: 0, 1, 2
        dfs(toppings, index + 1, currentCost);
        dfs(toppings, index + 1, currentCost + toppings[index]);
        dfs(toppings, index + 1, currentCost + 2 * toppings[index]);
    }
}
