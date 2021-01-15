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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AmazexpressApp;
import modelo.Administrador;
import modelo.Amazexpress;

public class AdminControladorAdmin {
	
	private Administrador admin;

	@FXML
	private AnchorPane root;

	@FXML
	private Label nUsuarios;

	private AmazexpressApp app;

	@FXML
	private ListView<String> listView;

	@FXML
	private Button crearAdmin;

	@FXML
	private Button editarAdmin;

	@FXML
	private Button borrarAdmin;

	@FXML
	private Label errorLabel;

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
		
		admin = app.getLoggedAdmin();

		// Inicializaciones
		inicializarCrearAdminBoton();
		inicializarCerrarSesion();

		inicializarBotonEditar();
		inicializarBotonBorrar();

		inicializarBotonNavegacion();

		inicializarLista();

		assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
	}

	private void inicializarBotonBorrar() {
		// TODO Auto-generated method stub
		borrarAdmin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Vista de borrado por hacer
				String item = listView.getSelectionModel().getSelectedItem();
				item = item.substring(0, 1);
				System.out.println(item);
				int id = Integer.parseInt(item);

				if (id != 1) {
					app.borrarAdmin(id);
				} else {

					// Label no se actualiza
					errorLabel = new Label();
					errorLabel.setText("Error: No se puede eliminar al admin padre");
				}

				try {
					cargarVentana("/vista/AdminUI_admin.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void inicializarBotonEditar() {
		// TODO Auto-generated method stub
		editarAdmin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// Sacamos el id del admin
					if (listView.getSelectionModel().getSelectedItem() != null) {
						String item = listView.getSelectionModel().getSelectedItem();
						item = item.substring(0, 1);
						System.out.println(item);
						Integer.parseInt(item);						

						// Cargamos nueva ventana
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EditUI.fxml"));

						Parent ventana = (Parent) loader.load();

						Stage secondaryStage = new Stage();

						secondaryStage.initOwner(Amazexpress.stage);
						secondaryStage.initModality(Modality.APPLICATION_MODAL);

						Image img = new Image(getClass().getResource("/amazexpress_logo_main.png").toExternalForm());
						secondaryStage.getIcons().add(img);
						secondaryStage.setTitle("Edit");
						secondaryStage.setScene(new Scene(ventana));

						secondaryStage.show(); 

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void inicializarLista() {
		listView = new ListView<>();

		// Sizes
		listView.setLayoutX(275);
		listView.setLayoutY(183);
		listView.setPrefSize(977, 506);

		listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");

		for (Administrador aux : app.getAdmins()) {
			String view = aux.getIdAdministrador() + " | " + aux.getNombre() + " | " + aux.getApellidos() + " | "
					+ aux.getApellidos() + " | " + aux.getNUsuario() + " | " + aux.getEmail() + " | "
					+ aux.getTelefono();
			listView.getItems().add(view);
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		}
		root.getChildren().addAll(listView);
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

		compradoresBoton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/AdminUI_comprador.fxml");
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

	@FXML
	private void inicializarCrearAdminBoton() {
		crearAdmin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
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
