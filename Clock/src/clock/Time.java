package clock;

import javafx.scene.canvas.*;	//графический контекст
import javafx.scene.paint.*;	//цвет
import java.util.Date;


//время
class Time {	
	ClockFace		clockFace; 		//циферблат
	ClockLine 		houreLine;		//стрелка часов
	ClockLine   	minuteLine;		//стрелка минут
	ClockLine 		secondsLine;	//секундная стрелка
	GraphicsContext	gc;				//грфический контекст
	
	Time(double x1, double y1, double x2, double y2, GraphicsContext gc) {		
		this.gc = gc;
		Date date = new Date();															//дата время
		clockFace = new ClockFace(x1, y1, x2, y2, gc);										//циферблат
		
		
		secondsLine = new ClockLine(x1 + 5, y1 + 5, x2 - 10, y2 - 10, Color.RED, gc);		//стрелка показывающая секунды		
		secondsLine.firstAngle -= secondsLine.step * date.getSeconds();
		
		minuteLine = new ClockLine(x1 + 30, y1 + 30, x2 - 60, y2 - 60, Color.BLACK, gc);	//стрелка показывающая часы		
		minuteLine.firstAngle -= minuteLine.step * date.getMinutes();
		
		houreLine = new ClockLine(x1 + 60, y1 + 60, x2 - 120, y2 - 120, Color.BLACK, gc);	//стрелка показывающая часы		
		houreLine.firstAngle -= (houreLine.step * 5)  * date.getHours() + houreLine.step * (date.getMinutes() / 12);		
	}	
	
	
	
	void tickTack() {		
		clockFace.clear();		
		Date date = new Date();															//дата время
		
		secondsLine.paint();
		secondsLine.initFirstAngle();
		secondsLine.firstAngle -= secondsLine.step * date.getSeconds();
		
		
		minuteLine.paint();
		minuteLine.initFirstAngle();
		minuteLine.firstAngle -= minuteLine.step * date.getMinutes();
				

		houreLine.paint();
		houreLine.initFirstAngle();
		houreLine.firstAngle -= (houreLine.step * 5)  * date.getHours() + houreLine.step * (date.getMinutes() / 12);
	}
		
}
