package clock;

import javafx.scene.canvas.*;	//графический контекст
import javafx.scene.paint.*;	//цвет
import javafx.scene.shape.ArcType;

//циферблат
class ClockFace {	
	double x1;
	double y1;
	double x2;	
	double y2;	
	GraphicsContext gc;
	
	ClockFace(double x1, double y1, double x2, double y2, GraphicsContext gc) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;		
		this.y2 = y2;	
		this.gc = gc;
	}	
	
	void paint() {
		gc.setStroke(Color.BLACK);		
		gc.strokeOval(x1, y1, x2, y2);		//рисуем круг циферблата		
	}
	
	void clear() {
		gc.setFill(Color.WHITE);					
		gc.fillOval(x1, y1, x2, y2);		//заполняем циферблат белым цветом		
	}
}