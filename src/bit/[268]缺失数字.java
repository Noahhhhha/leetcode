//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 异或位运算
 */
class Solution {
    public int missingNumber(int[] nums) {
        // 这道题对时间复杂度有要求，为线性，所以不做排序了，除了hash表以外，还可以做位运算异或，异或满足交换律，所以最后生下来的一定是单独的那一个数
        // 这道题还可以用高斯求和公式，减去nums中的数，剩下的就是missing
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

/**
 * hash表
 */
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length + 1; i++){
            if(!set.contains(i)){
                res = i;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
