//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 不管是递归法还是迭代法，关键的点就是层数问题，层数是纽带的关键
 */
class Solution {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level){
        if (levels.size() == level) levels.add(new ArrayList<Integer>());
        // 比如第一层，level传进来的是0，levels.size也是0
        // 第二层，level传进来的是1，左孩子进来的时候，levels.size是1，右孩子进来的时候levels.size是2了，所以右孩子不会新创建一个列表
        levels.get(level).add(root.val);
        if (root.left != null) helper(root.left, level + 1);
        if (root.right != null) helper(root.right, level + 1);
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        /**
         * 一开始没有想到设置层数变量，以为队列拉取和添加子节点可以很容易的同时完成
         * ，但是实践之后发现不行，可以通过层数，list.get得到后续节点
         */
        while(!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());
            int curLevelSize = queue.size(); // 记录当前层长度
            for (int i = 0; i < curLevelSize; i++){
                TreeNode node = queue.poll();
                levels.get(level).add(node.val); // 当前层加入新节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }

        return levels;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
