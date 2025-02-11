package com.javatechie.thread;

public class VisibilityProblemResolved {

//    private static  boolean flag = false;
    private static volatile  boolean flag = false;
    
	/*
	 * This demonstrates that the volatile keyword ensures that the change to the
	 * flag variable made by the writer thread is immediately visible to the reader
	 * thread, resolving the visibility problem. IF WE REMOVE VOLATILE KEYWORD YOU
	 * CAN SEE READER LOOP CONTINUES FOR INFINITE TIME I.E VISIBILITY ISSUE
	 * 
	 * BUT WHY THIS IS ARRIVING IN CASE OF MULTI THREADING 
	 * SEE IN LAST
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Thread writerThread = new Thread(() -> {
	            System.out.println("Writer Thread:started "+" "+Thread.currentThread().getId());

	            try {
	                // Simulate some work with sleep for 2 secondd
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            // Update the volatile variable
	            flag = true;
	            System.out.println("Writer Thread: Updated the flag to true"+" "+Thread.currentThread().getId());
	        });

	        Thread readerThread = new Thread(() -> {
	            System.out.println("Reader Thread:started "+" "+Thread.currentThread().getId());

	            // Wait for the flag to be updated
	            while (!flag) {
	                // Busy-wait
	            }
	            System.out.println("Reader Thread: Detected the flag change to true"+" "+Thread.currentThread().getId());
	        });

	        writerThread.start();
	        readerThread.start();

	        try {
	            writerThread.join();
	            readerThread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	}


	/*
	 * The visibility issue in multi-threaded applications occurs due to how the
	 * Java Memory Model (JMM) handles the interaction between threads and memory.
	 * Here are the key reasons why visibility issues occur:
	 * 
	 * 1. CPU Caches and Main Memory CPU Caches: Modern processors use caches to
	 * store frequently accessed data. Each thread may run on a different CPU core,
	 * and each core has its own cache. Main Memory: The main memory (RAM) is shared
	 * among all cores.
	 * 
	 * 2. Thread Local Caches When a thread reads or writes to a variable, it often
	 * caches the variable's value locally to improve performance. Without proper
	 * synchronization, changes made to a variable by one thread may not be
	 * immediately visible to other threads because the update might only occur in
	 * the local cache and not be written back to the main memory.
	 * 
	 * 3. Java Memory Model (JMM) The JMM defines how threads interact through
	 * memory and what behaviors are allowed in a multi-threaded environment. It
	 * allows threads to cache variables and perform certain optimizations that can
	 * lead to visibility issues if not properly synchronized.
	 */

