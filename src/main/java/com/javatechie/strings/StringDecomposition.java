package com.javatechie.strings;

public class StringDecomposition {

	public static void main(String[] args) {

		String tobeRevers = "India is my country";
		String[] arrString = tobeRevers.split(" ");
		StringBuilder op = new StringBuilder();
//		for (String in : arrString) {

		String in = "India is my country";
		StringBuilder reversedSentence = new StringBuilder();

		for (int i = arrString.length - 1; i >= 0; i--) {
			reversedSentence.append(arrString[i]);

			if (i != 0) {
				reversedSentence.append(" ");
			}
		}

//		}

		System.out.println(reversedSentence.toString());

	}

}
