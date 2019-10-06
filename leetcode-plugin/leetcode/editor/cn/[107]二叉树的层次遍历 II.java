//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
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
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> list = new LinkedList<>(); // 最终提交的东西
        List<Integer> intList = null; // 树中每一行的节点数组
        Queue<TreeNode> q = new LinkedList<TreeNode>(); // 队列
        q.offer(root); // 提交根节点到队列中
        while (!q.isEmpty()){
            int len = q.size(); // 获取当前队列元素数量，即树每一行的数量
            intList = new LinkedList<>(); // 建立树中每一行的数字数组
            int i = 0; // 用来记录每一行的节点有多少
            while (i<len){ // 对队列中的元素进行遍历，即对树的这一行的元素进行遍历
                TreeNode t = q.poll(); // 取出队列的第一个元素
                intList.add(t.val);// 把它加到这一行的数字数组中
                if (t.left != null){ // 左孩子加到队列中
                    q.add(t.left);
                }if (t.right != null){ // 右孩子加到队列中
                    q.add(t.right);
                }
                i++;
            }
            ((LinkedList<List<Integer>>)list).addFirst(intList);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
