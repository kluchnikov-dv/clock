package clock;

import javafx.scene.canvas.*;	//графический контекст
import javafx.scene.paint.*;	//цвет
import javafx.scene.shape.StrokeLineCap;

import java.util.Date;

interface ColorClockLine {
	Color COLOR_HOURE_LINE = Color.BLACK;
	Color COLOR_MINUTE_LINE = Color.BLACK;
	Color COLOR_SECONDS_LINE = Color.RED;
	
	public void paint();
}

//время
class Time implements ColorClockLine {	
	private ClockFace		clockFace; 		//циферблат
	private	ClockLine 		houreLine;		//стрелка часов
	private ClockLine   	minuteLine;		//стрелка минут
	private	ClockLine 		secondsLine;	//стрелка секунд
	private GraphicsContext	gc;				//грфический контекст
	
	//создать часы
	Time(double zoom, GraphicsContext gc) {		
		this.gc = gc;		
		clockFace = new ClockFace(zoom, gc);
		secondsLine = new ClockLine(zoom - 10, zoom, 1, COLOR_SECONDS_LINE, gc);
		minuteLine = new ClockLine(zoom - 30, zoom, 3, COLOR_MINUTE_LINE, gc);
		houreLine = new ClockLine(zoom - 60, zoom, 5, COLOR_HOURE_LINE, gc);
	}	
	
	
	//нарисовать часы с текущем временем
	public void paint() {		
		clockFace.paint();		
		Date date = new Date();				//дата время													
		 
		secondsLine.paint(90 - 6 * date.getSeconds());
		minuteLine.paint(90 - 6 * date.getMinutes());		 
		houreLine.paint(90 - (30 * date.getHours() + 6 * (date.getMinutes() / 12)));
	}
		
}
