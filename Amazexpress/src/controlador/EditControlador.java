package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AmazexpressApp;

public class EditControlador {
	
		@FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private Button cancelar;

	    @FXML
	    private Button actualizar;
	    
	    private static AmazexpressApp app;
	     
	    private static String tipo;
	    private static int id;
	    
	     
	    public static void setTipo(String type) {
	    	tipo = type;
	    }
	    
	    public static void setId(int idEdit) {
	    	id = idEdit;
		}
	    
	    @FXML
	    void initialize() {
	    	
	    	app.getSingletonInstancia();
	    	
	    	inicializarCancelar();
	    	inicializarActualizar();
	    	
	    	inicializarCampos();
	    	
	        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'EditUI.fxml'.";
	        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'EditUI.fxml'.";
	        assert actualizar != null : "fx:id=\"actualizar\" was not injected: check your FXML file 'EditUI.fxml'.";

	    }


		public void inicializarCampos() {
			// TODO Auto-generated method stub
			
			TextField nombre = new TextField();
			TextField apellidos = new TextField();
			TextField nUsuario = new TextField();
			TextField pass = new TextField();
			TextField email = new TextField();
			TextField telefono = new TextField();
			
			nombre.setLayoutX(237);
			nombre.setLayoutY(51);
			nombre.setPrefSize(175, 30);
			
			apellidos.setLayoutX(237);
			apellidos.setLayoutY(104);
			apellidos.setPrefSize(175, 30);
			
			nUsuario.setLayoutX(237);
			nUsuario.setLayoutY(157);
			nUsuario.setPrefSize(175, 30);
			
			pass.setLayoutX(237);
			pass.setLayoutY(210);
			pass.setPrefSize(175, 30);			
			
			email.setLayoutX(237);
			email.setLayoutY(262);
			email.setPrefSize(175, 30);
			
			telefono.setLayoutX(237);
			telefono.setLayoutY(315);
			telefono.setPrefSize(175, 30);
			
			
			if(tipo.equals("admin")) {
				
				nombre.setText(app.getAdmins().get(id).getNombre());
				apellidos.setText(app.getAdmins().get(id).getApellidos());
				nUsuario.setText(app.getAdmins().get(id).getNUsuario());
				pass.setText(app.getAdmins().get(id).getPass());
				email.setText(app.getAdmins().get(id).getEmail());
				telefono.setText(app.getAdmins().get(id).getTelefono());
				
			}else if(tipo.equals("comprador")) {
				
				nombre.setText(app.getCompradores().get(id).getNombre());
				apellidos.setText(app.getCompradores().get(id).getApellidos());
				nUsuario.setText(app.getCompradores().get(id).getNUsuario());
				pass.setText(app.getCompradores().get(id).getPass());
				email.setText(app.getCompradores().get(id).getEmail());
				telefono.setText(app.getCompradores().get(id).getTelefono());
				
			}else if(tipo.equals("vendedor")) {
				
				nombre.setText(app.getVendedores().get(id).getNombre());
				apellidos.setText(app.getVendedores().get(id).getApellidos());
				nUsuario.setText(app.getVendedores().get(id).getNUsuario());
				pass.setText(app.getVendedores().get(id).getPass());
				email.setText(app.getVendedores().get(id).getEmail());
				telefono.setText(app.getVendedores().get(id).getTelefono());
				
			}else {
				
			}	
			
			anchorPane.getChildren().addAll(nombre, apellidos, nUsuario, pass, email, telefono);
		}


		private void inicializarCancelar() {
			// TODO Auto-generated method stub
			cancelar.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override public void handle(ActionEvent e) {
	    	    	 Stage stage = (Stage) cancelar.getScene().getWindow();
	    	    	    stage.close();
	    	    }
	    	});
			
		}


		private void inicializarActualizar() {
			// TODO Auto-generated method stub
			
		}

		
}
