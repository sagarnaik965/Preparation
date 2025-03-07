package com.javatechie.oop.dataStructure;

public class SimpleLinkedList {

    // Node class representing each element in the linked list
    static class Node {
        int data;     // Data of the node
        Node next;    // Reference to the next node

        // Constructor to initialize the node with data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList class containing the head of the list and methods to manipulate the list
    static class LinkedList {
        Node head;    // Head of the linked list

        // Method to add a node to the end of the list
        public void add(int data) {
            Node newNode = new Node(data);   // Create a new node with the given data
            if (head == null) {
                // If the list is empty, set the new node as the head
                head = newNode;
            } else {
                // Traverse to the end of the list and add the new node
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Method to delete a node with a given value from the list
        public void delete(int data) {
            if (head == null) {
                // If the list is empty, return
                return;
            }

            if (head.data == data) {
                // If the head node is the one to be deleted, update the head
                head = head.next;
                return;
            }

            // Traverse the list to find the node to be deleted
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }

            if (current.next != null) {
                // If the node to be deleted is found, update the next reference
                current.next = current.next.next;
            }
        }

        // Method to display the elements of the list
        public void display() {
            Node current = head;    // Start from the head
            while (current != null) {
                // Print the data of each node
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();   // Print a new line at the end
        }
    }

    // Main method to test the linked list implementation
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements to the linked list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Display the linked list
        System.out.println("Linked List:");
        list.display();

        // Delete an element from the linked list
        list.delete(3);
        System.out.println("After deleting 3:");
        list.display();

        // Delete another element from the linked list
        list.delete(1);
        System.out.println("After deleting 1:");
        list.display();
        
        list.add(11);
        System.out.println("After adding 11:");
        list.display();
    }
}
