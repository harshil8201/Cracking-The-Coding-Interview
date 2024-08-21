import java.util.LinkedList;

public class RouteBetweenNodes {

    public static void main(String[] args) {
        // Create an instance of the outer class
        RouteBetweenNodes routeFinder = new RouteBetweenNodes();

        // Create nodes
        Node nodeA = routeFinder.new Node("A");
        Node nodeB = routeFinder.new Node("B");
        Node nodeC = routeFinder.new Node("C");
        Node nodeD = routeFinder.new Node("D");
        Node nodeE = routeFinder.new Node("E");

        // Define the adjacency (children) relationships
        nodeA.childrens = new Node[] { nodeB, nodeC };
        nodeB.childrens = new Node[] { nodeD };
        nodeC.childrens = new Node[] { nodeE };
        nodeD.childrens = new Node[] {};
        nodeE.childrens = new Node[] {};

        // Create the graph
        Graph graph = routeFinder.new Graph(new Node[] { nodeA, nodeB, nodeC, nodeD, nodeE });

        // Check if there is a route between nodeA and nodeE
        System.out.println(routeFinder.search(graph, nodeA, nodeE));
    }

    class Graph {
        private Node[] nodes;

        public Graph(Node[] nodes) {
            this.nodes = nodes;
        }

        public Node[] getNodes() {
            return nodes;
        }
    }

    class Node {
        public String name;
        public Node[] childrens;
        public State state;

        public Node(String name) {
            this.name = name;
            this.childrens = new Node[] {};
            this.state = State.UnVisited;
        }

        public Node[] getAdjacent() {
            return childrens;
        }
    }

    enum State {
        UnVisited, Visited, Visiting;
    }

    boolean search(Graph g, Node start, Node end) {
        // If start is end, we've found the path
        if (start == end) {
            return true;
        }

        // Create a queue to add visited nodes from the graph
        LinkedList<Node> q = new LinkedList<>();

        // Mark all nodes as UnVisited
        for (Node n : g.getNodes()) {
            n.state = State.UnVisited;
        }

        // Start with the start node
        start.state = State.Visiting;
        q.add(start);

        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); // Dequeue

            if (u != null) {
                // Explore the adjacent nodes
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.UnVisited) {
                        if (v == end) {
                            return true; // Found the end node
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }

        return false; // Return false if no path is found
    }
}
