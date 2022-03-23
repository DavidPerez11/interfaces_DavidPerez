package choiceEjercicio;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class ChoiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boton;

    @FXML
    private ListView<String> listView;

    @FXML
    void initialize() {
        
    	ObservableList<String> data = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
    	
    	listView.setItems(data);

    	listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	listView.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				boton.setDisable(false);
			}
    		
    	});
    	
    	listView.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
    		
    		if (listView.getSelectionModel().getSelectedItems().isEmpty()) {
    			Alert alerta = new Alert(AlertType.INFORMATION);
    			alerta.setTitle("Aviso sobre listado");
    			alerta.setHeaderText("Sin ítems seleccionados");
    			alerta.setContentText("No se puede mostrar el diálogo hasta que se seleccione un ítem como mínimo");
    			alerta.showAndWait();
    		}
    	});
    
    	boton.setOnAction(e -> {
    		List<String> dataChoice = listView.getSelectionModel().getSelectedItems();
    		ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(dataChoice.get(0), dataChoice);
    		choiceDialog.setTitle("Ejemplo");
    		choiceDialog.setHeaderText("Seleccione un valor...");
    		choiceDialog.showAndWait().ifPresent(response -> {
    			int index = listView.getItems().indexOf(response);
    			listView.getSelectionModel().clearAndSelect(index);
    		});
    	});
    	
    }

}
