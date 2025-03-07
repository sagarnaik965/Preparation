package com.javatechie.oop.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeTraversal {

    // Class representing a node in the tree
    static class TreeNode {
        int data;
        List<TreeNode> children;

        // Constructor to initialize the node with data and an empty list of children
        public TreeNode(int item) {
            data = item;
            children = new ArrayList<>();
        }

        // Method to add a child to the node
        public void addChild(TreeNode child) {
            children.add(child);
        }
    }

    // Class representing the tree
    static class Tree {
        TreeNode root;

        Tree() {
            root = null;
        }

        // Pre-order traversal: Visit the root, then the children
        void preOrder(TreeNode node) {
            if (node == null)
                return;

            // Visit the root
            System.out.print(node.data + " ");
            // Visit all the children
            for (TreeNode child : node.children) {
                preOrder(child);
            }
        }

        // Post-order traversal: Visit the children, then the root
        void postOrder(TreeNode node) {
            if (node == null)
                return;

            // Visit all the children
            for (TreeNode child : node.children) {
                postOrder(child);
            }
            // Visit the root
            System.out.print(node.data + " ");
        }

        // Wrapper methods to call the traversal from the root node
        void preOrder() {
            preOrder(root);
        }

        void postOrder() {
            postOrder(root);
        }
    }

    // Main method to test the traversal methods
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Constructing the tree
        tree.root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        tree.root.addChild(node2);
        tree.root.addChild(node3);
        node2.addChild(node4);
        node2.addChild(node5);
        node3.addChild(node6);

        // Perform pre-order traversal
        System.out.println("Pre-order traversal:");
        tree.preOrder();

        // Perform post-order traversal
        System.out.println("\nPost-order traversal:");
        tree.postOrder();
    }
}