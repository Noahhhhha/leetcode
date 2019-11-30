//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        // 字母标题
        int[] alpha = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> l = new ArrayList<>();
        for (String s : words){
            String t = s.toUpperCase();
            int pre = alpha[t.charAt(0) - 'A'];
            boolean f = true;
            for (int i = 1; i < s.length(); i++){
                if (alpha[t.charAt(i) - 'A'] != pre) {
                    f = false;
                    break;
                }
            }
            if (f == true) l.add(s);
        }
        return l.toArray(new String[l.size()]);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

