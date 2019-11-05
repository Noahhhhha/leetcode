//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int preMax = 0; // n - 2 的位置
        int curMax = 0;
        for(int n : nums){
            int temp = curMax;
            // n = 1, max = n1
            // n = 2, max = max(n1,n2)
            // n = 3, 若取3，则curMax = dp(n1) + n3
            //        若不取，则保留现有的最大值 curMax = dp(n2)
            //        取与不取，取决于取了大，还是不取大
            curMax = Math.max(preMax + n, curMax);
            preMax = temp;
        }
        return curMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
