public class Partition {

    class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Partition list = new Partition();

        ListNode head = list.new ListNode(3);
        head.next = list.new ListNode(5);
        head.next.next = list.new ListNode(8);
        head.next.next.next = list.new ListNode(5);
        head.next.next.next.next = list.new ListNode(10);
        head.next.next.next.next.next = list.new ListNode(2);
        head.next.next.next.next.next.next = list.new ListNode(1);

        ListNode headPartitionNode = list.partition(head, 5);
        list.printList(headPartitionNode);
    }
    
    // Solution 1:
    ListNode partition(ListNode node, int value) {
        ListNode headNode = null;
        ListNode tailNode = null;
        ListNode head = null; // Track the new head
        ListNode tail = null; // Track the new tail

        while (node != null) {
            ListNode next = node.next; // Save the next node
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

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
