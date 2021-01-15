package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import modelo.AmazexpressApp;
import modelo.Vendedor;

public class VendedorProductoControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button crearProducto;

    @FXML
    private Button editarProducto;

    @FXML
    private Button borrarProducto;

	private AmazexpressApp app;
	
	private Vendedor vendedor;
	
	 @FXML
	 private Button cerrarSesion;
	    
	 @FXML
	 private AnchorPane root;
	 
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
    void initialize() {
    	
    	app = AmazexpressApp.getSingletonInstancia();
    	
    	vendedor = app.getLoggedVendedor();
    	
    	inicializarBotones();
    	
    	inicializarLista();

    }
    
    private void inicializarBotones() {
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
						cargarVentana("/vista/VendedorUI.fxml"); 
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
						cargarVentana("/vista/VendedorPerfil.fxml"); 
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
						cargarVentana("/vista/VendedorMensajesUI.fxml"); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
    	    }
    	});
		
		balanceBoton.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {    	        
					try {
						//app.getAdmin(getUsername()).setLogged(false);
						cargarVentana("/vista/VendedorBalanceUI.fxml"); 
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
						cargarVentana("/vista/VendedorHistorialUI.fxml"); 
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
    
    private void inicializarLista() {
		// TODO Auto-generated method stub
    	ListView<String> listView = new ListView<String>();
    	
    	//Sizes
    	listView.setLayoutX(275);
    	listView.setLayoutY(183);
    	listView.setPrefSize(977, 506);
    	
    	listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");
    	
    	int i = 1;
    	
    	while(this.vendedor.getProductos().size() > i) {
    		
    		if(this.vendedor.getProductos().get(i) != null) {
    			String view = this.vendedor.getProductos().get(i).getIdProducto() + " | " + this.vendedor.getProductos().get(i).getNombre() + " | " + this.vendedor.getProductos().get(i).getDescripcion() + " | " + this.vendedor.getProductos().get(i).getStock() + " | " + this.vendedor.getProductos().get(i).getPrecio() + " | " + this.vendedor.getProductos().get(i).getVendedor();
    			listView.getItems().add(view);
    		}
    		
    		i++;
    	}
    	
    root.getChildren().addAll(listView);    
    }
}
