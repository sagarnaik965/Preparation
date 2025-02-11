package com.javatechie.thread;

public class SimpleThread extends Thread {

	public void run() {
		System.out.println("Giving implementation to t2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1 Simply how thread gets created w/o giving implementation
		 */

//		Thread t1 = new Thread();
//		t1.start();

		/*
		 * 2 Simply how thread gets created with giving implementation
		 */

//		SimpleThread t2 = new SimpleThread();
//		t2.start();

		/*
		 * 3 Simply how thread gets created with giving implementation using anonymously
		 * for run method
		 */

//		Thread t3 = new Thread(()->{
//			System.out.println("Implementation for thread call  T3 ");
//		});
//		t3.start();

		/*
		 * 4 Above all were outdated approach for it runnable interface (task) now we
		 * need to give this task to Thread
		 */

//		Runnable r1 = new Runnable() {		
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Implementation for thread call  Runnable R1 ");				
//			}
//		};

		Runnable r1 = () -> {
			System.out.println("Implementation for thread call  Runnable R1 " + " " + Thread.currentThread().getState()
					+ " " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread R1 is terminated!");
		};

		Thread r = new Thread(r1);
		r.setDaemon(true);
		r.start();
		System.out.println("Main Thread Got Ended");

		/*MAIN THREAD GETS EXECUTED W/O WAITING FOR USER THREAD TO BE EXECUTED/ENDED
		 * 
		 * Explanation: Daemon Thread: The thread r is set as a daemon thread using
		 * r.setDaemon(true);. Daemon threads are low-priority threads that run in the
		 * background to perform tasks such as garbage collection. They do not prevent
		 * the JVM from exiting when all user threads (non-daemon threads) have finished
		 * their execution.
		 * 
		 * Main Thread Execution:
		 * 
		 * The main thread starts the daemon thread r and immediately prints
		 * "Main Thread Got Ended". Since the main thread is a non-daemon thread, it
		 * terminates right after printing the message. Daemon Thread Execution:
		 * 
		 * The daemon thread r begins execution and prints its initial message. However,
		 * because the main thread terminates almost immediately, the JVM exits, causing
		 * the daemon thread to be terminated prematurely. As a result, the daemon
		 * thread will not complete its sleep duration or print the termination message.
		 * 
		 * In output you see System.out.println("Thread R1 is terminated!"); not printed
		 * Because by the time main thread gets executed causing JVM exist as Main
		 * thread is also non-daemon Thread.
		 */
	}

}
