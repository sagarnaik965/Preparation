package com.javatechie.oop.dataStructure;

public class BinaryTreeTraversal {

    // Class representing a node in the binary tree
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Class representing the binary tree
    class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        // In-order traversal
        void inOrder(Node node) {
            if (node == null)
                return;

            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        // Pre-order traversal
        void preOrder(Node node) {
            if (node == null)
                return;

            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        // Post-order traversal
        void postOrder(Node node) {
            if (node == null)
                return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }

        // Wrapper methods to call the traversal from the root node
        void inOrder() {
            inOrder(root);
        }

        void preOrder() {
            preOrder(root);
        }

        void postOrder() {
            postOrder(root);
        }
    }

    // Main method to test the traversal methods
    public static void main(String[] args) {
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        BinaryTree tree = traversal.new BinaryTree();

        // Constructing the binary tree
        tree.root = traversal.new Node(1);
        tree.root.left = traversal.new Node(2);
        tree.root.right = traversal.new Node(3);
        tree.root.left.left = traversal.new Node(4);
        tree.root.left.right = traversal.new Node(5);

        System.out.println("In-order traversal:");
        tree.inOrder();

        System.out.println("\nPre-order traversal:");
        tree.preOrder();

        System.out.println("\nPost-order traversal:");
        tree.postOrder();
    }
}