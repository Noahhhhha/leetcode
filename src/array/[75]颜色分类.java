//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针


/**
 * 一遍扫描
 */
class Solution {
    public void sortColors(int[] nums) {
        // 这道题的关键地方不是排序解，而是确定左边 0 元素的边界
        // 还有右边 2 的边界
        // 这套解法保证了一次扫描，空间复杂度为1
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while(cur <= p2){
            // p2 指的是边界前面那个数
            if (nums[cur] == 0)
                swap(nums, p0++, cur++);
            else if(nums[cur] == 2)
                swap(nums, p2--, cur);
                // 因为cur是自左向右扫描的，0都在左边堆着，所以不管这个数是什么，cur都要向后走，给0挪位置，或者向后继续扫描，但是当cur为2的时候，2都在右边堆着，不影响cur，所以cur不需要动
            else cur++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];;
        nums[j] = temp;
    }
}

/**
 * 两遍扫描
 */
class Solution {
    public void sortColors(int[] nums) {
        // 红色 - 0，白色 - 1， 蓝色 - 2
        int red = 0, white = 0, blue = 0;
        for(int n : nums){
            switch (n) {
                case 0 : red += 1;break;
                case 1 : white += 1; break;
                case 2 : blue += 1;break;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if(i < red) nums[i] = 0;
            else if(i >= red && i < nums.length - blue) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
