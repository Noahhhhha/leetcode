package linkedList;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 有两处重要的地方：
         *  1、当其中一个链表节点多于另一个链表时怎么办 —— 用0替代 int x = l1 == null ? 0 : l1.val;
         *  2、要创建新节点，是传 【相加值取余】 还是 【进位值】 —— 【相加值取余】
         *      如果用进位值的话，没办法解决链表末尾有0的问题
         *      相当于多一个节点，所以，先考虑新节点的值，再说进位
         */
        ListNode head = new ListNode(0);
        int carry = 0; // 进位的数
        ListNode pointer = head; // 指针，跟随进度走
        while(l1 != null || l2 !=null){
            int x = l1 == null ? 0 : l1.val; // ！！！
            int y = l2 == null ? 0 : l2.val; // ！！！
            int sum = x + y + carry;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10); // ！！！ 如果用进位值的话，没办法解决链表末尾有0的问题
            pointer = pointer.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 补充一个高位节点
        if (carry > 0) pointer.next = new ListNode(carry);
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
