package com.javatechie.oop.dataStructure;

public class ReverseUsingCustomQueue {

    // Custom Queue class
    static class Queue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] queueArray;

        public Queue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
        }

        public void insert(int value) {
            queueArray[++rear] = value;
        }

        public int remove() {
            return queueArray[front++];
        }

        public boolean isEmpty() {
            return (front > rear);
        }
    }

    // Custom Queue class for characters
    static class CharQueue {
        private int maxSize;
        private int front;
        private int rear;
        private char[] queueArray;

        public CharQueue(int size) {
            maxSize = size;
            queueArray = new char[maxSize];
            front = 0;
            rear = -1;
        }

        public void insert(char value) {
            queueArray[++rear] = value;
        }

        public char remove() {
            return queueArray[front++];
        }

        public boolean isEmpty() {
            return (front > rear);
        }
    }

    // Method to reverse an array using custom queue
    public static int[] reverseArray(int[] array) {
        Queue queue = new Queue(array.length);
        for (int num : array) {
            queue.insert(num);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = queue.remove();
        }
        return array;
    }

    // Method to reverse a string using custom queue
    public static String reverseString(String str) {
        CharQueue queue = new CharQueue(str.length());
        for (char ch : str.toCharArray()) {
            queue.insert(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!queue.isEmpty()) {
            reversed.insert(0, queue.remove());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        String str = "hello";

        // Reverse array
        array = reverseArray(array);
        System.out.println("Reversed array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Reverse string
        String reversedStr = reverseString(str);
        System.out.println("\nReversed string: " + reversedStr);
    }
}
