import java.util.Stack;

public class Palindrome {

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
        Palindrome palindrome = new Palindrome();

        ListNode head = palindrome.new ListNode(5);
        head.next = palindrome.new ListNode(3);
        head.next.next = palindrome.new ListNode(3);
        head.next.next.next = palindrome.new ListNode(3);

        System.out.println(palindrome.isPalindrome(head));
    }
    
    // Solution 1:
    boolean isPalindrome(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;

        // to add nodes in stack
        Stack<Integer> nodeStack = new Stack<>();

        // add node in stack until faster at end of list 
        // and slower at half of list
        while (faster != null && faster.next != null) {
            nodeStack.push(slower.data);
            slower = slower.next;
            faster = faster.next.next;
        }

        // if list is odd number, skip middle element
        if (faster != null) {
            slower = slower.next;
        }

        // check if top node is equal to slower node
        while (slower != null) {
            int topStackNode = nodeStack.pop();
            if (slower.data != topStackNode) {
                // if not, return false
                return false;
            }
            slower = slower.next;
        }
        
        return true;
    }

}
