package com.javatechie.strings;

//GitHub impl
public class BasicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "abc";
//		String s2 = new String("abc");
//		s2.intern();					//here there is no assignment
//		
//		String s3="check";
//		s3=s2;
//		
//		String s4="check";
//		s4=s2.intern();
//		
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s3);
//		System.out.println(s1 == s4);

//		String s1 = "abc";
//		StringBuffer s2 = new StringBuffer(s1);
//		System.out.println(s1.equals(s2));
//		
//		The output is false because s2 is not of type String.
//		The equals() method implementation in the String class has an instanceof operator 
//		to check if the type of passed object is String and return false if the object is not String.

		/*
		 * How many String objects are created by the following code?
		 * 
		 * String s1 = new String("Hello"); String s2 = new String("Hello"); The answer
		 * is three. The code in line 1 creates a String object with the value Hello in
		 * the string pool (first object) and then creates a new String object with the
		 * value Hello in the heap memory (second object). The code in line 2 creates a
		 * new String object with value Hello in the heap memory (third object) and
		 * reuses the Hello string from the string pool.
		 */

		String s1 = "Java"; // "Java" String created in pool and reference assigned to s1

		String s2 = s1; // s2 is also having the same reference to "Java" in the pool

		System.out.println(s1 == s2); // proof that s1 and s2 have same reference

		s1 = "Python";
		// s1 value got changed above, so how String is immutable?

		// well, in above case a new String "Python" got created in the pool
		// s1 is now referring to the new String in the pool
		// BUT, the original String "Java" is still unchanged and remains in the pool
		// s2 is still referring to the original String "Java" in the pool

		// proof that s1 and s2 have different reference
		System.out.println(s1 == s2);

		System.out.println(s2);
		// prints "Java" supporting the fact that original String value is unchanged,
		// hence String is immutable

	}

}

/*
 * The intern() method returns the String object reference from the string pool.
 * if not present then will create new String Object
 */
