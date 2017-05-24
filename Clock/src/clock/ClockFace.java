package clock;

import javafx.scene.canvas.*;		//графический контекст
import javafx.scene.paint.*;		//цвет
import javafx.scene.shape.*;		//сектор-деление

interface ColorClockFace {
	Color COLOR_CLOCK_FACE_LINE = Color.BLACK;	//цвет линий
	Color COLOR_CLOCK_FACE = Color.WHITE ;		//цвет заполнения		
	
	public void paint();
}

//циферблат
class ClockFace implements ColorClockFace {
	private double zoom;	
	private GraphicsContext gc;
	
	private double x1;
	private double y1;
	private double x2;	
	private double y2;	
		
	ClockFace(double zoom, GraphicsContext gc) {
		this.zoom = zoom;
		this.gc = gc;		
		this.x1 = this.y1 = 0;		
		this.x2 = this.y2 = zoom;		
	}		
	
	//нарисовать циферблат
	public void paint() {
		gc.setLineWidth(1);														//толщина линий
		gc.setStroke(COLOR_CLOCK_FACE_LINE);									//цвет линий
		gc.setFill(COLOR_CLOCK_FACE);											//цвет заполнения						
		gc.fillOval(x1, y1, x2, y2);											//заполняем циферблат белым цветом						
		gc.strokeOval(x1, y1, x2, y2);											//рисуем круг циферблата
		
		//рисуем метки для часов
		gc.setLineWidth(10);													//толщина линий
		int x = 120;
		for(int i = 0; i < 12; i++) {
			x += 30;
			gc.strokeArc(10, 10, zoom -20, zoom -20, x, 1, ArcType.CHORD);		//рисуем хорды для часов
		}
		
		//рисуем метки для секунд и минут
		gc.setLineWidth(1);
		for(int i = 0; i < 60; i++) {
			x += 6;
			gc.strokeArc(10, 10, zoom - 20, zoom - 20, x, 1, ArcType.CHORD);	//рисуем хорды для секунд
		}
		
	}	
}