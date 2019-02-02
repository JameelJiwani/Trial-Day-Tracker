package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController implements Initializable {
    @FXML
    private Button button;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadAddScene() {
        // Create new scene
        //Stage stage = (Stage) about0.getScene().getWindow();
        //Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("Add Member.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }


    }

    @FXML
    private void loadSearchScene() {
        // Create new scene
        //Stage stage = (Stage) about0.getScene().getWindow();
        //Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchDB.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }


    }
}
