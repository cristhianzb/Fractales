package view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import model.Mandelbrot;

public class WindowController {
	@FXML
	private AnchorPane  pane;
	
	@FXML
	private Button btnBorrar;
	
	@FXML
	private Button btnDibujar;
	
	@FXML
	private Canvas canvas;
	
	private Mandelbrot mandelbrot;
	
	public WindowController(){
		mandelbrot = new Mandelbrot();		
	}
	
	@FXML
	private void borrar(){
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	
	
	
	@FXML
	private void dibujar(){
		
		GraphicsContext g = canvas.getGraphicsContext2D();
		WritableImage image = canvas.snapshot(null, null);
		mandelbrot.draw(image);
		g.drawImage(image, 0, 0);
		
	}
	
	
	
	
	
}
