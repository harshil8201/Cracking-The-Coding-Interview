import java.util.Random;

public class RandomNode {

    public static void main(String[] args) {
        Tree tree = new RandomNode().new Tree();
        tree.insertInOrder(20);
        tree.insertInOrder(10);
        tree.insertInOrder(30);
        tree.insertInOrder(5);
        tree.insertInOrder(15);
        tree.insertInOrder(25);
        tree.insertInOrder(35);

        // Example of getting a random node
        TreeNode randomNode = tree.getRandomNode();
        System.out.println("Random Node: " + (randomNode != null ? randomNode.data : "null"));
    }

    class Tree {
        TreeNode root = null;

        public int size() {
            return root == null ? 0 : root.size();
        }

        public TreeNode getRandomNode() {
            if (root == null) {
                return null;
            }

            Random random = new Random();
            int i = random.nextInt(size());
            return root.getIthNode(i);
        }

        public void insertInOrder(int value) {
            if (root == null) {
                root = new TreeNode(value);
            } else {
                root.insertInOrder(value);
            }
        }
    }

    class TreeNode {
        private int data;
        public TreeNode left;
        public TreeNode right;
        private int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public TreeNode getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size();
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                // Skip over leftSize + 1 nodes, so subtract them
                return right.getIthNode(i - (leftSize + 1));
            }
        }

        public void insertInOrder(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new TreeNode(d);
                } else {
                    left.insertInOrder(d);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }
        
        public int size() {
            return size;
        }

        public TreeNode find(int d) {
            if (d == data) {
                return this;
            } else if (d <= data) {
                return left != null ? left.find(d) : null;
            } else {
                return right != null ? right.find(d) : null;
            }
        }
    }
}
