package com.javatechie.strings;

import java.util.Arrays;

public class StringCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("areAnagrams = "+areAnagrams("1111","111"));
		
		//CHECK IF PALLINDROME OR NOT
		System.out.println("Pallindrome = "+isPalindrome("OYO"));
		
		//Q: Compress a string like "aabcccccaaa" to "a2b1c5a3". If compressed string is not smaller, return original.
		System.out.println("Compress = "+compress("aabcccccaaa"));
		
		//REVERSE A STRING W/O USING 3RD VARIBALE 
				System.out.println("Compress = "+compress("aabcccccaaa"));
	}
	
	public static boolean areAnagrams(String s1, String s2) {
	    if (s1.length() != s2.length()) return false;
	    
	    char[] arr1 = s1.toCharArray();
	    char[] arr2 = s2.toCharArray();
	    
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    
	    return Arrays.equals(arr1, arr2);
	}
	
	public static boolean isPalindrome(String s) {
	    int i = 0, j = s.length() - 1;
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) return false;
	    }
	    return true;
	}
	
	public static String compress(String s) {
		//aabcccccaaaaa
	    StringBuilder sb = new StringBuilder();
	    int count = 1;
	    for (int i = 1; i < s.length(); i++) {
	        if (s.charAt(i) == s.charAt(i - 1)) {
	            count++;
	        } else {
	            sb.append(s.charAt(i - 1)).append(count);
	            count = 1;
	        }
	    }
	    sb.append(s.charAt(s.length() - 1)).append(count);
	    return sb.length() < s.length() ? sb.toString() : s;
	}
	public static String reverseString(String str) {
	    char[] arr = str.toCharArray();
	    int i = 0, j = arr.length - 1;

	    while (i < j) {
	        arr[i] = (char)(arr[i] ^ arr[j]);
	        arr[j] = (char)(arr[i] ^ arr[j]);
	        arr[i] = (char)(arr[i] ^ arr[j]);
	        i++;
	        j--;
	    }

	    return new String(arr);
	}



}
