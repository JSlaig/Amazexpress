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
import modelo.Comprador;
import modelo.Producto;
import modelo.Vendedor;

public class CompradorProductoControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Button comprar;

	@FXML
	private Button crearProducto;
	
	@FXML
	ListView<String> listView;

	@FXML
	private Button editarProducto;

	@FXML
	private Button borrarProducto;

	private AmazexpressApp app;
	
	private Comprador comprador;

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
	private Button productosBoton;

	@FXML
	private Button historialBoton;

	@FXML
	void initialize() {

		app = AmazexpressApp.getSingletonInstancia();
		
		comprador = app.getLoggedComprador();

		inicializarBotones();

		inicializarLista();

	}

	private void inicializarBotones() {
		cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					comprador.setLogged(false);
					cargarVentana("/vista/LoginUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		comprar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					
					String id = listView.getSelectionModel().getSelectedItem();
					id = id.substring(0,1);
					
					app.borrarProducto(Integer.valueOf(id));
					//app.getVendedorProducto(id).borrarProducto(Integer.valueOf(id));					
					
					
					cargarVentana("/vista/CompradorProductosUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		productosBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CompradorProductosUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		perfilBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CompradorPerfil.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		mensajesBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CompradorMensajesUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		balanceBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CompradorBalanceUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		historialBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CompradorHistorialUI.fxml");
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
		listView = new ListView<String>();

		// Sizes
		listView.setLayoutX(275);
		listView.setLayoutY(183);
		listView.setPrefSize(977, 506);

		listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");
		if (app.getProductos() != null && app.getProductos().size() > 0) {
			for (Producto aux : app.getProductos()) {
				String view = aux.getIdProducto() + " | " + aux.getNombre() + " | " + aux.getDescripcion() + " | "
						+ aux.getStock() + " | " + aux.getPrecio() + " | " + aux.getVendedor();
				listView.getItems().add(view);
				listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);				
			}
		}else {
			String view = "No hay productos";
			listView.getItems().add(view);
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	
		}

		root.getChildren().addAll(listView);
	}
}
