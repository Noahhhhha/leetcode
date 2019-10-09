package tree;//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。[待改]
//
// 示例 : 
//
// 
//输入:
//
//   1
//    \
//     3
//    /
//   2
//
//输出:
//1
//
//解释:
//最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 注意: 树中至少有2个节点。 
// Related Topics 树



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if (i != j){
                min = Math.min(Math.abs(list.get(i) - list.get(j)),min);
                }
            }
        }
        return min;
    }
    public void dfs(TreeNode root, List list){
        if (root == null) return ;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
