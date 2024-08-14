public class DeleteMiddleNode {
    class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the DeleteMiddleNode class
        DeleteMiddleNode list = new DeleteMiddleNode();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        System.out.println("Original list:");
        list.printNode(head);

        // Delete the middle node (e.g., node with value 3)
        Node nodeToDelete = head.next.next; // This is the node with value 3
        if (list.deleteMiddleNode(nodeToDelete)) {
            System.out.println("\nAfter deleting the middle node:");
            list.printNode(head);
        } else {
            System.out.println("\nFailed to delete the node.");
        }
    }
    
    boolean deleteMiddleNode(Node n) {
        Node current = n;
        if (n == null || n.next == null) {
            return false; // Failure
        }

        Node next = current.next;
        current.data = next.data;
        current.next = next.next;

        return true;
    }
    
    void printNode(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

