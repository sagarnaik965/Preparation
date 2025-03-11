package com.javatechie.thread;

//🔎 Expected Behavior Without join()
//The main thread might print the value of count before both threads finish incrementing.
//The final count might be less than 2000 because the main thread could read it prematurely.


class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
    	System.out.println("Threads Started !!");
        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //OR 
        
        Thread.sleep(3000);
        
        // Get final count
        System.out.println("Final Count: " + counter.getCount());
    }
}

