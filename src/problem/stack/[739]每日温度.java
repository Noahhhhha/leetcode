//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 栈
 * 【逆序遍历】，如果前面的数比栈顶小，直接加入栈
 * 如果比栈顶大，栈顶pop，再把当前数压入栈
 * 因为对于前面的数(1)来说，(2)如果比(3)大，(3)就对(1)没影响
 * &&才具有短路功能
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--){
            while(!s.isEmpty() && T[i] >= T[s.peek()]) s.pop();
            res[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }
}

/**
 * 暴力法
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++){
            for (int j = i; j < T.length; j++){
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

