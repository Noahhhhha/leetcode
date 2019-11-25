//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 1、三次反转法
 * 2、新数组直接区间赋值法
 * 3、暴力法
 * 这道题应该还有一个环状替代法，有点费劲，回头再补上。
 */

// 1、三次反转法
class Solution {
    public void rotate(int[] nums, int k) {
        // 参考b站av75206872 三次反转 AB -> (A^B^)^ = BA
        int n = nums.length;
        k %= n;
        reverse(nums, n - k, n - 1); // 4, 6
        reverse(nums, 0, n - k - 1); // 0, 3
        reverse(nums, 0, n - 1); // 0, 6

    }

    private void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
// 2、新建数组法
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        k %= n;
        int j = 0;
        for (int i = n - k; i < n; i++){ // n - i 倒数第k个数
            arr[j++] = nums[i];
        }
        for (int i = 0; i < n - k; i++){
            arr[j++] = nums[i];
        }
        int p = 0;
        for (int i = 0; i < n; i++){
            nums[p++] = arr[i];
        }
    }
}

// 3、暴力法
class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++){ // 要旋转多少步
            // [1,2,3,4]
            // 1: previous = 4
            // 2: 4 和 1 交换，previous赋值1
            // 3: 2 和 1交换 ， previous复制 2
            int previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
