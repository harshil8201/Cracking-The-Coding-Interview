public class SumLists {

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SumLists sumLists = new SumLists();

        ListNode l1 = sumLists.new ListNode(7);
        l1.next = sumLists.new ListNode(1);
        l1.next.next = sumLists.new ListNode(6);

        ListNode l2 = sumLists.new ListNode(5);
        l2.next = sumLists.new ListNode(9);
        l2.next.next = sumLists.new ListNode(2);

        ListNode data = sumLists.sumOfListNode(l1, l2);
        sumLists.printList(data);
    }
    
    // Solution 1: 
    ListNode sumOfListNode(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;

        while (l1 != null || l2 != null) {

            // if l1 or l2 is not null
            int l1data = (l1 != null) ? l1.data : 0;
            int l2data = (l2 != null) ? l2.data : 0;

            // sum of carry and l1 and l2
            int sum = carry + l1data + l2data;

            // take excessive 
            carry = sum / 10;

            // assign last digit to node
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        
        // if carry is more than 0 at the end,
        // add carry to last node
        if (carry > 0)
            current.next = new ListNode(carry);

        return result.next;
    }

    // Print ListNode
    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
