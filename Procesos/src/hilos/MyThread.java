package hilos;

public class MyThread extends Thread{

	private SuspendRequestor suspender = new SuspendRequestor();
	private boolean stopHilo= false;
	public void requestSuspend() { suspender.set(true); }
	public void requestResume() { suspender.set(false);}
	public void run() {
		try {
			while (true) {
				suspender.waitForResume();
			}
		}catch (InterruptedException exception) { }
	}

	public void pararHilo() {
		stopHilo = true;
	}

}
