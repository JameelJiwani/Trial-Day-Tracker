package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {
    @FXML
    private MenuItem about;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadHelp(ActionEvent event) {
        // Create new scene
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            stageTheEventSourceNodeBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("Help.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }


    }
}
