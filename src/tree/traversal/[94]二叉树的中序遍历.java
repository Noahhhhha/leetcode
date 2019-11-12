//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表



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
/**
 * 更优美的利用栈
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}



/**
 * 利用栈，非递归
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)  return list;
        Stack<TreeNode> stack = new Stack<>();

        // 将根节点及其左节点都压进去
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            // 把顶层节点取出来，并将它作为根节点，存储其值，并再考虑他的右节点
            TreeNode node = stack.pop();
            list.add(node.val);
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }

        return list;
    }
}

/**
 * 递归
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    private void helper(TreeNode root){
        if(root == null) return ;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
