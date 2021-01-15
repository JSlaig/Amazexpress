package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import modelo.AmazexpressApp;

public class LoginControlador{
	
	private AmazexpressApp app; 	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane parentContainer;
    
    @FXML
    private AnchorPane anchorRoot;

    @FXML
    private Label estado;

    @FXML
    private TextField usCampo;

    @FXML
    private ChoiceBox<String> tipoCampo;
    ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    private Button regBoton;
    
    @FXML
    private Button logBoton;    

    @FXML
    private PasswordField passCampo;

   

    @FXML
	public
    void initialize() {
    	inicializar();
    	
        assert parentContainer != null : "fx:id=\"parentContainer\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert estado != null : "fx:id=\"estado\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert usCampo != null : "fx:id=\"usCampo\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert tipoCampo != null : "fx:id=\"tipoCampo\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert regBoton != null : "fx:id=\"regBoton\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert anchorRoot != null : "fx:id=\"root\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert passCampo != null : "fx:id=\"passCampo\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert logBoton != null : "fx:id=\"logBoton\" was not injected: check your FXML file 'LoginUI.fxml'.";

    } 

    private void inicializar() {
    	
    	this.app = AmazexpressApp.getSingletonInstancia();    	
    	
    	inicializarChoiceBox();
    	
    	inicializarLoginBoton();
    	inicializarRegistroBoton();   	
    	
    }
    
    private void inicializarLoginBoton() {
    	logBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						login(e);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
    	    }
    	});
    }
    
    private void inicializarRegistroBoton() {
    	regBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        try {
					registro(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    }
    	});
    }
    
    private void inicializarChoiceBox() {
    	
    	list.removeAll(list);
    	
    	String[] tipos = new String[3];
    	
    	tipos[0] = "admin";
    	tipos[1] = "comprador";
    	tipos[2] = "vendedor";
    	
    	list.addAll(tipos[0], tipos[1], tipos[2]);
    	
    	tipoCampo.getItems().addAll(list);
    }
    
    @FXML
    void registro(ActionEvent event) throws IOException {     	
    	cargarVentana("/vista/RegistroUI.fxml");
    }
    
    private void cargarVentana(String ruta) throws IOException {
    	Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
    	parentContainer.getChildren().removeAll();
    	parentContainer.getChildren().setAll(ventana);
    	
    
    }
    
    @FXML
    void login(ActionEvent event) throws IOException {    	
    	
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
        			//app.getAdmin(nUsuario).setLogged(true);
        		
        			estado.setText("Login correcto");
        			
        			cargarVentana("/vista/AdminUI.fxml");
        			
        		break;
        		
        		case "comprador":
        			//Desde aqui abririamos la ventana de comprador
        			//app.getComprador(nUsuario).setLogged(true);
        			
        			estado.setText("Login correcto");
        			
        			cargarVentana("/vista/CompradorUI.fxml");
        			
        		break;
        		
        		case "vendedor":
        			//Desde aqui abririamos la ventana de vendedor
        			app.getVendedor(nUsuario).setLogged(true);
        			
        			estado.setText("Login correcto");
        			
        			cargarVentana("/vista/VendedorUI.fxml");
        			
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
