//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        /**
         * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
         * 第 i 阶可以由以下两种方法得到：
         * 在第(i−1) 阶后向上爬 1 阶。
         * 在第(i−2) 阶后向上爬 2 阶。
         * 所以到达第 i 阶的方法总数就是到第(i−1)阶和第(i−2)阶的方法数之和。
         * 令 dp[i]表示能到达第 i 阶的方法总数：
         * dp[i]=dp[i-1]+dp[i-2]
         */
        if (n == 1) {
            return 1; // 如果只有一个数，后面数组会越界
        }
        // 动态规划法

        int[] dp = new int[n+1]; // 为了容易解决,包含第0阶，从0阶到第n阶，共 n+1 个数
        dp[1] = 1; // 从0层 到 1层只有一种走法
        dp[2] = 2; // 从0层 到 第2层有两种走法

        for(int i = 3; i < dp.length; i++){ // dp.length == n+1
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

/**
 * 暴力法，类似于二叉树求总和，时间复杂度n^2
 */
public class Solution {
    public int climbStairs(int n) {
        climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}

/**
 * 暴力法改良版，加一个记忆数组
 */
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
