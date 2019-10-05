package Tree;//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
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
    public int pathSum(TreeNode root, int sum) {
        /**
         * 这道题要用双递归，要让每个节点都重新来过
         */
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int helper(TreeNode root,int sum){
        if (root == null) return 0;
        /**
         * 这里要让sum跟root.val对比，而不是0
         * 要考虑当前节点是不是终结点，如果节点值与sum值相同，自身一个点就是一个路径
         */
        return (sum == root.val ? 1 : 0) + helper(root.left, sum-root.val) + helper(root.right, sum-root.val);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
