class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

       
        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        temp.next = head;

        k = k % n;

        
        int steps = n - k;
        ListNode newTail = temp;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
