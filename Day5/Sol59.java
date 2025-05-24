import java.io.*;
import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // No action needed for internal nodes for sum of leaves
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1; // Use long to prevent overflow before modulo
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNodesSum = 0;
    private int greenLeafNodesSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNodesSum - greenLeafNodesSum);
    }

    public void visitNode(TreeNode node) {
        // Sum values of non-leaf nodes at even depth
        if (node.getDepth() % 2 == 0) {
            evenDepthNodesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        // Sum values of green leaf nodes
        if (leaf.getColor() == Color.GREEN) {
            greenLeafNodesSum += leaf.getValue();
        }
    }
}

public class Sol59 {

    // This method constructs the tree from input
    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        // Adjacency list to represent the tree connections
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1; // Adjust to 0-indexed
            int v = scanner.nextInt() - 1; // Adjust to 0-indexed
            adj.get(u).add(v);
            adj.get(v).add(u); // Tree is undirected for building purposes
        }
        scanner.close();

        if (n == 0) {
            return null;
        }

        // Handle the case of a single node tree separately
        if (n == 1) {
            // As per problem statement: 0 is RED, 1 is GREEN
            return new TreeLeaf(values[0], (colors[0] == 0) ? Color.RED : Color.GREEN, 0);
        }

        // Use DFS to build the tree structure (nodes and children) and assign depths
        boolean[] visited = new boolean[n];
        // Root is node 0, its parent is -1 (non-existent), and its depth is 0
        return buildTree(0, -1, 0, values, colors, adj, visited);
    }

    // Recursive helper method to build the tree using DFS
    private static Tree buildTree(int nodeId, int parentId, int depth,
                                  int[] values, int[] colors,
                                  List<List<Integer>> adj, boolean[] visited) {

        // Mark the current node as visited
        visited[nodeId] = true;

        // Determine the color of the current node
        // As per problem statement: 0 is RED, 1 is GREEN
        Color currentColor = (colors[nodeId] == 0) ? Color.RED : Color.GREEN;

        // Check if the current node is a leaf in the context of tree construction
        // A node is a leaf if it has no unvisited neighbors (other than its parent)
        boolean isLeaf = true;
        for (int neighbor : adj.get(nodeId)) {
            if (neighbor != parentId && !visited[neighbor]) {
                isLeaf = false;
                break;
            }
        }

        if (isLeaf) {
            // If it's a leaf, create a TreeLeaf
            return new TreeLeaf(values[nodeId], currentColor, depth);
        } else {
            // If it's not a leaf, create a TreeNode
            TreeNode currentNode = new TreeNode(values[nodeId], currentColor, depth);

            // Recursively build children
            for (int neighbor : adj.get(nodeId)) {
                if (neighbor != parentId && !visited[neighbor]) {
                    // Pass currentDepth + 1 for the child's depth
                    currentNode.addChild(buildTree(neighbor, nodeId, depth + 1, values, colors, adj, visited));
                }
            }
            return currentNode;
        }
    }


    public static void main(String[] args) {
        // Build the tree
        Tree root = solve();

        // Create visitor objects
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        // Accept visitors on the root
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        // Get and print results
        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}