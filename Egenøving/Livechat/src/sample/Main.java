package sample;

import database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    Stage window;
    Timer timer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Live chat");

        int PREFWIDTH = 150;

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.TOP_CENTER);

        Label headerLabel = new Label("Livechat");
        headerLabel.setFont(Font.font(15));
        grid.add(headerLabel, 0,0);


        TextField inputText = new TextField();
        grid.add(inputText, 0,1);
        inputText.setPrefWidth(PREFWIDTH);

        Button submitButton = new Button("Submit");
        grid.add(submitButton, 0,2);
        submitButton.setPrefWidth(PREFWIDTH);
        submitButton.setDefaultButton(true);




        Text chatText = new Text();
        grid.add(chatText,0,4);


        submitButton.setOnAction(e -> {
                Connection con = DBConnection.getCon();
                String text = inputText.getText();
                DBConnection.insertMessage(con, text);
                DBConnection.closeConnection(con);
                inputText.clear();
                showMessages(chatText, inputText);
            });


        primaryStage.setOnCloseRequest(e -> {
            Connection con = DBConnection.getCon();
            DBConnection.clearTable(con);
            DBConnection.closeConnection(con);
            e.consume();
            timer.cancel();
            primaryStage.close();
        });


        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    private void showMessages(Text chatText, TextField inputText) {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Connection con = DBConnection.getCon();
                ArrayList<String> words = DBConnection.getMessages(con);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    sb.append(words.get(i));
                    sb.append("\n");
                }
                chatText.setText(sb.toString());
                //inputText.clear();
                DBConnection.closeConnection(con);
            }
        };
        timer.schedule(task, 0, 5000);
    }


}
