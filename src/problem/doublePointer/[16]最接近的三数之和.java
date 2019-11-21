//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 双指针
        Arrays.sort(nums); // 排序过后，左边小，右边大
        int ans = nums[0] + nums[1] + nums[2]; // 随便找三个数，并求和
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){ // 防止越界
                int res = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - res) < Math.abs(target - ans)) ans = res;
                if (res > target) end--;
                else start++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
