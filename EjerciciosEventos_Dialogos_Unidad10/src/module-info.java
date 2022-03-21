module EjerciciosEventos_Dialogos_Unidad10 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens eventosValidar to javafx.graphics, javafx.fxml, javafx.controls;
}
