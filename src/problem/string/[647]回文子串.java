//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        // 因为是同一个字符串，所以dp只用看上半部三角形就可以了
        // dp方程：dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]
        int result = 0;
        int size = s.length();
        boolean[][] dp = new boolean[size][size];

        // 自左向右，一列一列自底向上的比较，因为根据dp方程，当前结果取决于左下角的位置
        for (int j = 0; j < size; j++){
            for (int i = j; i >= 0; i--){
                // 判断左下角的点是否是回文（子串掐头去尾），j - i < 2 表示两个字符是邻近的，也包扩自己跟自己比的情况，就不用看它的子串了
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    result ++;
                }

            }
        }
        return result;
    }
}

class Solution {
    public int countSubstrings(String s) {
        // 中心开花
        if (s == null || s.length() ==0) return 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++){
            result += helper(s, i, i);
            result += helper(s, i, i+1);
        }

        return result;
    }

    private int helper(String s, int start, int end){
        int result = 0;

        while (start >= 0 && end < s.length() && s.charAt(start--) == (s.charAt(end++))){
            result++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
