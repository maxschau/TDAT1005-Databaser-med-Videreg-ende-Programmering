package sample;

import javafx.scene.control.Button;

public class Controller {

    public Button button;

    public void handleButtonClick() {
        System.out.println("Run some code. The user doesnt se this hehehe");
        button.setText("Stop touching me");
    }
}
