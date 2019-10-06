package Tree;//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
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
    public int[] findMode(TreeNode root) {

        // 找出所有节点
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root, map);

        //先找出map中出现最多的数到底出现了几次？
        int max = 0;
        for (int key : map.keySet())
            max = Math.max(max,map.get(key));

        // 判定哪些是众数，再加到数列中
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet())
            if (map.get(key) == max)
                list.add(key);

        // 返回需要的数据结构
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    private void dfs(TreeNode root, Map map){
        /**
         * 负责把点都加到map<root.val,出现次数>中
         * public V getOrDefault(Object key, V defaultValue) {
         *  Node<K,V> e;
         *  return (e = getNode(hash(key), key)) == null ? defaultValue : e.value;
         * }
         */
        if (root == null) return ;
        dfs(root.left, map);
        map.put(root.val,1+(int)map.getOrDefault(root.val,0));// 如果已经有这个root.val，就加一覆盖掉
        dfs(root.right, map);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
