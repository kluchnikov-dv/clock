package clock;

import javafx.application.*;	//класс javafx
import javafx.stage.*;			//подмосток
import javafx.scene.*;			//сцена
import javafx.scene.layout.*;	//корневой узел
import javafx.scene.control.*;	//кнопки
import javafx.event.*;			//обработчик нажатия кнопок
import javafx.geometry.*;		//выравнивание FlowPane
//для рисования
import javafx.scene.canvas.*;	//холст


public class Clock extends Application {
	final double ZOOM_CLOCK = 333;
	
	Button exitButton = new Button("Выход");;			//кнопка для выхода	
	GraphicsContext gc;									//графический контекст
	
	public static void main(String[] args) {
		launch(args); 									//можно передать любой строковый параметр или вообще не передавать
	}
	
	public void start(Stage clockStage) {
	    	
    	clockStage.setTitle("Clock");										//задаем заголовок подмостка
    	FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);		//создаем корневой узел
    	rootNode.setAlignment(Pos.CENTER);									//выровнять все элементы сверху в центре  
    	clockStage.setScene(new Scene(rootNode, ZOOM_CLOCK + 50, ZOOM_CLOCK + 50));  				//создаем сцену и устанавливаем сцену на подмосток
    	
    	Canvas canvas = new Canvas(ZOOM_CLOCK, ZOOM_CLOCK);
    	gc = canvas.getGraphicsContext2D();
    	ClockThread timeThread = new ClockThread(ZOOM_CLOCK, gc);
    	
    	
    	rootNode.getChildren().addAll(canvas, exitButton);					//ввести элементы на сцену
    	clockStage.show();     												//Показываем подмосток и сцену   	
    	    	
    	
    	//обработчик нажатия кнопки выход
    	exitButton.setOnAction(new EventHandler<ActionEvent>() {	//зарегестрировать обработчик события для конкретной кнопки, при помощи setOnAction
    		public void handle(ActionEvent ae) {					//создать анонимный внутренний класс на основе интерфейса EventHandler
    			clockStage.close();									//реализовать единственный метод handle для обработки события
    			timeThread.stopThread = true;						//завершить поток с часами			
    		}
    	});
    	
    	//обработчик закрытия окна
    	clockStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    		public void handle(WindowEvent we) {
    			timeThread.stopThread = true;						//завершить поток с часами
    		}
    	});

	}

}
