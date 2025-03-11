package com.javatechie.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiArrayStringExamples {
    public static void main(String[] args) {
        // Example 1: Array of integers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Filter even numbers
        int[] evenNumbers = IntStream.of(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
        System.out.println("Even numbers: " + Arrays.toString(evenNumbers));

        // Map numbers to their squares
        int[] squaredNumbers = IntStream.of(numbers)
                .map(n -> n * n)
                .toArray();
        System.out.println("Squared numbers: " + Arrays.toString(squaredNumbers));

        // Sum of all numbers
        int sum = IntStream.of(numbers).sum();
        System.out.println("Sum of numbers: " + sum);

        // Example 2: Array of strings
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

        // Filter words with length greater than 5
        String[] longWords = Arrays.stream(words)
                .filter(word -> word.length() > 5)
                .toArray(String[]::new);
        System.out.println("Words with length greater than 5: " + Arrays.toString(longWords));

        // Map words to uppercase
        String[] uppercaseWords = Arrays.stream(words)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println("Uppercase words: " + Arrays.toString(uppercaseWords));

        // Concatenate all words
        String concatenatedWords = Arrays.stream(words)
                .reduce("", (a, b) -> a + b);
        System.out.println("Concatenated words: " + concatenatedWords);

        // Example 3: List of strings
        List<String> sentences = Arrays.asList(
                "Java is a programming language.",
                "Stream API is powerful.",
                "Coding is fun."
        );

        // Flatten list of sentences to list of words
        List<String> allWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println("All words: " + allWords);

        // Count the number of words in all sentences
        long wordCount = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .count();
        System.out.println("Word count: " + wordCount);

        // Group words by their first letter
        Map<Character, List<String>> wordsByFirstLetter = allWords.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("Words grouped by first letter:");
        wordsByFirstLetter.forEach((letter, wordList) -> {
            System.out.println(letter + ": " + wordList);
        });

        // Find the longest word
        String longestWord = allWords.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("Longest word: " + longestWord);
    }
}
