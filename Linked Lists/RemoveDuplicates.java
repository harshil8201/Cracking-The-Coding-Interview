// import java.util.HashSet;

public class RemoveDuplicates {

    public class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        Node head = removeDuplicates.new Node(10);
        head.next = removeDuplicates.new Node(11);
        head.next.next = removeDuplicates.new Node(12);
        head.next.next.next = removeDuplicates.new Node(11);
        head.next.next.next.next = removeDuplicates.new Node(13);
        head.next.next.next.next.next = removeDuplicates.new Node(12);
        head.next.next.next.next.next.next = removeDuplicates.new Node(14);

        removeDuplicates.deleteDuplicates(head);
        removeDuplicates.printList(head);
    }
    
    // // Solution 1:
    // void deleteDuplicates(Node head) {
    //     HashSet<Integer> nodeSet = new HashSet<Integer>();

    //     // to keep data of prevoius node,
    //     // when we found duplicates, we can attech prevoius to next node.
    //     Node previous = null;

    //     while (head != null) {
    //         if (nodeSet.contains(head.data)) {
    //             previous.next = head.next;
    //         } else {
    //             nodeSet.add(head.data);
    //             previous = head;
    //         }
    //         head = head.next;
    //     }
    // }

    // Solution 2: without buffer (without Storing nodes)
    // method: two pointer (current-faster)
    // tc: 0(n^2) - sc: o(1)

    void deleteDuplicates(Node head) {
        Node current = head;

        while (current != null) {
            // remove all future node that have same values
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // Print list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
