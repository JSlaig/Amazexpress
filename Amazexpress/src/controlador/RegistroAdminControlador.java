package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.AmazexpressApp;

public class RegistroAdminControlador {
	
		private AmazexpressApp app;
	
	  	@FXML
	    private AnchorPane root;

	  	@FXML
	    private TextField apellidos;

	    @FXML
	    private Label estado;

	    @FXML
	    private Button cancelar;

	    @FXML
	    private PasswordField pass;

	    @FXML
	    private TextField telefono;

	    @FXML
	    private TextField nombre;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField nUsuario;

	    @FXML
	    private Button registro;
	    
	    
	    @FXML
	    void initialize() {
	    	
	    	app = AmazexpressApp.getSingletonInstancia();
	    	
	    	inicializarRegistrarBoton();
	    	inicializarCancelarBoton();
	    } 
	    
	    private void cargarVentana(String ruta) throws IOException {
			Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
			root.getChildren().removeAll();
	    	root.getChildren().setAll(ventana);
	    }
	    @FXML
		private void inicializarRegistrarBoton() {
		    	registro.setOnAction(new EventHandler<ActionEvent>() {
		    	    @Override public void handle(ActionEvent e) {    	        
							try {
								registro();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}					
		    	    }
		    	});
		}    
	    
	    private void registro() throws IOException {
			AmazexpressApp app = AmazexpressApp.getSingletonInstancia();
			
			String tipoCampo = "admin";    	
			
			app.registro(tipoCampo, nombre.getText(), apellidos.getText(), email.getText(), nUsuario.getText(), pass.getText(), telefono.getText());
			
			System.out.println("Registro correcto");
			estado.setText("Registro correcto");
			
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cargarVentana("/vista/AdminUI.fxml");
		}

	    @FXML
		private void inicializarCancelarBoton() {
		    	cancelar.setOnAction(new EventHandler<ActionEvent>() {
		    	    @Override public void handle(ActionEvent e) {    	        
							try {
								cargarVentana("/vista/AdminUI.fxml");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
		    	    }
		    	});
		}
}
