package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MakingMenu extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Menu");

        //File menu
        Menu fileMenu = new Menu("_File"); //Having an underline before the word makes it a shortcut (alt + f) will open the menu

        //Menu items
        MenuItem newFile = new MenuItem("New... ");
        newFile.setOnAction(event -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings.."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit.."));

        //Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        //editMenu.getItems().add(new MenuItem("Paste"));
        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(event -> System.out.println("Paste something"));
        editMenu.getItems().add(pasteItem);
        //pasteItem.setDisable(true); //makes the item disabled. It is still there, however there no posibillties of pressing it

        //Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(event -> {
            if (showLines.isSelected()) {
                System.out.println("Program will now display line numbers");
            } else {
                System.out.println("Program will now not display line numbers");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);


        //RadioMenuItems:
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);



        //Layout
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }
}
