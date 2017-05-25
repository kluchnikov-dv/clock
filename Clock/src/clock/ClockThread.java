package clock;

import javafx.scene.canvas.*;

public class ClockThread implements Runnable {
	public Thread 	clockThread;
	public boolean stopThread = false;
	
	private ClockMounted clockMounted;	
	private GraphicsContext gc;
	private double zoom;	
	
	ClockThread(double zoom, GraphicsContext gc) {		
		this.zoom = zoom;
		this.gc = gc;
		clockThread = new Thread(this, "Clock");		
		clockThread.start();		
	}
	
	public void run() {		
		try {
			clockMounted = new ClockMounted(zoom, gc);
			
			while(!stopThread) {
				clockMounted.paint();
				Thread.sleep(1000);
			}
		} catch(InterruptedException ie) {
			System.out.println(clockThread.getName() + "прерван.");
		}
		System.out.println(clockThread.getName() + " завершен.");		
	}
}
