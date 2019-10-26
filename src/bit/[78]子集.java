//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++){
            // 排列组合的个数是2^n次方（n是元素个数）
            // 如果nums.length = 3
            // 首先全部的子集为【000】【001】【010】【100】【011】【101】【110】【111】
            // 1表示这一位的数字存在，例如 【010】 表示只含有 2
            // 由此发现子集所代表的二进制数全部小于 1 << 数组.length
            // 第一层循环
            // for (int i = 0; i < (1 << size); i++)
            // 然后根据【i】 的二进制数中 【1】 的位置取得子集
            List<Integer> list2 = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++){
                if (((i >> j) & 1) == 1) list2.add(nums[j]);
            }
            list.add(list2);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
