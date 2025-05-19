package com.javatechie.streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
		// Question 1: Filtering and Mapping
		List<Integer> numbers1 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		List<Integer> result1 = numbers1.stream().filter(n -> n % 2 != 0).map(n -> n * 2).collect(Collectors.toList());
		System.out.println(result1); // Output: [2, 6]
		System.out.println("----------------------------\n");
		

		// Question 2: Finding Maximum and Minimum
		List<Integer> numbers2 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		int max = numbers2.stream().max(Integer::compare).orElseThrow();
		//numbers2.stream().max((o1, o2) -> o1-o2).orElseThrow();
//		numbers2.stream().sorted((o1,o2)->o2-o1).findFirst().orElse(0);  
		int min = numbers2.stream().min(Integer::compare).orElseThrow();
		System.out.println("Max: " + max); // Output: Max: 8
		System.out.println("Min: " + min); // Output: Min: 0
		System.out.println("----------------------------\n");

		
		

		// Question 3: Summing and Averaging
		List<Integer> numbers3 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		int sum = numbers3.stream().mapToInt(Integer::intValue).sum();
		double average = numbers3.stream().mapToInt(Integer::intValue).average().orElse(0);
		System.out.println("Sum: " + sum); // Output: Sum: 28
		System.out.println("Average: " + average); // Output: Average: 3.5
		List<Integer> numbersGreterThanAverage=numbers3.stream().filter(n->n>average).collect(Collectors.toList());
		System.out.println("numbersGreterThanAverage: " + numbersGreterThanAverage); // Output: Average: 3.5

		System.out.println("----------------------------\n");


		// Question 4: Collecting to a Set
		List<Integer> numbers4 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		Set<Integer> uniqueNumbers = numbers4.stream().collect(Collectors.toSet());
		System.out.println(uniqueNumbers); // Output: [0, 1, 2, 3, 4, 6, 8]
		System.out.println("----------------------------\n");


		// Question 5: Joining Strings
		List<String> words1 = Arrays.asList("apple", "banana", "cherry", "date");
		String result2 = words1.stream().collect(Collectors.joining(", "));
		System.out.println(result2); // Output: apple, banana, cherry, date
		System.out.println("----------------------------\n");


		// Question 6: Grouping by Length
		List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date", "egg");
		Map<Integer, List<String>> groupedByLength = words2.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);
		// Output: {3=[egg], 4=[date], 5=[apple], 6=[banana, cherry]}
		System.out.println("----------------------------\n");


		// Question 7: Counting Elements
		List<String> words3 = Arrays.asList("apple", "banana", "cherry", "date", "egg");
		Map<Integer, Long> lengthCounts = words3.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(lengthCounts);
		// Output: {3=1, 4=1, 5=1, 6=2}
		System.out.println("----------------------------\n");


		// Question 8: Reducing to a Single Value
		List<Integer> numbers5 = Arrays.asList(1, 1, 1, 1, 1, 1);
		int product = numbers5.stream().reduce(0, (a, b) -> a * b);
		System.out.println("Product: " + product); // Output: Product: 1152
		System.out.println("----------------------------\n");


		// Question 9: Finding Distinct Elements
		List<Integer> numbers6 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		List<Integer> distinctNumbers = numbers6.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctNumbers); // Output: [1, 3, 6, 2, 8, 0, 4]
		System.out.println("----------------------------\n");


		// Question 10: Sorting Elements
		List<String> words4 = Arrays.asList("apple", "banana", "cherry", "date");
		List<String> sortedWords = words4.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedWords); // Output: [apple, banana, cherry, date]
		System.out.println("----------------------------\n");


		// Question 11: Checking if all elements match a condition
		List<Integer> numbers7 = Arrays.asList(2, 4, 6, 8);
		boolean allEven = numbers7.stream().allMatch(n -> n % 2 == 0);
		System.out.println("All even: " + allEven); // Output: All even: true
		System.out.println("----------------------------\n");


		// Question 12: Checking if any element matches a condition
		List<Integer> numbers8 = Arrays.asList(1, 3, 6, 7);
		boolean anyEven = numbers8.stream().anyMatch(n -> n % 2 == 0);
		System.out.println("Any even: " + anyEven); // Output: Any even: true
		System.out.println("----------------------------\n");


		// Question 13: Checking if no element matches a condition
		List<Integer> numbers9 = Arrays.asList(1, 3, 5, 7);
		boolean noneEven = numbers9.stream().noneMatch(n -> n % 2 == 0);
		System.out.println("None even: " + noneEven); // Output: None even: true
		System.out.println("----------------------------\n");


		// Question 14: Counting elements
		List<Integer> numbers10 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		long count = numbers10.stream().count();
		System.out.println("Count: " + count); // Output: Count: 8
		System.out.println("----------------------------\n");


		// Question 15: Limiting the number of elements
		List<Integer> numbers11 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
