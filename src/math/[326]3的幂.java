//给定一个整数，写一个函数来判断它是否是 3 的幂次方。 
//
// 示例 1: 
//
// 输入: 27
//输出: true
// 
//
// 示例 2: 
//
// 输入: 0
//输出: false 
//
// 示例 3: 
//
// 输入: 9
//输出: true 
//
// 示例 4: 
//
// 输入: 45
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 数学



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        /**
         * 因为3是质数以及考虑到int的取值范围，所以我们只需要考虑3的19次方能不能整除int n就行
         * 3的19次方，除数只有3的一次方到3的19次方
         */
        return n > 0 && 1162261467 % n == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
