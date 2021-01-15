package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelo.AmazexpressApp;
import modelo.Conexion;

public class RegistroControlador { 

	@FXML
	private ResourceBundle resources;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private URL location;

	@FXML
	private Pane paneReg;

	@FXML
	private TextField apellidos;

	@FXML
	private Button cancelar;

	@FXML
	private ChoiceBox<String> tipo;
	ObservableList<String> listTipos = FXCollections.observableArrayList();

	@FXML
	private PasswordField pass;

	@FXML
	private TextField telefono;

	@FXML
	private TextField nombre;

	@FXML
	private TextField nUsuario;

	@FXML
	private TextField email;

	@FXML
	private Button registro;

	@FXML
	private Label estado;

	@FXML
	void initialize() {
		System.out.println("Inicializando");
		inicializar();

		assert estado != null : "fx:id=\"estado\" was not injected: check your FXML file 'LoginUI.fxml'.";
		assert apellidos != null : "fx:id=\"apellidos\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert tipo != null : "fx:id=\"tipo\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert cancelar != null : "fx:id=\"cancelar\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert telefono != null : "fx:id=\"telefono\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert nUsuario != null : "fx:id=\"nUsuario\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'RegistroUI.fxml'.";
		assert registro != null : "fx:id=\"registro\" was not injected: check your FXML file 'RegistroUI.fxml'.";

	}

	private void inicializar() {
		inicializarChoiceBox();
		inicializarCancelarBoton();
		inicializarRegistrarBoton();
	}

	@FXML
	private void inicializarRegistrarBoton() {
		registro.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					registro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void registro() throws IOException {
		AmazexpressApp app = AmazexpressApp.getSingletonInstancia();
		
		String tipoCampo;
    	
    	if(this.tipo.getValue().toString() != null) tipoCampo = this.tipo.getValue().toString();
    	else {
    		tipoCampo = ""; 
    			}
		
		app.registro(tipoCampo, nombre.getText(), apellidos.getText(), email.getText(), nUsuario.getText(), pass.getText(), telefono.getText());
		
		estado.setText("Registro correcto");
		
		if(tipoCampo.equals("admin")) {
			Conexion conexion = new Conexion();
			Connection cn = null;
	        Statement stm = null;

	        String nombre = this.nombre.getText();
	        String apellidos = this.apellidos.getText();
	        String email = this.email.getText();
	        String nUsuario = this.nUsuario.getText();
	        String password = this.pass.getText();
	        String telefono = this.telefono.getText();

	        try {
	            cn = conexion.conectar();
	            stm = cn.createStatement();
	            stm.executeUpdate("INSERT INTO amazexpressbbdd.administrador (nombre, apellidos, email, nUsuario, password, telefono) values ('"+nombre+"','"+apellidos+"','"+email+"','"+nUsuario+"','"+password+"','"+telefono+"')");
	            System.out.println("Administrador añadido");
	        } catch(SQLException e) {

	        }
			
		}
		if(tipoCampo.equals("comprador")) {
			Conexion conexion = new Conexion();
			Connection cn = null;
	        Statement stm = null;

	        String nombre = this.nombre.getText();
	        String apellidos = this.apellidos.getText();
	        String email = this.email.getText();
	        String nUsuario = this.nUsuario.getText();
	        String password = this.pass.getText();
	        String telefono = this.telefono.getText();

	        try {
	            cn = conexion.conectar();
	            stm = cn.createStatement();
	            stm.executeUpdate("INSERT INTO amazexpressbbdd.comprador (nombre, apellidos, email, nUsuario, password, telefono) values ('"+nombre+"','"+apellidos+"','"+email+"','"+nUsuario+"','"+password+"','"+telefono+"')");
	            System.out.println("Comprador añadido");
	        } catch(SQLException e) {

	        }
		}
		if(tipoCampo.equals("vendedor")) {
			Conexion conexion = new Conexion();
			Connection cn = null;
	        Statement stm = null;

	        String nombre = this.nombre.getText();
	        String apellidos = this.apellidos.getText();
	        String email = this.email.getText();
	        String nUsuario = this.nUsuario.getText();
	        String password = this.pass.getText();
	        String telefono = this.telefono.getText();

	        try {
	            cn = conexion.conectar();
	            stm = cn.createStatement();
	            stm.executeUpdate("INSERT INTO amazexpressbbdd.vendedor (nombre, apellidos, email, nUsuario, password, telefono) values ('"+nombre+"','"+apellidos+"','"+email+"','"+nUsuario+"','"+password+"','"+telefono+"')");
	            System.out.println("Vendedor añadido");
	        } catch(SQLException e) {

	        }
		}
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
		
		cargarVentana("/vista/LoginUI.fxml");
	}

	@FXML
	private void inicializarCancelarBoton() {
		cancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/LoginUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		anchorPane.getChildren().removeAll();
		anchorPane.getChildren().setAll(ventana);
	}

	private void inicializarChoiceBox() {

		listTipos.removeAll(listTipos);

		String[] tipos = new String[3];

		tipos[0] = "comprador";
		tipos[1] = "vendedor";

		listTipos.addAll(tipos[0], tipos[1]);

		tipo.getItems().addAll(listTipos);
		tipo.setValue("tipo de cuenta");
	}
}
