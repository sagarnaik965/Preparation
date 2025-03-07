package com.javatechie.numbers;

import java.util.HashSet;
import java.util.Iterator;

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
	public static int maxNearest=0;
	private static int  MaxNearestNumber(int[] numbers, int target) {
		// TODO Auto-generated method stub
			
			java.util.Arrays.sort(numbers);
			for(int i=0;i<numbers.length ;i++)
			{
				if(numbers[i]> target)
				{
					maxNearest = numbers[i];
					break;
				}
					
			}
			System.out.println("Largest Nearest  "+maxNearest);
			return maxNearest;
	}
	
	
	private static void MaxSmallestNumber(int[] numbers, int target) {
		// TODO Auto-generated method stub
		int max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] < target && max < numbers[i] ) {
				max = numbers[i];
			}
		}
		System.out.println("Smallest Nearest "+max);
		
		
	}

	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 1, 33, 5, 7, 19, 9 };
		int target = 7;
		

		// find Max nearest number from array of given target
		MaxNearestNumber(numbers, target);
		
		// find Max nearest number from array of given target
		MaxSmallestNumber(numbers, target);
		
		

		//System.out.println(" ");
		/*
		 * if (isSorted(numbers)) { System.out.println("The array is sorted."); } else {
		 * System.out.println("The array is not sorted."); }
		 */
	}

	
}
