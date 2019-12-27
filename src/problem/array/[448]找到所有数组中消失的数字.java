//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 此题鸽巢原理，每只鸽子到自己该到的巢
        int size = nums.length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < size; i++){
            // 此处注意这个while，如果不是while，可能换过来的元素就有可能错过
            // nums[nums[i] - 1] 表示nums[i] 这个数真正相待的坑， 其坑中数 是不是 等于这个数
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }

        // 检查，如果不在自己该在的巢里，这巢里就不是正确的数，就是少的那个数
        for (int i = 0; i < size; i++){
            if (nums[i] != i + 1)
                res.add(i + 1);
        }

        return res;
    }

    // 不用第三方变量就可以交换
    // a ^ b = c , c ^ b = a , c ^ a = b
    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
