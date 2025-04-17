package com.javatechie.streamAPI;

import java.util.*;

//Example of Comparable interface
class Student implements Comparable<Student> {
 private String name;
 private int age;

 public Student(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 @Override
 public int compareTo(Student other) {
     return this.age - other.age; // Sorting by age in ascending order
 }

 @Override
 public String toString() {
     return "Student{name='" + name + "', age=" + age + "}";
 }


}

//Example of Comparator interface
class NameComparator implements Comparator<Student> {
 @Override
 public int compare(Student s1, Student s2) {
     return s1.getName().compareTo(s2.getName()); // Sorting by name in alphabetical order
 }
}

public class ComparableAndComparatorExample {
 public static void main(String[] args) {
     List<Student> students = new ArrayList<>();
     students.add(new Student("Bob", 21));
     students.add(new Student("Charlie", 25));
     students.add(new Student("Alice", 23));


     // Using Comparable to sort by age
     Collections.sort(students);
     System.out.println("Sorted by age (Comparable): " + students);

     // Using Comparator to sort by name
     Collections.sort(students, new NameComparator());
     System.out.println("Sorted by name (Comparator): " + students);
 }
}
