//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return list;
        else {
            helper(nums, new Stack<Integer>());
            return list;
        }
    }
    private void helper(int[] nums, Stack<Integer> stack){
        // 终止条件
        if (stack.size() == nums.length) {
            list.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int num:nums){
            if (stack.contains(num)) continue;
            stack.push(num);
            helper(nums, stack); // 自身又加上了一个数以后进入下一层栈构造
            stack.pop(); //  把刚才加进来的弹出去，自己又是一个崭新的容器，等待下一个数进来
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
