
public class DeleteMiddleNode {
    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the DeleteMiddleNode class
        DeleteMiddleNode list = new DeleteMiddleNode();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = list.new ListNode(1);
        head.next = list.new ListNode(2);
        head.next.next = list.new ListNode(3);
        head.next.next.next = list.new ListNode(4);
        head.next.next.next.next = list.new ListNode(5);

        System.out.println("Original list:");
        list.printNode(head);

        // Delete the middle node (e.g., node with value 3)
        ListNode nodeToDelete = head.next.next; // This is the node with value 3
        if (list.deleteMiddleNode(nodeToDelete)) {
            System.out.println("\nAfter deleting the middle node:");
            list.printNode(head);
        } else {
            System.out.println("\nFailed to delete the node.");
        }
    }
    
    boolean deleteMiddleNode(ListNode n) {
        ListNode current = n;
        if (n == null || n.next == null) {
            return false; // Failure
        }

        ListNode next = current.next;
        current.data = next.data;
        current.next = next.next;

        return true;
    }
    
    void printNode(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

