// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) where n is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int r = costs.length;
        int c = costs[0].length;
        int[][] dp = new int[r][c];

        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        /*
         * [[17,2,17],
         * [2,17,2],
         * [14,3,19]]
         * 
         * 
         */

        for (int i = 1; i < r; i++) { // houses
            dp[i][0] += costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[r - 1][0], Math.min(dp[r - 1][1], dp[r - 1][2]));
    }

    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        int[][] costs = { { 17, 2, 17 }, { 2, 17, 2 }, { 14, 3, 19 } };
        System.out.println(ph.minCost(costs)); // Output: 10
    }
}
