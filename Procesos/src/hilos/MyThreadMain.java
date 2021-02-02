package hilos;

public class MyThreadMain extends Thread{

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		try {
			mt.start();
			Thread.sleep(10000);
			mt.requestSuspend();
			Thread.sleep(10000);
			mt.requestResume();
			mt.pararHilo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
