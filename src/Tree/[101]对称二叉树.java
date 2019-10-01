package Tree;//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
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
    public boolean isSymmetric(TreeNode root) {
        // 一直进行左右比对
        if (root == null){
            return true;
        }
        // 此处如果传入的是root，root。比对次数会增加一倍
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode root,TreeNode root2){
        if (root == null || root2 == null){
            return root == root2;
        }
        return root.val == root2.val && isSymmetric(root.left,root2.right) && isSymmetric(root.right, root2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
