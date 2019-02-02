package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SearchDBController implements Initializable {

    @FXML
    private ListView<Member> memberList = new ListView<>();
    @FXML private TextField keyword;
    @FXML
    private Button back;
    @FXML private Button open;
    public static Member member;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try (
                Connection conn = DriverManager.getConnection(passkey.getDatabase(), passkey.getUsername(), passkey.getPassword());
                Statement stmt = conn.createStatement();
        ) {
            String query = "SELECT first_name, last_name, date_entered, phone_number, comment, date_entered FROM members";

            ResultSet rset = stmt.executeQuery(query);


            while (rset.next()) {
                memberList.getItems().add(new Member(rset.getString("first_name"), rset.getString("last_name"), rset.getString("comment"), rset.getDate("date_entered"), rset.getString("phone_number")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void LoadLandingPage() {
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("Landing Page.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML private void openCommentPage() {
        member = memberList.getSelectionModel().getSelectedItem();
        Stage stageTheLabelBelongs = (Stage) open.getScene().getWindow();
        try {
            stageTheLabelBelongs.setScene(new Scene(FXMLLoader.load(getClass().getResource("Comment Page.fxml")), 1000, 500));
        } catch(IOException e) {
            System.out.println(e);
        }
    }


    @FXML
    private void search() {


        memberList.getItems().removeAll(memberList.getItems());

        try (
                Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "root", "therootofallevil");
                Statement stmt = conn.createStatement();
        ){
            String query = "SELECT * FROM members WHERE first_name LIKE '%" + keyword.getText() + "%' or last_name LIKE '%" + keyword.getText() + "%' or phone_number LIKE '%" + keyword.getText() +  "%'";

            ResultSet rset = stmt.executeQuery(query);

            while(rset.next()) {
                memberList.getItems().add(new Member(rset.getString("first_name"), rset.getString("last_name"), rset.getString("comment"), rset.getDate("date_entered"), rset.getString("phone_number")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
