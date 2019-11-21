package math;//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


// 只需要翻转一半就拿去跟原始的前半段比较即可
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false; // x如果小于0 或者 x末位是0（不包含0） 则必定不是回文
        int revertedNumber = 0;
        while(x > revertedNumber) { // 判定只转一半即可，但是奇数的话，会多翻转一位，但是后期 return 时会搞定
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;   // 偶数情况 || 奇数情况
    }
}


// 原始写法，但是没必要，因为没必要把整个数字都转过来，只需要转一半就拿去跟原始的前半段比较即可
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false; // x如果小于0 或者 x末位是0（不包含0） 则必定不是回文
        int rev = 0, org = x;
        while (x > 0){
            rev = rev * 10 + x % 10; // 取x的个位加到cur身上
            x /= 10; // 去掉个位
        }
        return org == rev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
