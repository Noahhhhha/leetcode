//给定一个二叉树，原地将它展开为链表。 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
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
    public void flatten(TreeNode root) {
        // root的右子树接到左子树的最右下角的节点上，右子树位置就可以为空了
        // root的左子树挂到原来的右子树位置
        // 将原左子树位置设为null
        // 循环
        while(root != null){
            if(root.left == null) root = root.right;
            else{
                TreeNode small = root.left; // 左子树的最右下角的节点上
                while(small.right != null){
                    small = small.right;
                }
                small.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
