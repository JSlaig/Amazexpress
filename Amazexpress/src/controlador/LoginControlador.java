package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.AmazexpressApp;

public class LoginControlador {
	
	private AmazexpressApp app; 
	
	ObservableList list = FXCollections.observableArrayList();

	@FXML
	private Label estado;
	
	@FXML
    private TextField usCampo;

    @FXML
    private ChoiceBox<String> tipoCampo;

    @FXML
    private Button regBoton;

    @FXML
    private PasswordField passCampo;

    @FXML
    private Button logBoton;
    
    @FXML
    void initialize() 
    {
    	inicializar();
    	
    	
    	assert estado != null : "fx:id=\"estado\" was not injected: check your FXML file 'MainUI.fxml'.";
        assert usCampo != null : "fx:id=\"usCampo\" was not injected: check your FXML file 'MainUI.fxml'.";
        assert tipoCampo != null : "fx:id=\"tipoCampo\" was not injected: check your FXML file 'MainUI.fxml'.";
        assert regBoton != null : "fx:id=\"regBoton\" was not injected: check your FXML file 'MainUI.fxml'.";
        assert passCampo != null : "fx:id=\"passCampo\" was not injected: check your FXML file 'MainUI.fxml'.";
        assert logBoton != null : "fx:id=\"logBoton\" was not injected: check your FXML file 'MainUI.fxml'.";

    }  

    private void inicializar() {
    	
    	this.app = AmazexpressApp.getSingletonInstancia();
    	
    	app.registro("admin", "", "", "", "admin", "admin", "");
    	
    	inicializarCheckBox();
    	
    	inicializarLoginBoton();
    	
    }
    
    private void inicializarLoginBoton() {
    	logBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        login(e);
    	    }
    	});
    }
    
    private void inicializarCheckBox() {
    	
    	list.removeAll(list);
    	
    	String[] tipos = new String[3];
    	
    	tipos[0] = "admin";
    	tipos[1] = "comprador";
    	tipos[2] = "vendedor";
    	
    	list.addAll(tipos[0], tipos[1], tipos[2]);
    	
    	tipoCampo.getItems().addAll(list);
    }
    
    @FXML
    void registro(ActionEvent event) {

    }
    
    @FXML
    void login(ActionEvent event) {
    	
    	String tipo;
    	
    	if(this.tipoCampo.getValue().toString() != null) tipo = this.tipoCampo.getValue().toString();
    	else {
    		tipo = "";
    			}
    	String nUsuario = this.usCampo.getText().toString();
    	String pass = this.passCampo.getText().toString(); 
    	
    	   	
    	
    	if(app.login(tipo, nUsuario, pass)) {
    		switch(tipo) {
        		case "admin":	    			
        			//Desde aqui abririamos la ventana de admin
        			app.getAdmin(nUsuario);
        			System.out.println("Login correcto");
        			estado.setText("Login correcto");
        		break;
        		
        		case "comprador":
        			//Desde aqui abririamos la ventana de comprador
        			app.getComprador(nUsuario);
        			System.out.println("Login correcto");
        			estado.setText("Login correcto");
        			
        		break;
        		
        		case "vendedor":
        			//Desde aqui abririamos la ventana de vendedor
        			app.getVendedor(nUsuario);
        			System.out.println("Login correcto");
        			estado.setText("Login correcto");
        			
        		break;
        		
        		default:
        			System.err.println("Error durante el login");
        		break;
    		}
    	}else {
    		System.err.println("Credenciales erroneas");
    		estado.setText("Credenciales erroneas");
    	}

    }   
}
