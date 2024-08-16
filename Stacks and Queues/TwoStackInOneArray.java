public class TwoStackInOneArray {
    // Make the inner class static
    class TwoStacksArray {
        int s;     // Size of the array
        int t1, t2; // Top indices for stack 1 and stack 2
        int[] a;   // Array that will be used for storing the elements of the two stacks

        // Constructor of the class
        TwoStacksArray(int size) {
            a = new int[size];
            this.s = size;
            t1 = -1; // Stack 1 starts from the beginning
            t2 = size; // Stack 2 starts from the end
        }

        // Method for pushing an element i into stack 1
        void push1(int i) {
            if (t1 < t2 - 1) { // Check if there is space for the new element
                t1 = t1 + 1;
                a[t1] = i;
            } else {
                System.out.println("Overflow of stack 1");
                System.exit(1);
            }
        }

        // Method for pushing an element i into stack 2
        void push2(int i) {
            if (t1 < t2 - 1) { // Check if there is space for the new element
                t2 = t2 - 1;
                a[t2] = i;
            } else {
                System.out.println("Overflow of stack 2");
                System.exit(1);
            }
        }

        // Method for popping an element from stack 1
        int pop1() {
            if (t1 >= 0) { // Check if stack 1 is not empty
                int i = a[t1];
                t1 = t1 - 1;
                return i;
            } else {
                System.out.println("Underflow of stack 1");
                System.exit(1);
            }
            return 0; // This line is never reached
        }

        // Method for popping an element from stack 2
        int pop2() {
            if (t2 < s) { // Check if stack 2 is not empty
                int i = a[t2];
                t2 = t2 + 1;
                return i;
            } else {
                System.out.println("Underflow of stack 2");
                System.exit(1);
            }
            return 0; // This line is never reached
        }
    }

    // Main method
    public static void main(String[] args) {

        TwoStackInOneArray twoStackInOneArray = new TwoStackInOneArray();
        // Creating an object of the static inner class TwoStacksArray
        TwoStacksArray ts = twoStackInOneArray.new TwoStacksArray(5);
        ts.push1(50);
        ts.push2(101);
        ts.push2(150);
        ts.push1(191);
        ts.push2(17);
        System.out.println("The popped element from stack 1 is: " + ts.pop1());
        // As one element from stack 1 is popped, space for one element is empty
        ts.push2(40);
        System.out.println("The popped element from stack 2 is: " + ts.pop2());
    }
}
