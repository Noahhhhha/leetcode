package tree.bst;//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
//
// 例如： 
//
// 
//输入: 二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
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

// 利用搜索二叉树的特性，right -> root -> left的顺序递归，将右节点加到自己身上。
// 左子树要加的树等于它根加右子树。先递归根，所以根已经把右子树加上了，所以左子树直接加根就行了
class Solution {
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += add;
        add = root.val;
        convertBST(root.left);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 利用搜索二叉树的特性，right -> root -> left的顺序递归，将右节点加到自己身上。
// 左子树要加的树等于它根加右子树。先递归根，所以根已经把右子树加上了，所以左子树直接加根就行了
class Solution {
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += add;
        add = root.val;
        convertBST(root.left);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
