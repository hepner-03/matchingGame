package dusome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.jar.Manifest;

public class introController implements Initializable {

    @FXML
    private ImageView imgTheme;

    @FXML
    void btnPlayAction(ActionEvent event) throws IOException {
        MainApp.setRoot("game", "");
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        MainApp.theme = MainApp.theme -1;
        imgTheme.setImage(new Image(getClass().getResource("/pictures/" + MainApp.theme + "/7.jpg").toString()));
    }

    @FXML
    void goForward(MouseEvent event) throws IOException {
        MainApp.theme -= -1;
        imgTheme.setImage(new Image(getClass().getResource("/pictures/" + MainApp.theme + "/7.jpg").toString()));
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
}
