package draggableFiles;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DraggableMain extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Ejemplo sobre eventos.");
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DraggableMain.class.getResource("DraggableLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			
			Text source = (Text) scene.lookup("#source");
			Text destination = (Text) scene.lookup("#destination");
			ImageView imageDestination = (ImageView) scene.lookup("#imageView");
			
			dragNDropText(source, destination);
			
			dragNDropImage(imageDestination);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void dragNDropText(Text source, Text destination) {
		
		source.setOnDragDetected((event) -> {
            
            Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
            
            // Se transfiere el String del texto inicial
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);            
        });
		
		destination.setOnDragOver((event) -> {
            if (event.getGestureSource() != destination &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }          
        });
		
		destination.setOnDragDropped((event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;       
            if (db.hasString()) {
            	destination.setText(db.getString());
            	source.setText("Operación drag terminada.");
                success = true;
            }
            event.setDropCompleted(success);        
        });
		
	}
	
	private static void dragNDropImage (ImageView destination) {
		
		destination.setOnDragOver((event) -> {
            if (event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.ANY);
            }          
        });
		
		destination.setOnDragDropped((event) -> {
			try {
	            Dragboard db = event.getDragboard();
	            boolean success = false;
	            List<File> files = db.getFiles();
				Image img = new Image (new FileInputStream(files.get(0)));	
				
	            if (db.hasFiles()) {
	            	destination.setImage(img);
	                success = true;
	            }
	            event.setDropCompleted(success);  
            } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
