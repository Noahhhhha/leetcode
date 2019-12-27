//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> list = null;
    int[] candidates = null;
    int len = 0;

    // 递归回溯，利用了栈

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.len = candidates.length;
        this.list = new ArrayList<>();
        if (len == 0) return list;

        Arrays.sort(candidates);
        this.candidates = candidates;

        helper(0, target, new Stack<Integer>());
        return list;
    }

    private void helper(int start, int remains, Stack s){

        if (remains == 0){
            list.add(new ArrayList(s));
            return ;
        }

        // i不停往数组后面走，避免了list重复
        // 数组已经排序好了，由小到大

        for (int i = start; i < len && remains - candidates[i] >= 0; i++){
            s.add(candidates[i]);

            // 从i开始，是因为每个数可以重复使用

            helper(i, remains - candidates[i], s);
            s.pop(); // 用完踢回去
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
