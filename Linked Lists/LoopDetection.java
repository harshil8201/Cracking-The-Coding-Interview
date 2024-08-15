public class LoopDetection {
    // Node class
    class ListNode {
        char data;
        ListNode next;

        public ListNode(char c) {
            this.data = c;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LoopDetection list = new LoopDetection();

        ListNode head = list.new ListNode('A');
        ListNode nodeB = list.new ListNode('B');
        ListNode nodeC = list.new ListNode('C');
        ListNode nodeD = list.new ListNode('D');
        ListNode nodeE = list.new ListNode('E');

        head.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeC;

        ListNode res = list.nodeLoopFound(head);
        if (res != null) {
            System.out.println(res.data);
        } else {
            System.out.println("Loop not found.");
        }
    }
    
    // Solution 1:
    ListNode nodeLoopFound(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;

        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;

            // if slower == faster, then moved slow to head
            if (slower == faster) {
                slower = head;

                // move slow and fast 1 step until they meet again
                while (slower != faster) {
                    slower = slower.next;
                    faster = faster.next;
                }

                // they meet again, we got node which has loop
                return slower;
            }
        }
        // if there is no loop found
        return null;
    }
}
