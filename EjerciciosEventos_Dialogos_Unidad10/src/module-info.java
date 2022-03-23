module EjerciciosEventos_Dialogos_Unidad10 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens eventosValidar to javafx.graphics, javafx.fxml, javafx.controls;
	opens draggableFiles to javafx.graphics, javafx.fxml, javafx.controls;
	opens choiceEjercicio to javafx.graphics, javafx.fxml, javafx.controls;
}
