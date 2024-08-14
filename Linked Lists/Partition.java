public class Partition {

    class Node{
        int data;
        Node next = null;

        public Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
        Partition list = new Partition();

        Node head = list.new Node(3);
        head.next = list.new Node(5);
        head.next.next = list.new Node(8);
        head.next.next.next = list.new Node(5);
        head.next.next.next.next = list.new Node(10);
        head.next.next.next.next.next = list.new Node(2);
        head.next.next.next.next.next.next = list.new Node(1);

        Node headPartitionNode = list.partition(head, 5);
        list.printList(headPartitionNode);
    }
    
    // Solution 1:
    Node partition(Node node, int value) {
        Node headNode = null;
        Node tailNode = null;
        Node head = null; // Track the new head
        Node tail = null; // Track the new tail

        while (node != null) {
            Node next = node.next; // Save the next node
            node.next = null; // Disconnect the current node from the rest of the list

            if (node.data < value) {
                // Insert node at head
                if (headNode == null) {
                    headNode = node;
                    head = headNode; // Set the new head
                } else {
                    headNode.next = node;
                    headNode = node;
                }
            } else {
                // Insert node at tail
                if (tailNode == null) {
                    tailNode = node;
                    tail = tailNode; // Set the new tail
                } else {
                    tailNode.next = node;
                    tailNode = node;
                }
            }

            node = next; // Move to the next node in the original list
        }

        // If head list is null, return tail list
        if (head == null) {
            return tail;
        }

        // Combine the head and tail lists
        headNode.next = tail; 

        return head; // Return the new head
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
