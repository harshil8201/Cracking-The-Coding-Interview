public class Successor {
    public static void main(String[] args) {
        // Create a sample tree and test the inOrderSuccessor method

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        Successor successor = new Successor();

        TreeNode node = root.left.right; // Node with value 15
        TreeNode successorNode = successor.inOrderSucessor(node);

        if (successorNode != null) {
            System.out.println("InOrder Successor of " + node.data + " is " + successorNode.data);
        } else {
            System.out.println("InOrder Successor of " + node.data + " does not exist.");
        }
    }

    TreeNode inOrderSucessor(TreeNode n) {
        if (n == null)
            return null;

        // Found right children -> return leftmost node of right subtree
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;

            // Go up until we are on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}

// Definition of TreeNode class with parent pointer
class TreeNode {
    int data;
    TreeNode left, right, parent;

    TreeNode(int item) {
        data = item;
        left = right = parent = null;
    }
}
