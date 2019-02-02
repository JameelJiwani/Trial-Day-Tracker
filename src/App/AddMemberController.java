package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {
    @FXML private Button back;
    @FXML private Button add;
    @FXML private TextField fname;
    @FXML private TextField lname;
    @FXML private TextField number;
    @FXML private TextArea comment;
    @FXML protected Text notification;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notification.setVisible(false);
    }

    @FXML private void LoadLandingPage() {
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("Landing Page.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML private void serializeInput() {
        Member newMember = new Member(fname.getText(), lname.getText(), comment.getText(), number.getText());
        //TODO: try and catch exception
        try {
            submitMembertoDB(newMember);
            notification.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fname.clear();
        lname.clear();
        comment.clear();
        number.clear();
    }

    private void submitMembertoDB(Member member) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:h2:~/test", "root", "therootofallevil");

        PreparedStatement stmnt = conn.prepareStatement("INSERT INTO members(first_name, last_name, date_entered, phone_number, comment) VALUES(?, ?, ?, ?, ?)");
        stmnt.setString(1, member.getFirstName());
        stmnt.setString(2, member.getLastName());
        stmnt.setDate(3, new java.sql.Date(member.getDate().getTime()));
        stmnt.setString(4, member.getPhoneNumber());
        stmnt.setString(5, member.getComment());
        stmnt.executeUpdate();

        conn.close();

    }
}
