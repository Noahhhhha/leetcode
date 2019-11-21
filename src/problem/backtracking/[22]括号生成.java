//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 刚做这道题的时候跟20题有点混淆，查看后发现完全不是一回事。
        helper("", 0, 0, n);
        return list;
    }

    private void helper(String str, int open, int close, int max){
        if (str.length() == max*2) list.add(str);
        if (open < max) helper(str+"(", open+1, close, max);
        // 关键点在于判定哪种情况下，序列递归没有意义了
        // 答：当右括号数大于左括号数时，序列就为无效了
        // 所以 close 不能大于open
        if (close < open) helper(str+")", open, close+1, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
