package Tree;//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
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
    public TreeNode sortedArrayToBST(int[] nums) {
        /**
         * 二叉搜索树有以下特点：
         *  若他的左子树不为空，则左子树上所有节点的值都小于根节点的值
         *  若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
         *  它的左右子树也分别是二叉搜索树
         *  没注意前两条，倒是也通过了=。=
         * 平衡：
         *  每个节点的左右子树都高度差在1以内
         * 因此思路如下：
         *  取数组中间的数作为根，递归
         */
        if (nums.length == 0){
            return null;
        }
        int midIndex = (nums.length-1)/2; // 取数组中间的那个下标

        TreeNode t = new TreeNode(nums[midIndex]);
        t.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex)); //Arrays.copyOfRange不包含上界
        t.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex+1, nums.length));

        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
