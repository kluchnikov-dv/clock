package clock;

import javafx.scene.canvas.*;	//графический контекст
import javafx.scene.paint.*;	//цвет
import javafx.scene.shape.*;	//сектор-стрелка

//стрелка часов
class ClockLine {
	private double	length;				//длина стрелки
	private double	zoom;				//размер циферблата	
	private double	width;				//толщина стрелки
	private Color	color;				//цвет линии
	private GraphicsContext gc;			//графический контекст
	
	private double	x1;	
	private double	y1;
	private double	x2;
	private double	y2;	

	//создать стрелку
	ClockLine(double length, double zoom, double width, Color color, GraphicsContext gc) {		
		this.zoom = zoom;
		this.width = width;	
		this.x1 = this.y1 = zoom - length;
		this.x2 = this.y2 = zoom - 2 * (zoom - length);		
		this.color = color;
		this.gc = gc;
	}	
	
	//нарисовать стрелку под углом в градусах
	public void paint(double Angle) {		
		gc.setLineWidth(width);
		gc.setStroke(color);
		gc.strokeArc(x1, y1, x2, y2, Angle, 0, ArcType.ROUND); //рисуем стрелку		
	}	
}
