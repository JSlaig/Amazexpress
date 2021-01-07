package controlador;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.AmazexpressApp;

public class RegistroControlador {
	
	ObservableList<String> list = FXCollections.observableArrayList();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField apellidos;

	@FXML
	private Button cancelar;

	@FXML
	private ChoiceBox<String> tipo;

	@FXML
	private PasswordField pass;

	@FXML
	private TextField telefono;

	@FXML
	private TextField nombre;

	@FXML
	private TextField nUsuario;

	@FXML
	private TextField email;

	@FXML
	private Button registro;

	@FXML
	void initialize() {
	 	inicializar();
	    	
	    assert apellidos != null : "fx:id=\"apellidos\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert telefono != null : "fx:id=\"telefono\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert nUsuario != null : "fx:id=\"nUsuario\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'RegistroUI.fxml'.";
	    assert registro != null : "fx:id=\"registro\" was not injected: check your FXML file 'RegistroUI.fxml'.";

	}
	    
	private void inicializar() {    	
	    	
	   	inicializarCheckBox();	    	
	}
    
    private void inicializarCheckBox() {
    	list.removeAll(list);
    	
    	String[] tipos = new String[3];
    	
    	tipos[0] = "comprador";
    	tipos[1] = "vendedor";    	
    	
    	list.addAll(tipos[0], tipos[1]);
    	
    	tipo.getItems().addAll(list);
    	tipo.setValue("tipo de cuenta");
    	
    }
}
