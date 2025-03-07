package com.javatechie.oop.dataStructure;

import java.util.Stack;

public class ReverseUsingStack {

	 // Custom Stack class
    static class Stack {
        private int maxSize;
        private int top;
        private int[] stackArray;

        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int value) {
            stackArray[++top] = value;
        }

        public int pop() {
            return stackArray[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }

    // Custom Stack class for characters
    static class CharStack {
        private int maxSize;
        private int top;
        private char[] stackArray;

        public CharStack(int size) {
            maxSize = size;
            stackArray = new char[maxSize];
            top = -1;
        }

        public void push(char value) {
            stackArray[++top] = value;
        }

        public char pop() {
            return stackArray[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }

    // Method to reverse an array using custom stack
    public static int[] reverseArray(int[] array) {
        Stack stack = new Stack(array.length);
        for (int num : array) {
            stack.push(num);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    // Method to reverse a string using custom stack
    public static String reverseString(String str) {
        CharStack stack = new CharStack(str.length());
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
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