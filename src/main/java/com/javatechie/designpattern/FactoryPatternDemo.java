//package com.javatechie.designpattern;
//
////Step 1: Create an Interface
//interface Notification {
// void notifyUser();
//}
//
////Step 2: Create Concrete Classes
//class SMSNotification implements Notification {
// @Override
// public void notifyUser() {
//     System.out.println("Sending an SMS notification");
// }
//}
//
//class EmailNotification implements Notification {
// @Override
// public void notifyUser() {
//     System.out.println("Sending an Email notification");
// }
//}
//
//class PushNotification implements Notification {
// @Override
// public void notifyUser() {
//     System.out.println("Sending a Push notification");
// }
//}
//
////Step 3: Create Factory Class
//class NotificationFactory {
//
// // Factory Method
// public Notification createNotification(String type) {
//     if (type == null || type.isEmpty()) {
//         return null;
//     }
//     switch (type.toLowerCase()) {
//         case "sms":
//             return new SMSNotification();
//         case "email":
//             return new EmailNotification();
//         case "push":
//             return new PushNotification();
//         default:
//             throw new IllegalArgumentException("Unknown notification type: " + type);
//     }
// }
//}
//
////Step 4: Main Class to Test
//public class FactoryPatternDemo {
// public static void main(String[] args) {
//
//     // Create Factory
//     NotificationFactory factory = new NotificationFactory();
//
//     // Get SMS Notification Object
//     Notification sms = factory.createNotification("sms");
//     sms.notifyUser();
//
//     // Get Email Notification Object
//     Notification email = factory.createNotification("email");
//     email.notifyUser();
//
//     // Get Push Notification Object
//     Notification push = factory.createNotification("push");
//     push.notifyUser();
// }
//}
//
