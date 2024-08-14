public class ReturnKthToLast {
    
    class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        // Create an instance of the ReturnKthToLast class
        ReturnKthToLast list = new ReturnKthToLast();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        int k = 2;

        // Test the recursive solution
        System.out.println("Recursive solution:");
        list.printKthToLast(head, k);

        // Test the iterative solution
        System.out.println("\nIterative solution:");
        Node kthNode = list.nthToLast(head, k);
        if (kthNode != null) {
            System.out.println(k + "th to last node is " + kthNode.data);
        } else {
            System.out.println("List is shorter than " + k + " elements.");
        }
    }

    // Solution 1: Recursive
    int printKthToLast(Node head, int k) {
        if (head == null) return 0;
        
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is" + head.next);
        }
        return index;
    }

    // SOlution 2: Iterative
    // time o(n) - sp: o(1)
    Node nthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

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