//		List<Integer> limited = numbers11.stream().limit(5).collect(Collectors.toList());
		Optional<Integer> secHighest = numbers11.stream().sorted((e1,e2)-> e2-e1).skip(1).findFirst();
		System.out.println("Second Highest :"+secHighest); // Output: [1, 3, 6, 2, 8]
		System.out.println("----------------------------\n");

		

		// Question 16: Skipping elements
		List<Integer> numbers12 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		List<Integer> skipped = numbers12.stream().skip(3).collect(Collectors.toList());
		System.out.println(skipped); // Output: [2, 8, 0, 4, 4]
		System.out.println("----------------------------\n");


		// Question 17: Concatenating two streams
		List<Integer> numbers13 = Arrays.asList(1, 3, 6);
		List<Integer> numbers14 = Arrays.asList(2, 8, 0, 4);
		List<Integer> concatenated = Stream.concat(numbers13.stream(), numbers14.stream()).collect(Collectors.toList());
		System.out.println(concatenated); // Output: [1, 3, 6, 2, 8, 0, 4]
		System.out.println("----------------------------\n");


		// Question 18: Generating a stream of random numbers
		List<Double> randomNumbers = Stream.generate(Math::random).limit(5).collect(Collectors.toList());
		System.out.println(randomNumbers);
		System.out.println("----------------------------\n");


		// Question 19: Generating an infinite stream of even numbers
		List<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList());
		System.out.println(evenNumbers); // Output: [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
		System.out.println("----------------------------\n");


		// Question 20: Finding the first element
		List<Integer> numbers15 = Arrays.asList(1, 3, 6, 2, 8);
		int first = numbers15.stream().findFirst().orElseThrow();
		System.out.println("First: " + first); // Output: First: 1
		System.out.println("----------------------------\n");


		// Question 21: Finding any element
		List<Integer> numbers16 = Arrays.asList(1, 3, 6, 2, 8);
		int any = numbers16.stream().findAny().orElseThrow();
		System.out.println("Any: " + any);
		System.out.println("----------------------------\n");


		// Question 22: Collecting to an unmodifiable list
		List<Integer> numbers17 = Arrays.asList(1, 3, 6, 2, 8);
		List<Integer> unmodifiableList = numbers17.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(unmodifiableList);
		System.out.println("----------------------------\n");


		// Question 23: Collecting to a map
		List<String> words5 = Arrays.asList("apple", "banana", "cherry", "date");
		Map<String, Integer> wordLengthMap = words5.stream().collect(Collectors.toMap(w -> w, String::length));
		System.out.println(wordLengthMap);
		// Output: {apple=5, banana=6, cherry=6, date=4}
		System.out.println("----------------------------\n");


		// Question 24: Finding the maximum value with a custom comparator
		List<String> words6 = Arrays.asList("apple", "banana", "cherry", "date");
		String longestWord = words6.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
		System.out.println("Longest word: " + longestWord); // Output: Longest word: banana
		System.out.println("----------------------------\n");


		// Question 25: Finding the minimum value with a custom comparator
		List<String> words7 = Arrays.asList("apple", "banana", "cherry", "date");
		String shortestWord = words7.stream().min(Comparator.comparingInt(String::length)).orElseThrow();
		System.out.println("Shortest word: " + shortestWord); // Output: Shortest word: date
		System.out.println("----------------------------\n");


		// Question 26: Grouping and counting elements
		List<String> words8 = Arrays.asList("apple", "banana", "cherry", "date", "apple", "cherry");
		Map<String, Long> wordCounts = words8.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		System.out.println(wordCounts);
		// Output: {banana=1, date=1, cherry=2, apple=2}
		System.out.println("----------------------------\n");


		// Question 27: Creating a list from a range of numbers
		List<Integer> range = IntStream.range(1, 10).boxed().collect(Collectors.toList());
		System.out.println(range); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println("----------------------------\n");


		// Question 28: Summarizing statistics of a stream
		List<Integer> numbers18 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		IntSummaryStatistics stats = numbers18.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println(stats);
		// Output: IntSummaryStatistics{count=8, sum=28, min=0, average=3.500000, max=8}
		System.out.println("----------------------------\n");


		// Question 29: Mapping and collecting to a set
		List<String> words9 = Arrays.asList("apple", "banana", "cherry", "date");
		Set<Integer> wordLengths = words9.stream().map(String::length).collect(Collectors.toSet());
		System.out.println(wordLengths); // Output: [4, 5, 6]
		System.out.println("----------------------------\n");


		// Question 30: Filtering distinct elements and sorting
		List<Integer> numbers19 = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);
		List<Integer> distinctSorted = numbers19.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(distinctSorted); // Output: [0, 1, 2, 3, 4, 6, 8]
		System.out.println("----------------------------\n");

	}

}
