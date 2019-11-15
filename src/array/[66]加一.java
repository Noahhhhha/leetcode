//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        // 本来用的方法是先转换成一个完整的数字进行计算
        // 不过会出现int值越界的情况
        // 加1的情况跟别的数相加还不太一样，因为加一之后，当前位只有两种情况，为0，或不为0
        for (int i = digits.length - 1; i >= 0; i--){
            // 这种解法巧妙的规避了进位的问题，你到了当前位置
            // 说明肯定是有进位的，只要当前位+1之后不等于0，说明就没有进位的问题，直接return即可
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        // 走到这一步了，说明就是要扩容了，后面的位数默认为0
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
