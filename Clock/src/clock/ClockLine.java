package clock;

import javafx.scene.canvas.*;	//графический контекст
import javafx.scene.paint.*;	//цвет
import javafx.scene.shape.*;	//сектор-стрелка

//стрелка
class ClockLine {
	double	x1;	
	double	y1;
	double	x2;
	double	y2;	
	double	firstAngle	= 90; 		//начальный угол
	double	extentArc	= 0;	 	//длина сектора			
	double  step = 360 / 60;		//1 деление в градусах
	Color	color;					//цвет линии
	GraphicsContext gc;
	 
	
	ClockLine(double x1, double y1, double x2, double y2, Color color, GraphicsContext gc) {		
		this.x1 = x1;		
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.gc = gc;
	}	
	
	void initFirstAngle() {
		firstAngle = 90;
	}
	
	void paint() {
		gc.setStroke(color);
		gc.strokeArc(x1, y1, x2, y2, firstAngle, extentArc, ArcType.ROUND); //рисуем стрелку
	}	
}
