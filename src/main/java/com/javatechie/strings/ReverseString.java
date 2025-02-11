package com.javatechie.strings;

public class ReverseString {

    public static String reverseString(String s) {
        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;

        while (left < right) {
            // Swap characters
            sArray[left] ^= sArray[right];
            sArray[right] ^= sArray[left];
            sArray[left] ^= sArray[right];
            left++;
            right--;
        }

        return new String(sArray);
    }

    public static void main(String[] args) {
        String s = "hell";
        String reversedS = reverseString(s);
        System.out.println("Original string: " + s);
        System.out.println("Reversed string: " + reversedS);
    }
}