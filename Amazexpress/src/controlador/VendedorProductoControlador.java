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
import javafx.scene.layout.Pane;
import modelo.Administrador;
import modelo.AmazexpressApp;
import modelo.Producto;
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
	private Pane pane;

	@FXML
	private ListView<String> listView;

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

		this.vendedor = app.getLoggedVendedor();

		inicializarBotones();

		inicializarLista();

	}

	private void inicializarBotones() {
		cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					vendedor.setLogged(false);
					cargarVentana("/vista/LoginUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		tiendaBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/VendedorUI.fxml");
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
					cargarVentana("/vista/VendedorPerfil.fxml"); 
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
					cargarVentana("/vista/VendedorMensajesUI.fxml");
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
					cargarVentana("/vista/VendedorBalanceUI.fxml");
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
					cargarVentana("/vista/VendedorHistorialUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		crearProducto.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
					cargarVentana("/vista/CrearProducto.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		borrarProducto.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String idEliminar = listView.getSelectionModel().getSelectedItem(); 
				
				idEliminar = idEliminar.substring(0,1);
				
				app.borrarProducto(Integer.valueOf(idEliminar));
				vendedor.borrarProducto(Integer.valueOf(idEliminar));
			}
		});
	}

	private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		root.getChildren().removeAll();
		root.getChildren().setAll(ventana);
	}
	
	private void inicializarLista() {
		listView = new ListView<>();

		// Sizes
		listView.setLayoutX(275);
		listView.setLayoutY(183);
		listView.setPrefSize(977, 506);

		listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");

		if (this.vendedor.getProductos() != null && this.vendedor.getProductos().size() > 0) {
			for (Producto aux : this.vendedor.getProductos()) {
				String view = aux.getIdProducto() + " | " + aux.getNombre() + " | " + aux.getDescripcion() + " | "
						+ aux.getStock() + " | " + aux.getPrecio() + " | " + aux.getVendedor();
				System.out.println(view);
				listView.getItems().add(view);
				listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); 
			}
		}else {
			String view = "No hay productos";
			listView.getItems().add(view);
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		}

		root.getChildren().addAll(listView);
	}
}
