public class MinimalTree {
    public static void main(String[] args) {
        MinimalTree minimalTree = new MinimalTree();

        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        TreeNode root = minimalTree.createTree(array);
        minimalTree.preOrderTraversal(root);
    }
    
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    

    TreeNode createTree(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode createMinimalBST(int array[], int start, int end) {
        // Base case
        if (end < start)
            return null;

        // create mid as a toor node
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(array[mid]);
        root.left = createMinimalBST(array, start, mid - 1);
        root.right = createMinimalBST(array, mid + 1, end);

        return root;
    }

    // print tree
    void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
