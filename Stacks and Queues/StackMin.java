import java.util.Stack;

public class StackMin {
    public static void main(String[] args) {
        // Creating an instance of MinStack
        MinStack minStack = new StackMin().new MinStack();

        // Performing some operations
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        //System.out.println("Top: " + (minStack.top() == -1 ? "Stack is empty" : minStack.to())); // Output: Stack is empty
    }

    // // solution 1:
    // // Create MIN Stack Class
    // class MinStack {
    //     Stack<Integer> st = new Stack<>();
    //     int min;

    //     public MinStack() {
    //         this.min = Integer.MAX_VALUE;
    //     }

    //     // push fuction
    //     public void push(int value) {
    //         if (st.isEmpty()) {
    //             min = value;
    //             st.push(value);
    //         } else {
    //             if (value < min) {
    //                 st.push(2 * value - min);
    //                 min = value;
    //             } else {
    //                 st.push(value);
    //             }
    //         }
    //     }

    //     // pop function
    //     public int pop() {
    //         if (st.isEmpty())
    //             return -1; // if stact is empty

    //         int value = st.pop();
    //         if (value < min) {
    //             int temp = min;
    //             min = 2 * min - value;
    //             return temp;
    //         }
    //         return value;
    //     }

    //     // top
    //     public int top() {
    //         int value = st.peek();
    //         if (value < min) {
    //             return min;
    //         }
    //         return value;
    //     }
    //     // get min
    //     public int getMin() {
    //         return min;
    //     }
    // }



    // Solution 2:
    public class MinStack extends Stack<Integer> {
        Stack<Integer> st = new Stack<>();

        public MinStack() {
            st = new Stack<>();
        }

        public int min() {
            if (st.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return st.peek();
            }
        }

        public void push(int value) {
            if (value <= min()) {
                st.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                st.pop();
            }
            return value;
        }
    }
}
