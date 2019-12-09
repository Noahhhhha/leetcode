//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        // 这数组得倒着看，倒着找最小递减序列
        // *找最长递减序列*
        // 2 1 7 5 4 3 的最小递减序列是 7 5 4 3
        // 将最长递减序列取逆序，2 1 3 4 5 7
        // 再将 3与1 交换
        int size = nums.length - 1;
        for (int i = size; i >=0; i--){
            if (i == 0) {
                reverse (nums, 0, size);
                return ;
            }
            if (nums[i] > nums[i - 1]){
                reverse (nums, i, size);
                for (int j = i; j < nums.length; j++) { // 这里要从i开始，找到一个比 i-1 大的数，然后交换
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        return;
                    }
                }
            }
        }
    }

    private void reverse (int[] nums, int start, int end){
        while (start < end){
            swap (nums, start++, end--);
        }
    }

    private void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
