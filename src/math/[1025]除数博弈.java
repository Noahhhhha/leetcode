//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。 
//
// 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作： 
//
// 
// 选出任一 x，满足 0 < x < N 且 N % x == 0 。 
// 用 N - x 替换黑板上的数字 N 。 
// 
//
// 如果玩家无法执行这些操作，就会输掉游戏。 
//
// 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
// 
//
// 示例 2： 
//
// 输入：3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// 
// Related Topics 数学 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean divisorGame(int N) {
        // 事实上，无论 N 为多大，最终都是在 N = 2 这个临界点结束的。谁最后面对的是 N = 2 的情形，谁就能获胜（这句话不太理解的话，仔细看看 N = 2、N = 3 这两种情形）。
        // 接下来，我们得知道一个数学小知识：奇数的因子（约数）只能是奇数，偶数的因子（约数）可以是奇数或偶数。
        // 也就是说，当面对奇数的时候，只能减去一个奇数，在数学中一定等于一个偶数
        // 千万不要忽略 1 也是因子！
        return (N & 1) != 1;
        //这道题还可以用动态规划写
    }
}
//leetcode submit region end(Prohibit modification and deletion)
