package com.javatechie.thread;

class SharedResource {
    private boolean isAvailable = false;

    // Consumer waits until producer produces
    public synchronized void consume() {
        while (!isAvailable) {
            try {
                System.out.println("Waiting for production...");
                wait(); // Wait until notified
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed the item!");
        isAvailable = false;
        notify(); // Notify producer that item is consumed
    }

    // Producer produces and notifies consumer
    public synchronized void produce() {
        while (isAvailable) {
            try {
                wait(); // Wait until item is consumed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Produced an item!");
        isAvailable = true;
        notify(); // Notify consumer
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.produce();
                try {
                    Thread.sleep(1000); // Simulate time to produce
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.consume();
                try {
                    Thread.sleep(500); // Simulate time to consume
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
