//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
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
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 关键步骤：左中右三个节点中有两个是所求节点，即当前节点就是要的节点
        // 采用后序遍历
        dfs(root, p, q);
        return res;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int mid = root == p || root == q ? 1 : 0;
        if (left + right +mid >= 2) res = root; // 两个找齐了
        return left + right + mid > 0 ? 1 : 0; // 只要有一个节点是，就告知上方的节点有1的情况
        // 如果已经找齐了，往上返回1，他们之后的共同父节点只能接受的到1
        // 所以即使上面还有共同父节点，但是因为无法>=2,所以不会再覆盖掉res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
