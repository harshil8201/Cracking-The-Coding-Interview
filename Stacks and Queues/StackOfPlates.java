import java.util.ArrayList;
public class StackOfPlates {
    public static void main(String[] args) {

        StackOfPlates stackOfPlates = new StackOfPlates();
        
        // Example usage
        SetOfStacks setOfStacks = stackOfPlates.new SetOfStacks(2); // capacity of each stack is 2

        // Push values
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3); // This should create a new stack
        setOfStacks.push(4);

        // Pop values
        System.out.println(setOfStacks.pop()); // 4
        System.out.println(setOfStacks.popAt(0)); // 2
        System.out.println(setOfStacks.pop()); // 3
    }
    
    // Node class
    public class Node {
        public Node above, below;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    // set of stack
    public class SetOfStacks {
        ArrayList<Stack> stacks = new ArrayList<Stack>();
        public int capacity;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
        }

        // get last stack
        public Stack getLastStack() {
            if (stacks.size() == 0)
                return null;

            return stacks.get(stacks.size() - 1);
        }

        // push
        public void push(int value) {
            Stack last = getLastStack();
            if (last != null && !last.isFull()) {
                last.push(value);
            } else {
                // must create new stack
                Stack stack = new Stack(capacity);
                stack.push(value);
                stacks.add(stack);
            }
        }

        // push
        public int pop() {
            Stack last = getLastStack();
            if (last == null)
                return -1;

            int value = last.pop();
            if (last.size == 0)
                stacks.remove(stacks.size() - 1);
            return value;
        }
        
        // pop at index
        public int popAt(int index) {
            return leftShift(index, true);
        }

        // left shift for stack 
        public int leftShift(int index, boolean removeTop) {
            Stack stack = stacks.get(index);
            int removed_item;

            if (removeTop) {
                removed_item = stack.pop();
            }
            else {
                removed_item = stack.removeBottom();
            }

            if (stack.isEmpty()) {
                stacks.remove(index);
            } else if (stacks.size() > index + 1) {
                int v = leftShift(index + 1, false);
                stack.push(v);
            }
            return removed_item;
        }
    }
    
    // Stack class
    public class Stack {
        private int capacity;
        public Node top, bottom;
        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean isFull() {
            return capacity == size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void join(Node above, Node below) {
            if (below != null)
                below.above = above;

            if (above != null)
                above.below = below;
        }

        public boolean push(int v) {
            if (size >= capacity)
                return false;

            size++;
            Node n = new Node(v);
            if (size == 1)
                bottom = n;

            join(n, top);
            top = n;
            return true;
        }
        
        public int pop() {
            Node t = top;
            top = top.below;
            size--;
            return t.value;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null)
                bottom.below = null;
            size--;
            return b.value;
        }
    }
}
