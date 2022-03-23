package pagination;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainPagination extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Ejemplo sobre eventos.");
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPagination.class.getResource("PaginationLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}