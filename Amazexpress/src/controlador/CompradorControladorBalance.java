package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class CompradorControladorBalance {
	@FXML
    private Button cerrarSesion;

    @FXML
    private Button perfilBoton;

    @FXML
    private Button mensajesBoton;

    @FXML
    private Button balanceBoton;

    @FXML
    private Button tiendaBoton;

    @FXML
    private Button productosBoton;

    @FXML
    private Button historialBoton;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    void initialize() {
    	inicializarBotones();
    }
    
    private void inicializarBotones() {
		// TODO Auto-generated method stub
		cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/LoginUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		
		tiendaBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/CompradorUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		
		perfilBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/CompradorPerfil.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		
		mensajesBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/CompradorMensajesUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		
		productosBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/CompradorProductosUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		historialBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/CompradorHistorialUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
	}
	
	private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		root.getChildren().removeAll();
    	root.getChildren().setAll(ventana);
    }
}
