import PacmanAI.TreeNode;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreePrinterTests {
    private TreeNode root;

    @Before
    public void setup() {
        root = new TreeNode("ROOT");
        TreeNode left = new TreeNode("blinkyIsEdible");
        TreeNode leftleft = new TreeNode("true");
        TreeNode leftright = new TreeNode("false");
        leftright.addEdge("RIGHT", new TreeNode("RIGHT"));
        leftleft.addEdge("LEFT", new TreeNode("LEFT"));
        left.addEdge("true", leftleft);
        left.addEdge("false", leftright);
        TreeNode right = new TreeNode("inkyIsEdible");
        right.addEdge("inkyDist", new TreeNode("DOWN"));
        root.addEdge(left.getLabel(), left);
        root.addEdge(right.getLabel(), right);
        root.addEdge("inkyDir", new TreeNode("UP"));
    }

    @Test
    public void PrintTree() {
        System.out.println(root);
        root.printTree(root ,1);
    }

    @Test
    public void TreePrint() {
        System.out.println(root.treePrint(root ,1, ""));

    }

    @Test
    public void printBFS() {
        for(int i = 0; i < root.getEdges().size(); i++) {
            System.out.print("\t");
        }
        System.out.println("\t"+ root);
        LinkedList<TreeNode> nodes = new LinkedList<>();
        root.getEdges().values().forEach(nodes::add);
        print(nodes, 1);

    }

    @Test
    public void printBFS2() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!node.isLeaf()) {
                System.out.print("Parent: "+ node +", Children: ");
            }
            node.getEdges().values().forEach(n -> {
                System.out.print(n+ " ");
                queue.add(n);
            });
            if(!node.isLeaf())
                System.out.println();
        }
    }

    @Test
    public void GraphStreamTest() {
        Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        graph.display();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test

    public void GraphStreamTest2() {
        Graph graph = new SingleGraph("TestTree");
        TreeNode left = new TreeNode("blinkyIsEdible");
        TreeNode leftleft = new TreeNode("true");
        TreeNode leftright = new TreeNode("false");
        TreeNode[] vertices = { root, left, leftleft, leftright};
        for(int i = 0; i < vertices.length; i++) {
            Node n = graph.addNode(vertices[i].toString());
            n.addAttribute("ui.label", vertices[i].toString());
        }
        graph.addEdge(root.toString()+left.toString(), root.toString(), left.toString());
        graph.addEdge(left.toString()+leftleft.toString(), left.toString(), leftleft.toString());
        graph.addEdge(left.toString()+leftright.toString(), left.toString(), leftright.toString());
        graph.display();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void print(LinkedList<TreeNode> nodes, int offset) {
        LinkedList<TreeNode> children = new LinkedList<>();
        for(int i = 0; i < offset; i++) {
            System.out.print("\t");
        }
        nodes.forEach(n->System.out.print(n + "\t"));
        System.out.println();
        nodes.forEach(n->n.getEdges().values().forEach(children::add));
        if(children.size()>0)
            print(children, offset+1);
    }
}
