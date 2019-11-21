//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        /**
         * 打家劫舍三部曲：198（单列表）、213（循环列表）、337（树）
         * 此题是198打家劫舍的拓展版： 唯一的区别是此题中的房间是环状排列的（即首尾相接），
         * 而198题中的房间是单排排列的；而这也是此题的难点。
         * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：
         * 1、在不偷窃第一个房子的情况下（即 nums[1:]nums[1:]），最大金额是 p_1p
         * 2、在不偷窃最后一个房子的情况下（即 nums[:n-1]nums[:n−1]），最大金额是 p_2p
         * 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)max(p1,p2) 。
         * 下面的任务则是解决 单排排列房间（即 198. 打家劫舍） 问题。推荐可以先把 198.198. 做完再做这道题。
         */
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        /**
         * Arrays.copyOfRange(T[ ] original,int from,int to)
         * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
         * 注意这里包括下标from，不包括上标to。
         */
        return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)), helper(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int helper(int[] nums){
        int preMax = 0;
        int curMax = 0;
        for(int n : nums){
            int temp = curMax;
            curMax = Math.max(preMax + n, curMax);
            preMax = temp;
        }
        return curMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
