package dp;//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划题目
        int max = nums[0];
        int sum = 0; // max是题目要求的返回值，sum是这几天的和
        for (int i = 0; i < nums.length; i++){
            if (sum > 0){ // sum是当前几天的和，如果sum>0,说明对结果是有增益的
                sum += nums[i];
            }else{
                // 选择性遗忘的赌徒，如果之前几天都是亏钱的话，就从新的一天开始计算，永不亏钱系列
                sum = nums[i];
            }
            // 与最大值进行比较，就算天天亏钱，我也只记亏的最少的那天
            max = Math.max(sum, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
