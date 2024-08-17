import java.util.Stack;

public class QueueViaStacks {
    public static void main(String[] args) {
        MyQueue queue = new QueueViaStacks().new MyQueue();

        // Example usage
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Size: " + queue.size()); // Size: 3

        System.out.println("Peek: " + queue.peek()); // Peek: 1
        System.out.println("Remove: " + queue.remove()); // Remove: 1
        System.out.println("Peek: " + queue.peek()); // Peek: 2
    }

    // MyQueue class
    public class MyQueue {
        Stack<Integer> stackNewest;
        Stack<Integer> stackOldest;

        public MyQueue() {
            stackNewest = new Stack<>();
            stackOldest = new Stack<>();
        }
        
        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(int value) {
            // Push onto stackNewest, which always has the newest elements on top.
            stackNewest.push(value);
        }

        private void shiftStacks() {
            // Move elements from stackNewest to stackOldest to maintain queue order.
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public int peek() {
            shiftStacks(); // Ensure stackOldest has the current elements
            if (stackOldest.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return stackOldest.peek(); // Peek at the oldest item
        }

        public int remove() {
            shiftStacks(); // Ensure stackOldest has the current elements
            if (stackOldest.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return stackOldest.pop(); // Remove and return the oldest item
        }
    }
}
