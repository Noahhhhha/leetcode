//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        // 中心扩展算法
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int length1 = expend(s,i,i);
            int length2 = expend(s,i,i+1);
            int len = Math.max(length1, length2);

            if (len > end - start) {
                // 屏蔽奇偶的写法
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int expend(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 注意减1
        return right - left - 1 ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
