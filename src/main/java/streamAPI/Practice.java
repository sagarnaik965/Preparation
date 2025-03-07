package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 10, 15, 8, 49, 25, 98, 32 };
		List<Integer> list = Arrays.asList(10, 30, 1, 4, 111, 80, 80);
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");


		findEvenNumbers(list);
		findNumbersStartWith(list);
		distinctNumbers(list);
		findSecSmallestLargest(list);
		wordOccuranceCount(words);

	}

	private static void wordOccuranceCount(List<String> words) {
		// TODO Auto-generated method stub
		  Map<Object, Long> wordCount = words.stream()
	                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
	        System.out.println(wordCount); 
		
	}

	private static void findSecSmallestLargest(List<Integer> list) {
		// TODO Auto-generated method stub
		Integer secondSmallest = list.stream().distinct().sorted().skip(1).findFirst().orElse(null);

		// Find the second largest element
		Integer secondLargest = list.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst()
				.orElse(null);
		System.out.println("Second smallest element: " + secondSmallest);
		System.out.println("Second largest element:  " + secondLargest+"\n");

	}

	private static void distinctNumbers(List<Integer> list) {
		// TODO Auto-generated method stub
		System.out.println("Original List of numbers: " + list);
		// Remove duplicates
		List<Integer> distinctNumbers = list.stream().distinct().collect(Collectors.toList());
		System.out.println("After removing duplicates from the said list: " + distinctNumbers);
		System.out.println("\n");

	}

	private static void findNumbersStartWith(List<Integer> list) {
		// TODO Auto-generated method stub

		list.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
		System.out.println("\n");

	}

	private static void findEvenNumbers(List<Integer> list) {
		// TODO Auto-generated method stub
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		System.out.println("\n");

	}

}
