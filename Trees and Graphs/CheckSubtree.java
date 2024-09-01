public class CheckSubtree {
    public static void main(String[] args) {
        // Example usage
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(6);
        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(8);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(8);

        CheckSubtree checkSubtree = new CheckSubtree();
        boolean result = checkSubtree.containsTree(t1, t2);
        System.out.println("t2 is a subtree of t1: " + result);
    }

    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true; // The empty tree is always a subtree
        }
        return subTree(t1, t2);
    }

    boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false; // Big tree empty & subtree still not found
        } else if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true; // Nothing left in the subtree
        } else if (r1 == null || r2 == null) {
            return false; // Exactly one tree is empty, therefore trees don't match
        } else if (r1.data != r2.data) {
            return false; // Data doesn't match
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}

// Simple TreeNode class
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
