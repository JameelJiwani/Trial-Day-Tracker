package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommentPageController implements Initializable {

    @FXML
    private Button back;
    @FXML private Text FullName;
    @FXML private Text PhoneNumber;
    @FXML private Text Comment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FullName.setText(SearchDBController.member.getFirstName() + " " + SearchDBController.member.getLastName());
        PhoneNumber.setText(SearchDBController.member.getPhoneNumber());
        Comment.setText(SearchDBController.member.getComment());
    }

    @FXML private void LoadSearchDB() {
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("SearchDB.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}