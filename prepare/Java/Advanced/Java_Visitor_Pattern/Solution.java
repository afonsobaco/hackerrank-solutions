package com.example.demo;

import java.util.ArrayList;
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

    List<TreeLeaf> leaves = new ArrayList<>();

    public int getResult() {
        int sum = 0;
        for (int i = 0; i < leaves.size(); i++) {
            sum += leaves.get(i).getValue();
        }
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        leaves.add(leaf);
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private static final int MODULO = 1000000007;
    List<Tree> reds = new ArrayList<>();

    public int getResult() {

        long product = 1;
        for (int i = 0; i < reds.size(); i++) {
            product = (product * reds.get(i).getValue()) % MODULO;
        }
        if (product == 0) {
            return 1;
        }
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED))
            reds.add(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED))
            reds.add(leaf);
    }
}

class FancyVisitor extends TreeVis {

    List<TreeNode> nodes = new ArrayList<>();
    List<TreeLeaf> leaves = new ArrayList<>();

    public int getResult() {
        int leavesSum = 0;
        for (int i = 0; i < leaves.size(); i++) {
            leavesSum += leaves.get(i).getValue();
        }
        int nodesSum = 0;
        for (int i = 0; i < nodes.size(); i++) {
            nodesSum += nodes.get(i).getValue();
        }
        if (leavesSum > nodesSum) {
            return leavesSum - nodesSum;
        } else {
            return nodesSum - leavesSum;
        }
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0)
            nodes.add(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN))
            leaves.add(leaf);
    }
}

public class Solution {

    private static String[] values;
    private static String[] colors;
    private static String[] edges;

    public static Tree solve() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String st = br.readLine();
            int n = Integer.parseInt(st);
            if (n >= 2 && n <= 100000) {
                values = br.readLine().split(" ");
                colors = br.readLine().split(" ");

                // This will handle all edges. 
                // We don't know who is parent and who  
                // is child until the root is defined.
                edges = new String[n];
                Arrays.fill(edges, "");
                for (int i = 0; i < n - 1; i++) {
                    String[] link = br.readLine().split(" ");
                    int a = Integer.parseInt(link[0]) - 1;
                    int b = Integer.parseInt(link[1]) - 1;
                    if (b != 0)
                        edges[a] += b + " ";
                    if (a != 0)
                        edges[b] += a + " ";
                }
                // root definition. 
                // starts on 0 (node 1). 
                // The depth is 0, since it's the root.
                return getChildren(0, 0);
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Tree getChildren(int parent, int depth) {
        Tree node = getTreeNode(parent, depth);
        // If it is not a leaf, get all children and repeat the process
        if (!(node instanceof TreeLeaf)) {
            String[] children = edges[parent].trim().split(" ");
            for (String s : children) {
                int child = Integer.parseInt(s);
                // remove the now known "parent" from the now known child
                edges[child] = edges[child].replaceAll("(^| )" + parent + "($| )", " ");
                ((TreeNode) node).addChild(getChildren(child, node.getDepth() + 1));
            }
        }
        return node;
    }

    private static Tree getTreeNode(int index, int depth) {
        // if is not empty it is a node, or else it's a leaf 
        if (!edges[index].trim().isEmpty()) {
            return new TreeNode(Integer.parseInt(values[index]), colors[index].equals("0") ? Color.RED : Color.GREEN, depth);
        } else {
            return new TreeLeaf(Integer.parseInt(values[index]), colors[index].equals("0") ? Color.RED : Color.GREEN, depth);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
