package com.javatechie.thread;

public class VisibilityProblemResolvedWithSynchronized {

	private static boolean flag = false;

	public static void main(String[] args) {
		Thread writerThread = new Thread(() -> {
			System.out.println("Writer Thread:started " + " " + Thread.currentThread().getId());

			synchronized (VisibilityProblemResolvedWithSynchronized.class) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = true;
				System.out.println("Writer Thread: Updated the flag to true");
			}
		});

		Thread readerThread = new Thread(() -> {
			System.out.println("Reader Thread:started " + " " + Thread.currentThread().getId());

			synchronized (VisibilityProblemResolvedWithSynchronized.class) {
				while (!flag) {
					// Busy-wait
				}
				System.out.println("Reader Thread: Detected the flag change to true");
			}
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
