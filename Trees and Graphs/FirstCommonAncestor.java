class TreeNode {
    int val;              // The value of the node
    TreeNode left;        // Reference to the left child
    TreeNode right;       // Reference to the right child
    TreeNode parent;      // Reference to the parent node

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class FirstCommonAncestor {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node4.parent = node2;
        node2.right = node5;
        node5.parent = node2;

        FirstCommonAncestor ancestorFinder = new FirstCommonAncestor();
        TreeNode ancestor = ancestorFinder.commonAncestor(node4, node5);

        if (ancestor != null) {
            System.out.println("First common ancestor: " + ancestor.val);
        } else {
            System.out.println("No common ancestor found.");
        }
    }

    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // get difference in depths
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta)); // move deeper node Up

        // find where paths intersect
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
