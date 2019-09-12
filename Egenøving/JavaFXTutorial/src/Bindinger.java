import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Bindinger extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bindings");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10)); //Whenever we update the value of x the value of y is updated
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());
        x.setValue(20);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());


        button = new Button("Submit");


        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

}
