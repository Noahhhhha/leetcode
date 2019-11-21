//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 本来以为是双指针问题，但是没算出来
        // 经典位运算题
        // 1、数字转换成二进制，任何数和 0 XOR 都得其本身
        // 2、相同数字的二进制 XOR 得 0
        // 3、XOR满足交换律，即可以看作相同的数字放到一起XOR
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
