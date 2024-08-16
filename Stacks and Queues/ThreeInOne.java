public class ThreeInOne {
    public static void main(String[] args) {
        // Create an instance of the outer class
        ThreeInOne threeInOne = new ThreeInOne();
        
        // Create an instance of the inner class
        FixedMultiStack stack = threeInOne.new FixedMultiStack(5);

        stack.push(0, 10);
        stack.push(0, 20);
        stack.push(1, 30);
        stack.push(2, 40);

        System.out.println("Stack 0 Peek: " + stack.peek(0)); // Should print 20
        System.out.println("Stack 1 Peek: " + stack.peek(1)); // Should print 30
        System.out.println("Stack 2 Peek: " + stack.peek(2)); // Should print 40

        System.out.println("Stack 0 Pop: " + stack.pop(0)); // Should print 20
        System.out.println("Stack 0 Peek: " + stack.peek(0)); // Should print 10
    }
    
    // Non-static Inner Class
    class FixedMultiStack {
        private int numberOfStack = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            this.stackCapacity = stackSize;
            this.values = new int[stackSize * numberOfStack];
            this.sizes = new int[numberOfStack];
        }

        // Check if stack is full
        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        // Check if stack is empty
        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        // Return index of the top of the stack
        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }

        // Push values onto stack
        public void push(int stackNum, int value) {
            // Check that we have a space for the next element
            if (isFull(stackNum)) {
                throw new RuntimeException("Stack is full");
            }

            // Increment stack pointer and then update top values
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        // Pop item from top stack
        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new RuntimeException("Stack is empty");
            }

            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex]; // Get top
            values[topIndex] = 0; // Clear
            sizes[stackNum]--; // Shrink
            return value;
        }

        // Return top element
        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new RuntimeException("Stack is empty");
            }
            return values[indexOfTop(stackNum)];
        }
    }
}
