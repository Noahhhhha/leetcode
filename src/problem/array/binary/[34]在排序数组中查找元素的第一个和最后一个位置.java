//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums = null;
    int[] res = new int[]{-1, -1};
    int target = 0;
    public int[] searchRange(int[] nums, int target) {
        // 设置flag，先找到最左侧的点，再找到最右侧的点
        if (nums.length == 0) return res;
        if (nums.length == 1) return nums[0] == target ? new int[]{0,0} : res;
        this.nums = nums;
        this.target = target;

        int size = nums.length - 1;
        binary(0, size, true);
        binary(0, size, false);

        return res;
    }

    private void binary(int low, int high, boolean flag){
        /**
         * 1. 为什么 while 循环的条件中是 <=，而不是 < ？
         * 答：因为初始化 right 的赋值是 nums.length-1，即最后一个元素的索引，而不是 nums.length。
         * 这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间 [left, right]，后者相当于左闭右开区间 [left, right)，因为索引大小为 nums.length 是越界的。
         * 我们这个算法中使用的是前者 [left, right] 两端都闭的区间。这个区间其实就是每次进行搜索的区间，我们不妨称为「搜索区间」。
         */
        if (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < target)
                binary(mid + 1, high, flag);
            else if (nums[mid] > target)
                binary(low, mid - 1, flag);
            else { // 重点
                if (flag){
                    res[0] = mid;
                    binary(low, mid - 1, flag);
                }else {
                    res[1] = mid;
                    binary(mid + 1, high, flag);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
