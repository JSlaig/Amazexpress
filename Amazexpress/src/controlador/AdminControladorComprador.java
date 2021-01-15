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
import modelo.Administrador;
import modelo.AmazexpressApp;

public class AdminControladorComprador {

	private Administrador admin;

	@FXML
	private AnchorPane root;

	@FXML
	private Label nUsuarios;

	private AmazexpressApp app;

	@FXML
	private Button borrarComprador;

	@FXML
	private Button editarComprador;

	@FXML
	private ListView<String> listView;

	@FXML
	private Button cerrarSesion;

	@FXML
	private Button inicioBoton;

	@FXML
	private Button vendedoresBoton;

	@FXML
	private Button administradoresBoton;

	@FXML
	void initialize() {

		app = AmazexpressApp.getSingletonInstancia();

		admin = app.getLoggedAdmin();

		// Inicializaciones

		inicializarCerrarSesion();

		inicializarBotonNavegacion();

		inicializarLista();

		inicializarBotonBorrar();

		assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
	}

	private void inicializarBotonBorrar() {
		// TODO Auto-generated method stub
		borrarComprador.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Vista de borrado por hacer
				String item = listView.getSelectionModel().getSelectedItem();
				item = item.substring(0, 1);
				System.out.println(item);
				int id = Integer.parseInt(item);

				app.borrarComprador(id);

				try {
					cargarVentana("/vista/AdminUI_comprador.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void inicializarLista() {
		// TODO Auto-generated method stub
		listView = new ListView<>();

		// Sizes
		listView.setLayoutX(275);
		listView.setLayoutY(183);
		listView.setPrefSize(977, 506);

		listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");

		int i = 1;
		while (i <= app.getCompradores().size()) {
			if (app.getCompradores().get(i) != null) {
				String view = app.getCompradores().get(i).getIdComprador() + " | "
						+ app.getCompradores().get(i).getNombre() + " | " + app.getCompradores().get(i).getApellidos()
						+ " | " + app.getCompradores().get(i).getApellidos() + " | "
						+ app.getCompradores().get(i).getNUsuario() + " | " + app.getCompradores().get(i).getEmail()
						+ " | " + app.getCompradores().get(i).getTelefono();
				listView.getItems().add(view);
				listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			}
			i++;
		}
		root.getChildren().addAll(listView);
	}

	private String getUsername() {
		// TODO Auto-generated method stub
		int i = 1;
		String user = new String();
		while (i < app.getAdmins().size()) {
			if (app.getAdmins().get(i) != null && app.getAdmins().get(i).getLogged() == true) {
				user = app.getAdmins().get(i).getNUsuario();
			}
			i++;
		}
		return user;
	}

	@FXML
	private void inicializarCerrarSesion() {
		cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					admin.setLogged(false);
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
			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/AdminUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		administradoresBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/AdminUI_admin.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		vendedoresBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/AdminUI_vendedor.fxml");
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
