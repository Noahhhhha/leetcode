//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
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
    public boolean isPalindrome(ListNode head) {
        // 核心思想，快指针以两倍于满指针的速度，当快指针走完的时候，慢指针刚好在一半的位置
        // 如果没有或者只有一个节点的时候，返回true
        // 一边遍历寻找中间位置的同时，一边把前半段反转过来
        ListNode slow = head, fast = head, cur = head, pre = null;
        while (fast != null && fast.next !=null){ // 因为fast要两步两步走
            cur = slow; // '当前节点'
            fast = fast.next.next;
            slow = slow.next;
            cur.next = pre; // '当前节点'指向'上一个节点'
            pre = cur; // 将'当前节点'记录为'上一个节点'
        }

        if (fast != null) { // 奇数情况，只有奇数的时候，fast不为null
            slow = slow.next; // 奇数情况不考虑中间那个数，就跳过中间那个数
        }

        while (slow != null && cur != null){
            // cur从前往后指
            // slow从后往前指
            if (slow.val != cur.val) return false;
            slow = slow.next;
            cur = cur.next;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
