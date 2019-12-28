//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = null;
    Map<String, String> map = new HashMap<>();
    String digits = "";
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits == "" || digits.length() == 0) return list;
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        this.digits = digits;
        helper("", digits);
        return list;
    }

    private void helper(String already, String leaveDigits){
        if (leaveDigits.length() == 0)
            list.add(already);
        else{
            String string = map.get(leaveDigits.substring(0,1));
            for (int i = 0; i < string.length(); i++){
                helper(already + string.charAt(i), leaveDigits.substring(1,leaveDigits.length()));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
