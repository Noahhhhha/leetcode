//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        // 在二进制里，如果不考虑进位，异或 ^ 可以当作加减法
        // & 可以做为进位值，左移一位就可以当作真正的进位值
        while(b != 0){ // 当进位值为0的时候，就不需要再计算了
            int temp = (a & b) << 1; // 算出进位值
            a = a ^ b; // 算出每一位上的值
            b = temp;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
