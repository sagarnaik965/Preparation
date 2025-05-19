package com.javatechie.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		List<Integer> inp = Arrays.asList(1, 3, 6, 2, 8, 0, 4, 4);

		// separate even and odd
		Map<Boolean, List<Integer>> oddEven = inp.stream().collect(Collectors.partitioningBy(t -> t % 2 == 0));

		System.out.println("Even " + oddEven.get(true));
		System.out.println("odd " + oddEven.get(false) + "\n");

		// Most Repeated no from array
		Map<Object, Long> mostReptNos = inp.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
		System.out.println("mostReptNos " + mostReptNos.entrySet().stream().max(Map.Entry.comparingByValue()) + "\n");

		List<List<Integer>> inp1 = Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 0)));
		List<Integer> flatList = inp1.stream().flatMap(t -> t.stream()).collect(Collectors.toList());
		System.out.println("Flatten list : " + flatList + "\n");

		// 1️⃣ Find the Second Highest Number
		List<Integer> numbers1 = Arrays.asList(10, 5, 20, 8, 20, 5, 10, 15);
		Optional<Integer> secondHighest = numbers1.stream().distinct().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst();
		System.out.println("Second Highest Number: " + secondHighest.orElse(null) + "\n");

		// 2️⃣ Find Duplicate Elements
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 1);
		Set<Integer> seen = new HashSet<>();
		List<Integer> duplicates = numbers2.stream().filter(n -> !seen.add(n)).distinct().collect(Collectors.toList());
		System.out.println("Duplicates: " + duplicates + "\n");

		// 3️⃣ Sort a List Based on String Length (Descending Order)
		List<String> words1 = Arrays.asList("Java", "StreamAPI", "Lambda", "Collectors", "Functional");
		List<String> sortedWords = words1.stream().sorted(Comparator.comparingInt(String::length).reversed())
				.collect(Collectors.toList());
		System.out.println("Sorted by length (desc): " + sortedWords + "\n");

		// 4️⃣ Find the Longest Word in a List
		List<String> words2 = Arrays.asList("apple", "banana", "grapefruit", "kiwi", "strawberry");
		String longestWord = words2.stream().max(Comparator.comparingInt(String::length)).orElse(null);
		System.out.println("Longest Word: " + longestWord + "\n");

		// 5️⃣ Count Words Starting with 'S'
		List<String> words3 = Arrays.asList("Stream", "Java", "Lambda", "Spring", "SpringBoot", "Streams");
		long count = words3.stream().filter(word -> word.startsWith("S")).count();
		System.out.println("Words starting with 'S': " + count + "\n");

		// 6️⃣ Find the First Non-Repeating Character in a String
		String input = "swiss";
		Character firstNonRepeating = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println("First Non-Repeating Character: " + firstNonRepeating + "\n");

		// 6️⃣ Find the Occurance of Character in a String
		Map<Object, Long> occuranceOfStr = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

		System.out.println("OccuranceOfStr Character: " + occuranceOfStr + "\n");

		// 7️⃣ Find the Most Frequent Number
		List<Integer> numbers3 = Arrays.asList(4, 2, 2, 8, 4, 4, 5, 8, 8, 8, 9);
		Integer mostFrequent = numbers3.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		System.out.println("Most Frequent Number: " + mostFrequent + "\n");

		// 8️⃣ Convert a List of Strings to Uppercase
		List<String> words4 = Arrays.asList("java", "stream", "lambda", "functional");
		List<String> upperCaseWords = words4.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("Uppercase Words: " + upperCaseWords + "\n");

		// 9️⃣ Concatenate All Strings in a List
		List<String> words5 = Arrays.asList("Apple", "Banana", "Cherry", "Date");
		String joinedString = words5.stream().collect(Collectors.joining(", "));
		System.out.println("Concatenated String: " + joinedString + "\n");

		// 🔟 Find the Sum of All Even Numbers
		List<Integer> numbers4 = Arrays.asList(3, 5, 8, 10, 14, 7, 6, 2, 9);
		int sumOfEvens = numbers4.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("Sum of Even Numbers: " + sumOfEvens + "\n");

		// 11SQUARE EACH NO AND REMOVE DUPLICATE
		List<Integer> squares = inp.stream().map(n -> n * n).distinct().collect(Collectors.toList());

		System.out.println(squares);

		// -12-Sort by frequency (most frequent first)
		List<Integer> sortedByFreq = inp.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().sorted(Entry.<Integer, Long>comparingByValue().reversed()).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		System.out.println(sortedByFreq);
		
		//-13-Find the average of only unique even numbers.
		OptionalDouble avg = inp.stream().filter(n->n%2==0).distinct().mapToInt(Integer::intValue).average();
		System.out.println(avg.orElse(-1)); 
		
		//-14- Create a map where key = number and value = square of number, only for numbers > 2 and even.
		inp.stream().filter(n->n%2==0 && n -> n >2).distinct()
		.collect(Collectors.toMap(Function.identity(), n->n*n));
		
		
		System.out.println("Find String and lenght with sorting orders....\n");
		// 11 Find String and lenght with sorting orders....
		List<String> inString = Arrays.asList("Apple", "Banana", "Cherry", "Date");
		inString.stream().sorted((o1, o2) -> o2.length() - o1.length())
				.forEach(s -> System.out.println(s + " " + s.length()));

		System.out.println("\n Find String and lenght with sorting orders....");

		inString.stream().sorted(Comparator.comparingInt(String::length).reversed())
				.forEach(s -> System.out.println(s + " " + s.length()));

		System.out.println("\n Sorting String");

		inString.stream().sorted().forEach(s -> System.out.println(s));
		System.out.println("\n Sorting with Reverse");
		inString.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

	}

}
