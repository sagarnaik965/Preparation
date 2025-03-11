package com.javatechie.designpattern;

//🚀 Why Factory Pattern Is Useful:
//✅ Centralizes object creation logic
//✅ Provides loose coupling
//✅ Improves maintainability and scalability
//✅ Reduces new keyword usage in client code

//Step 1: Create an Interface
interface Notification {
 void notifyUser();
}

//Step 2: Create Concrete Classes (Without Singleton)
class SMSNotification implements Notification {
 @Override
 public void notifyUser() {
     System.out.println("Sending an SMS notification");
 }
}

class EmailNotification implements Notification {
 @Override
 public void notifyUser() {
     System.out.println("Sending an Email notification");
 }
}

class PushNotification implements Notification {
 @Override
 public void notifyUser() {
     System.out.println("Sending a Push notification");
 }
}

//Step 3: Create Factory Class
class NotificationFactory {

 // ==================== Cache Part ====================
 // Uncomment below to enable caching
 // private static final Map<String, Notification> cache = new HashMap<>();
 // =====================================================

 public Notification createNotification(String type) {
     if (type == null || type.isEmpty()) {
         return null;
     }

     // ==================== Cache Lookup ====================
     // Uncomment below to enable caching
     /*
     if (cache.containsKey(type.toLowerCase())) {
         return cache.get(type.toLowerCase());
     }
     */
     // =====================================================

     Notification notification;
     switch (type.toLowerCase()) {
         case "sms":
             notification = new SMSNotification(); // New object every time
             break;
         case "email":
             notification = new EmailNotification();
             break;
         case "push":
             notification = new PushNotification();
             break;
         default:
             throw new IllegalArgumentException("Unknown notification type: " + type);
     }

     // ==================== Add to Cache ====================
     // Uncomment below to enable caching
     /*
     cache.put(type.toLowerCase(), notification);
     */
     // =====================================================

     return notification;
 }
}

//Step 4: Main Class to Test
public class FactoryDemoSingleton {
 public static void main(String[] args) {

     // Create Factory
     NotificationFactory factory = new NotificationFactory();

     // Get Notification objects
     Notification sms1 = factory.createNotification("sms");
     sms1.notifyUser();

     Notification sms2 = factory.createNotification("sms");
     sms2.notifyUser();

     // Check if both objects are same instance
     System.out.println("sms1 == sms2 : " + (sms1 == sms2)); // Should print false if cache is disabled, true if enabled

     Notification email1 = factory.createNotification("email");
     email1.notifyUser();

     Notification email2 = factory.createNotification("email");
     email2.notifyUser();

     System.out.println("email1 == email2 : " + (email1 == email2)); // Should print false if cache is disabled, true if enabled

     Notification push1 = factory.createNotification("push");
     push1.notifyUser();

     Notification push2 = factory.createNotification("push");
     push2.notifyUser();

     System.out.println("push1 == push2 : " + (push1 == push2)); // Should print false if cache is disabled, true if enabled
 }
}

