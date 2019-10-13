//在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。 
//
// 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。 
//
// 返回可以通过分割得到的平衡字符串的最大数量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "RLRRLLRLRL"
//输出：4
//解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 2： 
//
// 输入：s = "RLLLLRRRLR"
//输出：3
//解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 3： 
//
// 输入：s = "LLLLRRRR"
//输出：1
//解释：s 只能保持原样 "LLLLRRRR".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] = 'L' 或 'R' 
// 
// Related Topics 贪心算法 字符串
//leetcode submit region begin(Prohibit modification and deletion)

// 一个数表示L+R的数量
class Solution {
    public int balancedStringSplit(String s) {
        int sum = 0, res = 0;
        for (char c : s.toCharArray()){
            if (c == 'L') sum++;
            else sum--;
            if (sum == 0){
                res++;
            }
        }
        return res;
    }
}

// 两个数分别表示L和R
class Solution {
    public int balancedStringSplit(String s) {
        int L = 0, R = 0, res = 0;
        for (char c : s.toCharArray()){
            if (c == 'L') L++;
            else R++;
            if (L > 0 && L == R){
                L = 0;
                R = 0;
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
