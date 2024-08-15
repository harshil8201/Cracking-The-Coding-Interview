import java.util.HashSet;

public class Intersection {

    // Node class
    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Intersection list = new Intersection();

        // Create shared nodes
        ListNode common1 = list.new ListNode(7);
        ListNode common2 = list.new ListNode(2);
        ListNode common3 = list.new ListNode(1);
        common1.next = common2;
        common2.next = common3;

        ListNode l1 = list.new ListNode(3);
        l1.next = list.new ListNode(1);
        l1.next.next = list.new ListNode(5);
        l1.next.next.next = list.new ListNode(9);
        l1.next.next.next.next = common1;
        l1.next.next.next.next.next = common2;
        l1.next.next.next.next.next.next = common3;

        ListNode l2 = list.new ListNode(4);
        l2.next = list.new ListNode(6);
        l2.next.next = common1;
        l2.next.next.next = common2;
        l2.next.next.next.next = common3;

        // Finding intersection
        ListNode res = list.intersectionNode(l1, l2);
        if (res != null) {
            System.out.println("Intersection Node: " + res.data);
        } else {
            System.out.println("No Intersection");
        }

    }
    
    //Solution 1: HashSet
    // tc: o(a+b) ; a, b is listnodes
    // sc: o(n) ; n is number of node in hashset
    ListNode intersectionNode(ListNode l1, ListNode l2) {
        // create a Hashset to store visited nodes
        HashSet<ListNode> visitedNode = new HashSet<ListNode>();

         // assign cuurenNode as l1;
        ListNode currentNode = l1;

        // traversing node and add into Hashset
        while (currentNode != null) {
            visitedNode.add(currentNode);
            currentNode = currentNode.next;
        }

        // make cuurent node a NodeB to traversing and check
        currentNode = l2;

        while (currentNode != null) {
            // if contains node that already visited
            if (visitedNode.contains(currentNode)) {
                return currentNode;
            }
            // otherwise move to next node
            currentNode = currentNode.next;
        }
        // if no intersection found, 
        return null;
    }
}
