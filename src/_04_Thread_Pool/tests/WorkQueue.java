package _04_Thread_Pool.tests;

public class WorkQueue implements Runnable {
	private Thread[] threads;

	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors();
		threads = new Thread[totalThreads];
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
