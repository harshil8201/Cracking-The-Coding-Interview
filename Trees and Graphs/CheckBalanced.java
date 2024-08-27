public class CheckBalanced {
    public static void main(String[] args) {
        // Example usage:
        // Create a tree to test the isBalanced method
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        CheckBalanced cb = new CheckBalanced();
        System.out.println("Is the tree balanced? " + cb.isBalanced(root));
    }

    int checkHeight(TreeNode root) {
        if (root == null)
            return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // pass error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
