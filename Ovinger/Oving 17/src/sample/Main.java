package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    public static final ObservableList<String> valutaNavn = FXCollections.observableArrayList();
    public  Valuta[] valutaliste;
    public static ListView<String> listTilValuta = new ListView<>();
    public ListView<String> listFraValuta = new ListView<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Valuta");

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        this.valutaliste = new Valuta[]{
                new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
                new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
                new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
                new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
        };



        Label headerLabel = new Label("Velg fravaluta og tilvaluta fra listene");
        headerLabel.setFont(Font.font("Verdana", 12));
        gridPane.add(headerLabel,0,0);

        Label fraValuta = new Label("Fra valuta:");
        fraValuta.setFont(Font.font("Verdana", 15));
        gridPane.add(fraValuta, 0,1);

        for (Valuta v: valutaliste) {
            valutaNavn.add(v.getNavn());
        }
        listFraValuta.setItems(valutaNavn);
        gridPane.add(listFraValuta, 0,2);



        Label tilValuta = new Label("Fra valuta:");
        tilValuta.setFont(Font.font("Verdana", 15));
        gridPane.add(tilValuta, 1,1);


        listTilValuta.setItems(valutaNavn);
        gridPane.add(listTilValuta, 1,2);

        Button submitButton = new Button("Submit");
        gridPane.add(submitButton, 1,3);

        TextField input = new TextField();
        gridPane.add(input, 0,3);

        Label answer = new Label("");
        gridPane.add(answer,1,4);

        Button nyValutaButton = new Button("Ny valuta");
        gridPane.add(nyValutaButton, 0,5);


        submitButton.setOnAction(e -> {
            String fraValutaString = listFraValuta.getSelectionModel().getSelectedItem();
            String tilValutaString = listTilValuta.getSelectionModel().getSelectedItem();

            try {
                int belop = Integer.parseInt(input.getText());
                int indeksFra = getIndex(fraValutaString, valutaliste);
                int indeksTil = getIndex(tilValutaString, valutaliste);
                double tall = ((belop * valutaliste[indeksFra].getKurs())/valutaliste[indeksTil].getKurs())/valutaliste[indeksFra].getEnhet();
                answer.setText("Svaret blir: " + tall);


            } catch(NumberFormatException nfe) {
                nfe.printStackTrace();
            }

        });

        nyValutaButton.setOnAction(e -> {
            Stage nyValutaStage = new Stage();
            GridPane grid = new GridPane();
            Scene newScene = new Scene(grid, 200,200);

            Label valutaLabel = new Label("Valutanavn:");
            grid.add(valutaLabel,0,0);
            TextField navnInput = new TextField();
            grid.add(navnInput,1,0);

            Label kursLabel = new Label("Kurs:");
            grid.add(kursLabel, 0,1);
            TextField kursInput  =new TextField();
            grid.add(kursInput, 1,1);

            Label enhetLabel = new Label("Enhet:");
            grid.add(enhetLabel,0,2);
            TextField enhetInput = new TextField();
            grid.add(enhetInput, 1,2);

            Button submitValutaButton = new Button("Registrer");
            grid.add(submitValutaButton, 0,3);

            submitValutaButton.setOnAction(event -> {
                String navn = navnInput.getText().toString();
                double kurs = Double.parseDouble(kursInput.getText());
                int enhet = Integer.parseInt(kursInput.getText());
                Valuta v = new Valuta(navn, kurs,enhet);
                utvidTabell();
                valutaliste[valutaliste.length - 1] = v;
                oppdaterListView(v.getNavn());
                nyValutaStage.close();
            });

            nyValutaStage.setScene(newScene);
            nyValutaStage.show();
        });

        Scene scene = new Scene(gridPane, 500,500);

        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    private static int getIndex(String valuta, Valuta[] valutaListe) {
        for (int i= 0; i < valutaListe.length; i++) {
            if (valuta.equals(valutaListe[i].getNavn())) {
                return i;
            }
        }
        return -1;
    }

    private void utvidTabell() {
        Valuta[] nyTab = new Valuta[valutaliste.length + 1];
        for (int i = 0; i < valutaliste.length; i++) {
            nyTab[i] = valutaliste[i];
        }
        valutaliste = nyTab;
    }

    private void oppdaterListView(String navn) {
        valutaNavn.add(navn);

        listFraValuta.setItems(valutaNavn);
        listTilValuta.setItems(valutaNavn);


    }
}
