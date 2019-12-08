//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        // 因为负数的原因，长期积累的最小值可能突然成为大佬，所以也需要记录
        // imax记录的是局部最优，max记录的是全局的
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++){
            // 如果遇到负数，最大值和最小值就会对调
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // 包括0在内，考虑乘完之后的结果是否变大
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(imax, max);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
