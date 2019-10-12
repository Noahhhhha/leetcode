package stack;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


/**
 * 栈  写法
 * 当括号为左括号时，就压入栈，是右括号，就匹配栈顶元素，
 * 新进来的右括号必须跟栈顶元素匹配上!!!才算对，否则，直接返回false
 */
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new LinkedList<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return helper(s,map,stack);
    }
    private boolean helper(String s, Map<Character, Character> map, Deque<Character> stack){
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (map.containsKey(cur)){
                char peek = stack.isEmpty() ? '#' : stack.pop();
                if (map.get(cur) != peek){
                    return false;
                }
            }else{
                stack.push(cur);
            }

        }
        return stack.isEmpty();
    }
}

/**
 * 消消乐解法
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        while(s.contains("{}") || s.contains("[]") || s.contains("()")){
            if (s.contains("{}")) s = s.replace("{}","");
            if (s.contains("[]")) s = s.replace("[]","");
            if (s.contains("()")) s = s.replace("()","");
        }
        return s.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
