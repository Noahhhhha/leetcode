package Tree;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索



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
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){ // 如果左右子树都为空，就别递归算了
            return 1;
        }
        /**
         * 最小深度与最大深度最大的不同点就在于min会取0，所以对于[1,2]这个例子，
         * 根节点会返回 1+0，这个零是右孩子。
         * 所以当一个孩子为null的时候，我们不能像求最大深度一样那么写。
         * 错误写法：1 + Math.min(minDepth(root.left),minDepth(root.right))
         */
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left+right+1:Math.min(left,right)+1; // 当左孩子或者右孩子有一个不存在的时候，left或right就有一个为0，相加也无妨
    }
}
//leetcode submit region end(Prohibit modification and deletion)
