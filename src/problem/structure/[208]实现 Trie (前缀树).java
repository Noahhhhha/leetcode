//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树



//leetcode submit region begin(Prohibit modification and deletion)
class TreeNode{
    TreeNode[] childs;
    boolean is_end;

    TreeNode(){
        childs = new TreeNode[26];
        is_end = false;
    }
}

class Trie {
    TreeNode root; // 记录根节点，方便后面查找

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode pre = root; // 每次都从根节点开始
        // 根据单词长度for循环构建
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i); // 当前字母
            int index = c - 'a';
            if (pre.childs[index] == null)
                pre.childs[index] = new TreeNode();
            pre = pre.childs[index]; // 重定向到子树
        }
        // 结束循环之后，is_end赋值为true
        pre.is_end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode pre = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i); // 当前字母
            int index = c - 'a';
            if (pre.childs[index] == null)
                return false;
            pre = pre.childs[index]; // 重定向到子树
        }
        return pre.is_end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // 不需要看is_end的脸色
        TreeNode pre = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i); // 当前字母
            int index = c - 'a';
            if (pre.childs[index] == null)
                return false;
            pre = pre.childs[index]; // 重定向到子树
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
