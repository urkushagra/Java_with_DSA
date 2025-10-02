📌 What is DP?
Dynamic Programming is a method to solve problems by breaking them into smaller subproblems, solving each subproblem once, and storing the results to avoid repeated computation.
It is essentially recursion + memory optimization.

📌 Key Properties
Optimal Substructure → The solution of a problem can be built using solutions of its subproblems.
Example: fib(n) = fib(n-1) + fib(n-2)
Overlapping Subproblems → The same subproblems appear multiple times in recursion.
Example: fib(3) is recalculated many times.

📌 Approaches
Top-Down (Memoization): Start with recursion, store results in an array/map.
Bottom-Up (Tabulation): Build the solution iteratively from the base case up.

📌 Prerequisites
Before learning DP, you should be comfortable with:
Recursion (base cases, recursion tree)
Arrays & Strings (to store results)
Basic Mathematics (sequences, patterns)
Problem-Solving Mindset (recognizing when DP is useful)

📌 Learning Path
Beginner Problems: Fibonacci, Factorial, Climbing Stairs
1D DP: Coin Change, House Robber, Longest Increasing Subsequence
2D DP: Knapsack, Minimum Path Sum, Unique Paths
String DP: Longest Common Subsequence, Edit Distance, Palindrome problems
Advanced: DP on Trees, Graphs, Bitmask DP

✅ DP in a Nutshell:
Define the state → Find recurrence → Set base case → Implement with Memoization/Tabulation.
