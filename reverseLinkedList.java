class ReverseLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = reverse(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
