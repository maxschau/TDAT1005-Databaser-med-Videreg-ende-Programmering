package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TreeViewTutorial extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Checkbox");

        TreeItem<String> root, bucky, megan;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true); //When the program launches everything will be set to expandedd

        //Bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("Vålerenga", bucky);
        makeBranch("Chelsea", bucky);
        makeBranch("Travis Scott", bucky);

        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("Lillestrøm", megan);
        makeBranch("United", megan);
        makeBranch("Bieber", megan);

        //Create tree
        tree = new TreeView<>(root); //All trees need a main root
        tree.setShowRoot(false); //The root is just a container so it is not necessary to show root


        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<String>(title); //Cast the string title to a list item (TreeItem)
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
