//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for(String x : ss){
            sb.append(new StringBuilder(x).reverse()+" ");
        }
        return sb.toString().trim(); // trim()去除首位空格
    }
}
//leetcode submit region end(Prohibit modification and deletion)
