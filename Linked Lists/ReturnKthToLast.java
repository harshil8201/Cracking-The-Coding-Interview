public class ReturnKthToLast {
    
    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        // Create an instance of the ReturnKthToLast class
        ReturnKthToLast list = new ReturnKthToLast();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = list.new ListNode(1);
        head.next = list.new ListNode(2);
        head.next.next = list.new ListNode(3);
        head.next.next.next = list.new ListNode(4);
        head.next.next.next.next = list.new ListNode(5);

        int k = 2;

        // Test the recursive solution
        System.out.println("Recursive solution:");
        list.printKthToLast(head, k);

        // Test the iterative solution
        System.out.println("\nIterative solution:");
        ListNode kthNode = list.nthToLast(head, k);
        if (kthNode != null) {
            System.out.println(k + "th to last node is " + kthNode.data);
        } else {
            System.out.println("List is shorter than " + k + " elements.");
        }
    }

    // Solution 1: Recursive
    int printKthToLast(ListNode head, int k) {
        if (head == null) return 0;
        
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is" + head.next);
        }
        return index;
    }

    // SOlution 2: Iterative
    // time o(n) - sp: o(1)
    ListNode nthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        // Move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // out of bound
            p1 = p1.next;
        }

        // move them at the same pace.
        // when p1 hits the end, p2 will be at the right element.
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
