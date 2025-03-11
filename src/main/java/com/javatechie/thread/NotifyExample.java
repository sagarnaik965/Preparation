package com.javatechie.thread;

class SharedResourceNew {
    public void doWait() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            try {
                wait(); // Thread waits until notified
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is resumed after notify!");
        }
    }

    public void doNotify() {
        synchronized (this) {
            System.out.println("Notifying one thread...");
            notify(); // Notify one waiting thread
        }
    }
}

public class NotifyExample {
    public static void main(String[] args) {
        SharedResourceNew resource = new SharedResourceNew();

        // Thread 1 (will wait)
        Thread t1 = new Thread(() -> resource.doWait(), "Thread-1");
        
        // Thread 2 (will notify)
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000); // Ensure t1 starts waiting first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.doNotify();
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}

