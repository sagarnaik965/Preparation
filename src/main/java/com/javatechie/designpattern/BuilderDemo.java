package com.javatechie.designpattern;

//Step 1: Define the Class and Builder (Static Inner Class)
class User {
 private String firstName;
 private String lastName;
 private int age;
 private String email;
 private String phone;

 // Private constructor (Only accessible by the Builder)
 private User(UserBuilder builder) {
     this.firstName = builder.firstName;
     this.lastName = builder.lastName;
     this.age = builder.age;
     this.email = builder.email;
     this.phone = builder.phone;
 }

 // Builder Class (Static Inner Class)
 public static class UserBuilder {
     private String firstName;
     private String lastName;
     private int age;
     private String email;
     private String phone;

     // Mandatory fields included in constructor
     public UserBuilder(String firstName, String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;
     }

     // Optional fields added using chaining methods
     public UserBuilder age(int age) {
         this.age = age;
         return this;
     }

     public UserBuilder email(String email) {
         this.email = email;
         return this;
     }

     public UserBuilder phone(String phone) {
         this.phone = phone;
         return this;
     }

     // Build method creates the final User object
     public User build() {
         return new User(this);
     }
 }

 // Display User Details (Optional)
 @Override
 public String toString() {
     return "User { " +
             "firstName='" + firstName + '\'' +
             ", lastName='" + lastName + '\'' +
             ", age=" + age +
             ", email='" + email + '\'' +
             ", phone='" + phone + '\'' +
             " }";
 }
}

//Step 2: Test the Builder Pattern in Main Class
public class BuilderDemo {
 public static void main(String[] args) {
     // Create User object using Builder
     User user1 = new User.UserBuilder("John", "Doe")
             .age(30)
             .email("john.doe@example.com")
             .phone("123-456-7890")
             .build();

     User user2 = new User.UserBuilder("Jane", "Smith")
             .email("jane.smith@example.com")
             .build();

     // Display user details
     System.out.println(user1);
     System.out.println(user2);
 }
}

