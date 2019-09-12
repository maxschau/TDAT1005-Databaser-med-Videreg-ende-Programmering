import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PropertiesTut extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Properties");

        Person max = new Person();
        max.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + max.firstNameProperty());
            System.out.println("getFirstName(): " + max.getFirstName());
        }); //Will be called when something happens

        button = new Button("Submit");
        button.setOnAction(e -> {
            max.setFirstName("Maximillian");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

}
