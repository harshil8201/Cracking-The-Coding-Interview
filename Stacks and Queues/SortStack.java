import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Stack before sorting: " + stack);

        SortStack sorter = new SortStack();
        sorter.sort(stack);

        System.out.println("Stack after sorting: " + stack);
    }

    void sort(Stack<Integer> stack) {
        Stack<Integer> dummyStack = new Stack<Integer>();

        while (!stack.isEmpty()) {
            // insert each element in stack in sorted order into dummyStack.
            int temp = stack.pop();

            while (!dummyStack.isEmpty() && dummyStack.peek() > temp) {
                stack.push(dummyStack.pop());
            }
            dummyStack.push(temp);
        }

        // copy the elements from dummyStack back into stack
        while (!dummyStack.isEmpty()) {
            stack.push(dummyStack.pop());
        }
    }
}
