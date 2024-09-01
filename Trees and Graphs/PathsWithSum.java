import java.util.HashMap;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class PathsWithSum {
    public static void main(String[] args) {
        // Create a sample tree:
        //       10
        //      /  \
        //     5   -3
        //    / \    \
        //   3   2   11
        //  / \   \
        // 3  -2   1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        PathsWithSum pathsWithSum = new PathsWithSum();
        int result = pathsWithSum.countPathWithSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result);
    }
    
    int countPathWithSum(TreeNode node, int targetSum) {
        return countPathWithSum(node, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null)
            return 0; // Base Case

        // Count paths with sum ending at the current Node
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        // If runningSum equals targetSum, then one additional path starts at root
        // Add in this path
        if (runningSum == targetSum) {
            totalPaths++;
        }

        // Increment pathCount, recurse, then decrement pathCount
        incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
        totalPaths += countPathWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            // Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
