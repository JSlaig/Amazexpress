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

public class AdminControladorVendedor {

    @FXML
    private AnchorPane root;
    
    @FXML
    private Label nUsuarios;
    
    private AmazexpressApp app;
    
    @FXML
    private Button editarVendedor;
    
    @FXML
    private Button borrarVendedor;
    
    @FXML
    private ListView<String> listView;
    
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
      	
    	//Inicializaciones
    	
    	inicializarCerrarSesion();
    	
    	inicializarBotonNavegacion();
    	
    	inicializarLista();
    	
    	inicializarBotonBorrar();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
    } 
    
    private void inicializarLista() {
		// TODO Auto-generated method stub
    	listView = new ListView<>();
    	
    	//Sizes
    	listView.setLayoutX(275);
    	listView.setLayoutY(183);
    	listView.setPrefSize(977, 506);
    	
    	listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");
    	
    	int i = 1;
    	while(i <= app.getVendedores().size()) {
    		if(app.getVendedores().get(i) != null) {		    	
		    	String view = app.getVendedores().get(i).getIdVendedor() + " | " + app.getVendedores().get(i).getNombre() + " | " + app.getVendedores().get(i).getApellidos() + " | " +  app.getVendedores().get(i).getApellidos() + " | " + app.getVendedores().get(i).getNUsuario() + " | " + app.getVendedores().get(i).getEmail() + " | " + app.getVendedores().get(i).getTelefono();	    			
				listView.getItems().add(view);		
				listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    		}
    		i++;
    	}
    root.getChildren().addAll(listView);
    }
    
    private void inicializarBotonBorrar() {
		// TODO Auto-generated method stub
    	borrarVendedor.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					//Vista de borrado por hacer
					String item = listView.getSelectionModel().getSelectedItem();
					item = item.substring(0,1);
					System.out.println(item);
					int id = Integer.parseInt(item);
					
					app.borrarVendedor(id);
					
					try {
						cargarVentana("/vista/AdminUI_vendedor.fxml");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	    }
    	});
    }
    
    private String getUsername() {
		// TODO Auto-generated method stub
		int i = 1;
		String user = new String();
		while(i < app.getAdmins().size()) {
			if(app.getAdmins().get(i) != null && app.getAdmins().get(i).getLogged() == true) {
			  user = app.getAdmins().get(i).getNUsuario();
			}
			i++;
		}
		return user;
	}
    
    @FXML
	private void inicializarCerrarSesion() {
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
   
    
    private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		root.getChildren().removeAll();
    	root.getChildren().setAll(ventana);
    }
    
    
}
