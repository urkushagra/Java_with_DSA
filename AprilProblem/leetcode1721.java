/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;
        
        // Step 1: move to kth node from start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;

        // Step 2: find kth from end
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        ListNode kthFromEnd = second;

        // Step 3: swap values
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;
    }
}
