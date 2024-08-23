import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ListOfDepths {
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Create the list of depths
        ListOfDepths lod = new ListOfDepths();
        ArrayList<LinkedList<TreeNode>> result = lod.createLevelLinkedList(root);

        // Print the linked lists at each level
        for (int i = 0; i < result.size(); i++) {
            LinkedList<TreeNode> level = result.get(i);
            System.out.print("Level " + i + ": ");
            for (TreeNode node : level) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        // Base case
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // level not contained in list
            list = new LinkedList<TreeNode>();

            // levels are always traversed in order. so if this is the first time 
            // we have visited level i, we must have seen levels 0 through i-1.
            // we can therefore safely add the level at the end
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
}
