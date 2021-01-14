package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import modelo.AmazexpressApp;
import modelo.Administrador;

public class AdminControladorAdmin {

    @FXML
    private AnchorPane root;
    
    @FXML
    private Label nUsuarios;
    
    private AmazexpressApp app;
    
    @FXML
    private Button crearAdmin;
   
    @FXML
    private ListView<String> listView;

    @FXML
    private Button nuevoAdmin;


    @FXML
    private Button editarAdmin;

    @FXML
    private Button borrarAdmin;
    
    @FXML
    private Button cerrarSesion;
    
    @FXML
    private Button inicioBoton;
    
    @FXML
    private Button vendedoresBoton;
   
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
    	
    	inicializarLista();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
    } 
    
    private void inicializarLista() {
		// TODO Auto-generated method stub
    	listView = new ListView<>();
    	
    	//Sizes
    	listView.setLayoutX(275);
    	listView.setLayoutY(183);
    	listView.setPrefSize(977, 506);
    	
    	//listView.setStyle("/vista/applicacion.css");
    	
    	int i = 1;
    	while(i <= app.getAdmins().size()) {
    		if(app.getAdmins().get(i) != null) {		    	
		    	String view = app.getAdmins().get(i).getIdAdministrador() + " | " + app.getAdmins().get(i).getNombre() + " | " + app.getAdmins().get(i).getApellidos() + " | " +  app.getAdmins().get(i).getApellidos() + " | " + app.getAdmins().get(i).getNUsuario() + " | " + app.getAdmins().get(i).getEmail() + " | " + app.getAdmins().get(i).getTelefono();	    			
				listView.getItems().add(view);		
				listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    		}
    		i++;
    	}
    root.getChildren().addAll(listView);
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
 	    	
 	    	vendedoresBoton.setOnAction(new EventHandler<ActionEvent>() {
 	    	    @Override public void handle(ActionEvent e) {    	        
 						try {
 							cargarVentana("/vista/AdminUI_vendedor.fxml");
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
