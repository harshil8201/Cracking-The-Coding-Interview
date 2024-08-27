public class ValidateBST {
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7); // This makes it an invalid BST

        // Create an instance of ValidateBST and check if the tree is a valid BST
        ValidateBST validator = new ValidateBST();
        boolean isBST = validator.checkBST(root);
        System.out.println("Is the tree a valid BST? " + isBST);
    }

    boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }

        return true; 
    }
}

// Definition of TreeNode class
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}
