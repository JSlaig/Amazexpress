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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.AmazexpressApp;

public class AdminControlador {

	@FXML
	private AnchorPane root;

	@FXML
	private Label nUsuarios;

	private AmazexpressApp app;

	@FXML
	private Pane mainUI;

	@FXML
	private Label username;

	@FXML
	private Button cerrarSesion;

	@FXML
	private Button inicioBoton;

	@FXML
	private Button vendedoresBoton;

	@FXML
	private Button compradoresBoton;

	@FXML
	private Button administradoresBoton;

	@FXML
	void initialize() {

		app = AmazexpressApp.getSingletonInstancia();

		// Label no se updatea
		nUsuarios = new Label();
		nUsuarios.setText(app.getUserNumber() + " usuarios");

		// Inicializaciones
		inicializarCerrarSesion();

		inicializarBotonNavegacion();

		inicializarRingProgress();

		// Label no se updatea
		username = new Label(getUsername());

		assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AdminUI.fxml'.";
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

	private void inicializarRingProgress() {
		// TODO Auto-generated method stub
		float total = app.getUserNumber();

		RingProgressIndicator ring1 = new RingProgressIndicator();
		ring1.setRingWidth(70);
		ring1.setLayoutX(430);
		ring1.setLayoutY(350);

		float comp = app.getCompradores().size();
		float result1 = comp / total * 100;
		ring1.setProgress((int) result1);

		RingProgressIndicator ring2 = new RingProgressIndicator();
		ring2.setRingWidth(70);
		ring2.setLayoutX(770);
		ring2.setLayoutY(350);

		float vend = app.getVendedores().size();
		float result2 = vend / total * 100;
		ring2.setProgress((int) result2);

		RingProgressIndicator ring3 = new RingProgressIndicator();
		ring3.setRingWidth(70);
		ring3.setLayoutX(90);
		ring3.setLayoutY(350);

		float admin = app.getAdmins().size();
		float result3 = admin / total * 100;
		ring3.setProgress((int) result3);

		mainUI.getChildren().add(ring1);
		mainUI.getChildren().add(ring2);
		mainUI.getChildren().add(ring3);
	}

	@FXML
	private void inicializarCerrarSesion() {
		cerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					// app.getAdmin(getUsername()).setLogged(false);
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

	private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		root.getChildren().removeAll();
		root.getChildren().setAll(ventana);
	}

}
