package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            
            Label dateLabel = new Label("Selecciona una fecha:");
            dateLabel.getStyleClass().add("label");
            Label colorLabel = new Label("Selecciona un color:");
            colorLabel.getStyleClass().add("label");

       
            DatePicker datePicker = new DatePicker();
            ColorPicker colorPicker = new ColorPicker();

            
            Button btn = new Button("Confirmar");
            btn.getStyleClass().add("button");

           
            btn.setOnAction(e -> {
                
                String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "No seleccionada";
                Color selectedColor = colorPicker.getValue() != null ? colorPicker.getValue() : Color.BLACK;

              
                Stage secondStage = new Stage();
                VBox secondaryLayout = new VBox(10); 
                secondaryLayout.getStyleClass().add("secondary-root");

         
                Label dateInfoLabel = new Label("La fecha seleccionada es: " + selectedDate);
                dateInfoLabel.getStyleClass().add("secondary-label");
                Label colorInfoLabel = new Label("El color seleccionado es:");
                colorInfoLabel.getStyleClass().add("secondary-label");

                
                Rectangle colorRectangle = new Rectangle(100, 100, selectedColor);
                colorRectangle.getStyleClass().add("rectangle");

                
                secondaryLayout.getChildren().addAll(dateInfoLabel, colorInfoLabel, colorRectangle);

               
                Scene secondScene = new Scene(secondaryLayout, 300, 200);
                secondScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
                secondStage.setScene(secondScene);
                secondStage.setTitle("Selección");
                secondStage.show();
            });

          
            VBox root = new VBox(10); 
            root.getStyleClass().add("root");
            root.getChildren().addAll(dateLabel, datePicker, colorLabel, colorPicker, btn);

          
            Scene scene = new Scene(root, 300, 200);
            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Seleccionar Fecha y Color");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
