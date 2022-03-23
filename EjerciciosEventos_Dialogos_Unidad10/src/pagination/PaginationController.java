package pagination;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class PaginationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pagination pagination;
    
    @FXML
    private ProgressBar progress;

    @FXML
    void initialize() {
        
    	 pagination.setMaxPageIndicatorCount(7);//Cantidad de botones para el paginador
         pagination.setPageCount(4);//cantidad de paginas
         pagination.setStyle("-fx-border-color:green;");//estilo CSS del control FX
         //establece lo que retornara el paginador cuando se haga clic en algun boton
         pagination.setPageFactory(new Callback<Integer, Node>() {
             @Override
             public Node call(Integer pageIndex) {
            	 double progressIndex = (pageIndex+1) * 0.25;
            	 progress.setProgress(progressIndex);;
                 return createPage(pageIndex);
             }
         });

    }
    
    public VBox createPage(int pageIndex) {        
        int itemsPerPage = 5;//items por pagina
        VBox box = new VBox();//contenedor
        int page = pageIndex * itemsPerPage;         
        for (int i = page; i < page + itemsPerPage && i < 18; i++) {            
            //Crea un Label con un nombre aleatorio
            Label text = new Label( (i+1) + ".- " + Generador.getFullName());
            //Agrega estilo CSS al Label con un color de fonto aleatorio
            text.setStyle("-fx-font-size:16;-fx-pref-width:300px;-fx-background-color:#26BFE5;-fx-padding:8px 0 8px 8px;");            
            box.getChildren().add(text);
        }
        return box;
    }

}
