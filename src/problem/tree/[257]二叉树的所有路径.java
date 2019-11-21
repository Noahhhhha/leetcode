package tree;//给定一个二叉树，返回所有从根节点到叶子节点的路径。[by 导包侠]
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
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
    public List<String> binaryTreePaths(TreeNode root) {
        /**
         * java是引用传递。。。
         * 递归还是应该从特殊情况往一般情况写
         */
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        String path = "";
        helper(root, path, list);
        return list;
    }
    private void helper(TreeNode root,String path,List list){
        // 先把特殊情况考虑了
        if (root == null) return; // 这种情况属于其父节点有一个方向上的子树，比如，其父节点只有左子树，则这个null节点为右子树
        if (root.left == null && root.right == null) { // 当为叶子节点时
            path += root.val;
            list.add(path);
        }

        // 接下来的就是普通节点了
        path += root.val + "->";
        helper(root.left, path, list);
        helper(root.right, path, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
