package clock;

import javafx.scene.canvas.*;

public class TimeThread implements Runnable {
	Thread timeThread;
	Time time;	
	GraphicsContext gc;	
	
	TimeThread(GraphicsContext gc) {
		this.gc = gc;
		timeThread = new Thread(this, "Clock");		
		timeThread.start();		
	}
	
	public void run() {
		
		time = new Time(0, 0, 210, 210, gc);
		time.clockFace.paint();
		
		try {
			time = new Time(0, 0, 210, 210, gc);
			
			while(true) {
				time.tickTack();
				Thread.sleep(1000);
			}
		} catch(InterruptedException ie) {
			System.out.println("Процесс прерван");
		}
		System.out.println(timeThread.getName() + " завершен.");		
	}
}
