//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 递归
class Solution {
    public ListNode reverseList(ListNode head) {

    }
}

// 迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
         * 再反转的过程中要记录下当前节点的前一个和后一个,
         * 因为在反转的过程中，前后指针都会变
         */
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next; // 存储下一个节点的指针
            cur.next = pre; // 指针反转！！！
            // 开始为下一个节点考虑
            pre = cur; // 下一个节点的前指针指向当前指针
            cur = next; // 当前指针切换为下一个节点
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
