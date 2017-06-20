package view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;

public class WindowController {
	@FXML
	private AnchorPane  pane;
	
	@FXML
	private Button btnBorrar;
	
	@FXML
	private Button btnDibujar;
	
	@FXML
	private Canvas canvas;
	
	@FXML
	private void borrar(){
		System.out.println("se esta borrando");
	}
	
	@FXML
	private void dibujar(){
		GraphicsContext g = canvas.getGraphicsContext2D();
		
		WritableImage imagen = canvas.snapshot(null, null);
		
	}
	
	
	
	
	
}
