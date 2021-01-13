package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import modelo.AmazexpressApp;

public class AdminControladorVendedor {

    @FXML
    private AnchorPane root;
    
    @FXML
    private Label nUsuarios;
    
    private AmazexpressApp app;
    
    @FXML
    private Button crearAdmin;
    
    @FXML
    private Button cerrarSesion;
    
    @FXML
    private Button inicioBoton;
    
    @FXML
    private Button administradoresBoton;
   
    @FXML
    private Button compradoresBoton;
    
    @FXML
    void initialize() {
    	
    	app = AmazexpressApp.getSingletonInstancia();
    	
    	nUsuarios = new Label(app.getUserNumber() + " usuarios");
    	//nUsuarios.setText();
    	
    	//Inicializaciones
    	inicializarCrearAdminBoton();
    	inicializarCerrarSesion();
    	
    	inicializarBotonNavegacion();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
    } 
    
    @FXML
	private void inicializarCerrarSesion() {
	    	cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override public void handle(ActionEvent e) {    	        
						try {
							cargarVentana("/vista/LoginUI.fxml");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
	    	    }
	    	});
	}
    
    @FXML
 	private void inicializarBotonNavegacion() {
 	    	inicioBoton.setOnAction(new EventHandler<ActionEvent>() {
 	    	    @Override public void handle(ActionEvent e) {    	        
 						try {
 							cargarVentana("/vista/AdminUI.fxml");
 						} catch (IOException e1) {
 							// TODO Auto-generated catch block
 							e1.printStackTrace();
 						}					
 	    	    }
 	    	});
 	    	
 	    	compradoresBoton.setOnAction(new EventHandler<ActionEvent>() {
 	    	    @Override public void handle(ActionEvent e) {    	        
 						try {
 							cargarVentana("/vista/AdminUI_comprador.fxml");
 						} catch (IOException e1) {
 							// TODO Auto-generated catch block
 							e1.printStackTrace();
 						}					
 	    	    }
 	    	});
 	    	
 	    	administradoresBoton.setOnAction(new EventHandler<ActionEvent>() {
 	    	    @Override public void handle(ActionEvent e) {    	        
 						try {
 							cargarVentana("/vista/AdminUI_admin.fxml");
 						} catch (IOException e1) {
 							// TODO Auto-generated catch block
 							e1.printStackTrace();
 						}					
 	    	    }
 	    	});
 	}
    
    @FXML
	private void inicializarCrearAdminBoton() {
	    	crearAdmin.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override public void handle(ActionEvent e) {    	        
						try {
							cargarVentana("/vista/RegistroAdminUI.fxml");
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
