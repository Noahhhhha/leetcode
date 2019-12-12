//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 这题跟走楼梯那道题类似, 1、2、5三种面额
        // coinNumber = min(dp[n - 1], dp[n - 2], dp[n - 5]) + 1,  coinNumber);
        // dp数组的下标就是当前amount是多少，动态规划解决
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++){
            // 当前用了几个硬币，初始值设个大数
            int n = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i)
                    if (dp[i - coins[j]] != Integer.MAX_VALUE)
                        n = Math.min(dp[i - coins[j]] + 1, n);
            }
            dp[i] = n;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
