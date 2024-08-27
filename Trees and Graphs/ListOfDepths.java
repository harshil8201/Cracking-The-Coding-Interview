import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    public static void main(String[] args) {

        ListOfDepths listOfDepths = new ListOfDepths();
        // Example tree
        TreeNode root = listOfDepths.new TreeNode(1);
        root.left = listOfDepths.new TreeNode(2);
        root.right = listOfDepths.new TreeNode(3);
        root.left.left = listOfDepths.new TreeNode(4);
        root.left.right = listOfDepths.new TreeNode(5);
        root.right.left = listOfDepths.new TreeNode(6);
        root.right.right = listOfDepths.new TreeNode(7);

        // Create an instance of ListOfDepths
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

    // Definition of TreeNode class
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recursive method to populate the list of linked lists for each depth
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        // Base case: if node is null, return
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list;
        // If the list for the current level does not exist, create it
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        // Add the current node to the list for its level
        list.add(root);

        // Recursively process left and right children
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    // Public method to start the creation of the level linked lists
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
}
