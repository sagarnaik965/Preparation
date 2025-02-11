package com.javatechie.strings;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap elements using XOR
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Original array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        reverseArray(arr);

        System.out.println("Reversed array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println("---------------J8Fe------------------------");
        
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        
        Arrays.sort(arr1, Collections.reverseOrder());
        
        Arrays.stream(arr1).forEach(i->{System.out.print(i+" ");});;
    }
}
