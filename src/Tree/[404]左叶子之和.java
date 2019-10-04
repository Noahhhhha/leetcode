package Tree;//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0; // 当前节点为null时
        int sum = 0;
        /**
         * 想判断一个点是不是左叶子节点，只能从其父辈判断
         * 当判断特殊情况的时候，这个特殊情况包含在普通情况之中，就考虑用一个场外值sum来解决吧
         */
        if (root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
