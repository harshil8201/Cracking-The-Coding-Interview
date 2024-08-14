// import java.util.HashSet;

public class RemoveDuplicates {

    public class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        ListNode head = removeDuplicates.new ListNode(10);
        head.next = removeDuplicates.new ListNode(11);
        head.next.next = removeDuplicates.new ListNode(12);
        head.next.next.next = removeDuplicates.new ListNode(11);
        head.next.next.next.next = removeDuplicates.new ListNode(13);
        head.next.next.next.next.next = removeDuplicates.new ListNode(12);
        head.next.next.next.next.next.next = removeDuplicates.new ListNode(14);

        removeDuplicates.deleteDuplicates(head);
        removeDuplicates.printList(head);
    }
    
    // // Solution 1:
    // void deleteDuplicates(ListNode head) {
    //     HashSet<Integer> nodeSet = new HashSet<Integer>();

    //     // to keep data of prevoius node,
    //     // when we found duplicates, we can attech prevoius to next node.
    //     ListNode previous = null;

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

    void deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null) {
            // remove all future node that have same values
            ListNode runner = current;
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
    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
