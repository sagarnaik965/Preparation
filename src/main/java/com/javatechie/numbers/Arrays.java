package com.javatechie.numbers;

import java.util.HashSet;

public class Arrays {

	private static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static void removeDuplicates(int[] arr) {
		HashSet<Integer> uniqueSet = new HashSet<>();
		System.out.println("unique array");
		for (int num : arr) {
			if (uniqueSet.add(num)) {
				System.out.print(num + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 1, 3, 5, 7, 9, 9 };
		removeDuplicates(numbers);
		System.out.println(" ");
		if (isSorted(numbers)) {
			System.out.println("The array is sorted.");
		} else {
			System.out.println("The array is not sorted.");
		}
	}

}
