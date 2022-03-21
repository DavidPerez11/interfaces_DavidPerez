package eventosValidar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonDialogo;

    @FXML
    private TextField textField;

    private String inputUsuario;
    
    @FXML
    void initialize() {
        
    	TextInputDialog textDialog = new TextInputDialog();
    	textDialog.setTitle("Ejemplo de diálogo");
    	textDialog.setHeaderText("Diálogo para introducir un texto");
    	
    	botonDialogo.setOnAction(e -> {
    	// Se incluye la respuesta del usuario un campo de tipo Text
    	textDialog.showAndWait().ifPresent(response -> {
    	inputUsuario = response;
    	});
    	textField.setText(inputUsuario);
    	}); 
    	
    	
    }


    
}
