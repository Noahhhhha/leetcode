package Tree;//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//[by 导包侠]
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。  22 = 5+4+11+2
// Related Topics 树 深度优先搜索



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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false; // 根节点可以为0，但不能为null
        sum -= root.val;
        if (root.left == null && root.right == null){ // 此为叶子节点
            return sum == 0;
        }
        // 只要左右子树有一个能返回true，就算成功
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
