# TAREA2-RETS
Controles DatePicker y ColorPicker
**IMAGEN DE LA EJECUCIÓN DEL PROYECTO**
![image](https://github.com/ToalaSanRi/TAREA2-RETS/assets/169106800/3c1b26c0-f6e3-4e17-a90c-0dc1c5361bc9)



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




                -- COMPONENTES DEL CÓDIGO --

**Clase Main (Main.java):**
Esta es la clase principal que contiene el método main donde comienza la ejecución del programa.
Extiende de la clase Application de JavaFX, lo que indica que es una aplicación JavaFX.

**Método start:**
Este método es donde se inicia la construcción de la interfaz gráfica de usuario (GUI).
Define la estructura de la ventana principal y los controles como etiquetas, selección de fecha, selección de color y botón.
Configura los eventos y acciones para el botón de confirmación.


  **Componentes de la Interfaz de Usuario:**

**Etiquetas (Label)**: Proporcionan texto descriptivo para guiar al usuario.
**DatePicker (DatePicker):** Permite al usuario seleccionar una fecha.
**ColorPicker (ColorPicker):** Permite al usuario elegir un color.
**Botón (Button):** Activa una acción cuando se presiona.
**VBox (VBox):** Organiza los componentes de la interfaz de usuario verticalmente.


  **Manejo de Eventos:**

Se define un evento para el botón de confirmación (btn.setOnAction(e -> {...})).
Cuando el botón se presiona, se recopilan los valores seleccionados de la fecha y el color.
Se crea una nueva ventana secundaria para mostrar estos valores.


**Creación de la Ventana Secundaria:**

Se crea una nueva instancia de Stage para representar la ventana secundaria.
Se configuran etiquetas para mostrar la fecha seleccionada y el color seleccionado.
Se usa un rectángulo para representar visualmente el color seleccionado.


**Estilos con CSS:**

Se utiliza un archivo CSS (styles.css) para definir estilos visuales para los componentes de la interfaz de usuario.
Se aplican estilos a la ventana principal y a la ventana secundaria, así como a los componentes individuales como etiquetas, botones y rectángulos.
                

