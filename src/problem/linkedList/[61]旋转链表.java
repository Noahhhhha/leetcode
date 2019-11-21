//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newFirst = head;
        ListNode oldLast = head; // 用于先找到最后一个指针

        // 因为是循环链表，记录一下共有多少个元素，一会有个取余操作，避免多次循环
        int n;
        for(n = 1; oldLast.next != null; n++)
            oldLast = oldLast.next;
        oldLast.next = head; // 搞成循环链表

        // 找到新链尾，原先自己写的时候跑去找链头，增加了一些麻烦
        ListNode newLast = head;
        for (int i = 0; i < (n - (k % n)) - 1; i++){ // 记得取余，以长度为周期，因为要取尾巴，所以要在找到头节点的前一步停下
            newLast = newLast.next; // 找到新头节点的前一个
        }

        newFirst = newLast.next; // 他是头节点了
        newLast.next = null;
        return newFirst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
