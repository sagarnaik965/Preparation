package com.javatechie.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxMinArray {
	public static String MinMaxFind(int[] numbers) {
		int max = numbers[0];
		int min = numbers[0];
		for (int num : numbers) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		return "Maximum " + max + " " + "Minimum " + min;
	}

	public static String CountOfOccurance(int[] numbers, int target) {
		Map<Integer, Integer> elementCountMap = new HashMap<>();

		// Count the occurrences of each element
		for (int num : numbers) {
			elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
		}

		if (elementCountMap.containsKey(target)) {
			int count = elementCountMap.get(target);
			return("Array contains " + target + " with " + count + " occurrences.");
		} else {
			return("Array does not contain " + target);
		}
	}

	

	public static void main(String[] args) {
		int[] numbers = { 7, 2, 9, 1, 5 ,9};
		int target = 9;

		System.out.println(MinMaxFind(numbers));
		System.out.println(CountOfOccurance(numbers, target));

	}
}
