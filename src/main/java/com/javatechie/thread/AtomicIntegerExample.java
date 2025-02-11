package com.javatechie.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	
	/*
	 * you can remove atomic word also to check weather o/p is correct or not We can
	 * also Use SYNCHRONIZE keyword on incremental Method
	 * basically This is problem ::  why it happens 
	 * RACE
	 * 
	 * TO SOLVE READ EXPLAINATION FROM BELOW 
	 * 
	 */
	
//	private int counter = 0;
    private  AtomicInteger counter = new AtomicInteger(0);
    
    public  void incrementCounter () {
//    	counter++;
    	counter.incrementAndGet();
    }
    
    public int getCounter () {
//    	return counter;
    	return counter.get();
    }

    public static void main(String[] args) {
    	
    	//SHARED RESOURCE/OBJECT
    	AtomicIntegerExample atomicIntegerCounter = new AtomicIntegerExample();
    	
        Thread incrementer1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
            	atomicIntegerCounter.incrementCounter();
            }
        });

        Thread incrementer2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
            	atomicIntegerCounter.incrementCounter();

            }
        });

        incrementer1.start();
        incrementer2.start();

        try {
            incrementer1.join();
            incrementer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + atomicIntegerCounter.getCounter());
    }
}

/*
 * #### `synchronized` Keyword - Ensures mutual exclusion (only one thread can
 * access a block of code at a time). - Provides both visibility and atomicity.
 * - Used to protect critical sections of code. - Guarantees that changes made
 * by one thread are visible to other threads. - Can lead to thread contention
 * and reduced performance if overused.
 * 
 * #### `volatile` Keyword - Ensures visibility of changes to variables across
 * threads. - Does not ensure atomicity. - Used for variables accessed by
 * multiple threads without requiring a lock. - Changes to a `volatile` variable
 * are always visible to other threads. - Useful for flags or state indicators.
 * 
 * #### `Atomic` Classes (e.g., `AtomicInteger`, `AtomicLong`) - Provides atomic
 * operations for single variables without using synchronization. - Ensures
 * atomicity and visibility for operations on single variables. - More efficient
 * than using `synchronized` for simple operations. - Part of the
 * `java.util.concurrent.atomic` package.
 */

//
//### Tabular Format
//
//| Feature                  | `synchronized`           | `volatile`             | `AtomicInteger` (and other `Atomic` classes) |
//|--------------------------|--------------------------|-------------------------|----------------------------------------------|
//| Visibility               | Yes                      | Yes                     | Yes                                          |
//| Atomicity                | Yes                      | No                      | Yes                                          |
//| Use Case                 | Critical sections        | Flags/state indicators  | Atomic operations on single variables        |
//| Performance Impact       | Can lead to contention   | Low                     | Efficient for simple operations              |
//| Synchronization Required | Yes                      | No                      | No                                           |
//| Example Usage            | Protect shared resources | Ensure variable visibility | Counters and simple atomic operations        |


