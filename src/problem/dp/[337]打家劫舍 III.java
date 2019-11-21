//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
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
    public int rob(TreeNode root) {
        /**
         * 由列表转树了，结构上变难了，但是思想没变
         * 还是得考虑dp公式，分两种情况
         * 1、偷了当前节点，则还可以偷左右子节点的节点
         * 2、只偷了左右子节点
         * 递归！
         */
        if (root == null) return 0;
        int maxLeft = rob(root.left);
        int maxRight = rob(root.right);
        int maxLeftLeft = 0;
        int maxLeftRight = 0;
        int maxRightLeft = 0;
        int maxRightRight = 0;
        if (root.left != null){
            maxLeftLeft = rob(root.left.left);
            maxLeftRight = rob(root.left.right);
        }
        if (root.right != null){
            maxRightLeft = rob(root.right.left);
            maxRightRight = rob(root.right.right);
        }
        return Math.max(root.val + maxLeftLeft + maxLeftRight + maxRightLeft + maxRightRight,
                        maxLeft + maxRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
