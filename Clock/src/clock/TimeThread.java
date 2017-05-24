package clock;

import javafx.scene.canvas.*;

public class TimeThread implements Runnable {
	Thread timeThread;
	Time time;	
	GraphicsContext gc;
	double zoom;
	
	TimeThread(double zoom, GraphicsContext gc) {		
		this.zoom = zoom;
		this.gc = gc;
		timeThread = new Thread(this, "Clock");		
		timeThread.start();		
	}
	
	public void run() {		
		try {
			time = new Time(zoom, gc);
			
			while(true) {
				time.paint();
				Thread.sleep(1000);
			}
		} catch(InterruptedException ie) {
			System.out.println("Процесс прерван");
		}
		System.out.println(timeThread.getName() + " завершен.");		
	}
}
