package application;
	

import java.io.IOException;

import controlador.Control;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class Main extends Application {
	
	private AnchorPane panelInicio;
	private AnchorPane panelAccion;
	private Stage contenedor;
	
	@Override
	public void start(Stage stage) {
		this.contenedor = stage;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainVista.fxml"));
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("vista.fxml"));
		
		try {
			
			//Carga de Paneles
			panelInicio = (AnchorPane) loader.load();
			panelAccion = (AnchorPane) loader2.load();
			
			//Constructor del controlador
			Control c = loader.getController();
			c.main(contenedor, panelAccion);
			
			//Inicializamos y lanzamos la aplicación
			contenedor.setTitle("CC Channel");
			contenedor.setScene(new Scene(panelInicio));
			contenedor.centerOnScreen();
			contenedor.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
