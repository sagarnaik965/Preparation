package com.javatechie.strings;

public class StringCreationExamples {
	   public static void main(String[] args) {
	        // 1. Creating a String using string literal
	        String str1 = "Hello, World!";
	        
	        // 2. Creating a String using the new keyword
	        String str2 = new String("Hello, World!");

	        // 3. Creating a String using character array
	        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
	        String str3 = new String(charArray);

	        // 4. Creating a String using StringBuilder
	        StringBuilder sb = new StringBuilder();
	        sb.append("Hello, World!");
	        String str4 = sb.toString();

	        // 5. Creating a String using StringBuffer
	        StringBuffer sbf = new StringBuffer();
	        sbf.append("Hello, World!");
	        String str5 = sbf.toString();
	    }

}
