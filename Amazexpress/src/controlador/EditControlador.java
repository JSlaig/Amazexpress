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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditControlador {
	
		@FXML
	    private AnchorPane anchorPane;
		
		@FXML
	    private Label tipo;

	    @FXML
	    private Button cancelar;

	    @FXML
	    private Button actualizar;
	    
	    
	    @FXML
	    void initialize() {
	    	
	    	inicializarCampos();
	    	
	    	inicializarCancelar();
	    	inicializarActualizar();
	    	
	        assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'EditUI.fxml'.";
	        assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'EditUI.fxml'.";
	        assert actualizar != null : "fx:id=\"actualizar\" was not injected: check your FXML file 'EditUI.fxml'.";

	    }


		private void inicializarCampos() {
			// TODO Auto-generated method stub
			
			
			
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
