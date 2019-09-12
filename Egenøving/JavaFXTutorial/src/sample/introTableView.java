package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class introTableView extends Application {

    Stage window;
    TableView<Product> table;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Table View");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        //Layout
        VBox layout = new VBox();
        layout.getChildren().add(table);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }
    //Get all of the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("TV", 59.00, 15));
        products.add(new Product("Mouse", 9.00, 520));
        products.add(new Product("Headset", 259.00, 30));
        return products;
    }
}
