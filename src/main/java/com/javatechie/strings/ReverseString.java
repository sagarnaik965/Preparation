package com.javatechie.strings;

public class ReverseString {

    public static String reverseString(String s) {
        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;

        while (left < right) {
            // Swap characters
            sArray[left] ^= sArray[right];
            sArray[right] ^= sArray[left];
            sArray[left] ^= sArray[right];
            left++;
            right--;
        }

        return new String(sArray);
    }

    public static String removeWhiteSpaces(String input) {
    	StringBuilder output = new StringBuilder();
    	
    	char[] charArray = input.toCharArray();
    	
    	for (char c : charArray) {
    		if (!Character.isWhitespace(c))
    			output.append(c);
    	}
    	
    	return output.toString();
    }
    public static void main(String[] args) {
        String s = " h ell ";
        System.out.println("Original string: " + s);
        
        System.out.println("RemovedSpaces string: " + removeWhiteSpaces(s));
        String reversedS = reverseString(s);
      
        System.out.println("Reversed string: " + reversedS);
    }
}