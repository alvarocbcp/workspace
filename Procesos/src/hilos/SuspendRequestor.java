package hilos;

public class SuspendRequestor {
	private boolean suspendRequested;
	public synchronized void set(boolean b) {
	suspendRequested = b;
	notifyAll () ;
	}
	public synchronized void waitForResume()
	throws InterruptedException {
	while (suspendRequested)
	wait();
	}


}
