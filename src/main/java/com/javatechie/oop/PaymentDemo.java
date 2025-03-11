package com.javatechie.oop;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PaymentDemo {

    // Parent class
    static class Payment {

        // Constructor (Cannot be overridden)
        Payment() {
            System.out.println("Payment constructor");
        }

        // Overridable method with protected visibility
        protected Payment processPayment() throws IOException {
            System.out.println("Processing generic payment");
            return new Payment();
        }

        // Final method (Cannot be overridden)
        public final void confirmPayment() {
            System.out.println("Payment confirmed");
        }

        // Static method (Can be hidden)
        public static void displayMessage() {
            System.out.println("Payment displayMessage");
        }
    }

    // Child class 1 - Overriding with covariant return type and narrower exception
    static class CreditCardPayment extends Payment {

        // Constructor
        CreditCardPayment() {
            super(); // Calls parent constructor
            System.out.println("CreditCardPayment constructor");
        }

        // Overriding with covariant return type and narrower exception
        @Override
        public CreditCardPayment processPayment() throws FileNotFoundException {
            System.out.println("Processing credit card payment");
            return new CreditCardPayment();
        }

        // Hiding static method (Not overriding)
        public static void displayMessage() {
            System.out.println("CreditCardPayment displayMessage");
        }
    }

    // Child class 2 - Overriding with same return type and no exception
    static class PayPalPayment extends Payment {

        // Constructor
        PayPalPayment() {
            super(); // Calls parent constructor
            System.out.println("PayPalPayment constructor");
        }

        // Overriding with the same return type and no exception
        @Override
        public Payment processPayment() {
            System.out.println("Processing PayPal payment");
            return new PayPalPayment();
        }

        // Hiding static method
        public static void displayMessage() {
            System.out.println("PayPalPayment displayMessage");
        }
    }

    // Main Method
    public static void main(String[] args) {
        try {
            System.out.println("====== POLYMORPHISM IN ACTION ======");

            // Polymorphism at work
            Payment payment = new CreditCardPayment(); // Dynamic binding
            payment.processPayment(); // Calls CreditCardPayment.processPayment()

            payment = new PayPalPayment(); // Dynamic binding
            payment.processPayment(); // Calls PayPalPayment.processPayment()

            // Confirm payment (final method) - From parent class
            payment.confirmPayment(); // Calls Payment.confirmPayment()

            System.out.println("\n====== STATIC METHOD HIDING ======");
            Payment.displayMessage(); // Calls Payment.displayMessage()
            CreditCardPayment.displayMessage(); // Calls CreditCardPayment.displayMessage()
            PayPalPayment.displayMessage(); // Calls PayPalPayment.displayMessage()

            System.out.println("\n====== DIRECT CHILD CLASS CALLS ======");
            new CreditCardPayment().processPayment();
            new PayPalPayment().processPayment();

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
