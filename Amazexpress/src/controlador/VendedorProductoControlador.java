package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import modelo.AmazexpressApp;

public class VendedorProductoControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button crearAdmin;

    @FXML
    private Button editarAdmin;

    @FXML
    private Button borrarAdmin;

	private AmazexpressApp app;

    @FXML
    void initialize() {
    	
    	app.getSingletonInstancia();
    	
    	inicializarLista();
    	
        assert crearAdmin != null : "fx:id=\"crearAdmin\" was not injected: check your FXML file 'VendedorProductosUI.fxml'.";
        assert editarAdmin != null : "fx:id=\"editarAdmin\" was not injected: check your FXML file 'VendedorProductosUI.fxml'.";
        assert borrarAdmin != null : "fx:id=\"borrarAdmin\" was not injected: check your FXML file 'VendedorProductosUI.fxml'.";

    }
    
    private void inicializarLista() {
		// TODO Auto-generated method stub
    	ListView listView = new ListView<>();
    	
    	//Sizes
    	listView.setLayoutX(275);
    	listView.setLayoutY(183);
    	listView.setPrefSize(977, 506);
    	
    	listView.setStyle("-fx-control-inner-background: #3B4148; -fx-text-fill: #ADADAD;");
    	
    	/*
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
    */
    }
}
