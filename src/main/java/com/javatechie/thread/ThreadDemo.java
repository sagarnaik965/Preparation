package com.javatechie.thread;

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " finished!");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started...");

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        // Start threads
        t1.start();
        t2.start();

        try {
            // Wait for t1 to finish before continuing
            t1.join(); 
            System.out.println("t1 finished, now waiting for t2...");
            t2.join(); // Wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished!");
    }
}

