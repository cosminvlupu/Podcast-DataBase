package sample;

import connection.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.io.IOException;


public class LoginController {
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField UserPasswordField;

    @FXML
    private TextField PublisherNameField;

    @FXML
    private PasswordField PublisherPasswordField;


    public void UserLogin(ActionEvent actionEvent) throws IOException, SQLException {
        int ret_code;
        Connection conn = null;
        conn = new Database().getConnection();
        String result = "";
        try {

            CallableStatement pstmt = conn.prepareCall("{call LoginUser(?,?,?)}");
            pstmt.setString(1, UserNameField.getText());
            pstmt.setString(2, UserPasswordField.getText());
            System.out.println(UserNameField.getText() + " "+ UserPasswordField.getText());
            pstmt.registerOutParameter(3, Types.VARCHAR);
            pstmt.executeUpdate();

            result = pstmt.getString(3);
            System.out.println("Aici: " + result);
            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();

            if (result.equals("succes")) {
                System.out.println("Login successful"); // label pentru afisarea erorilor in aplicatie, nu in sout

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ViewSuggestions.fxml"));
                primaryStage.setTitle("Podcast DataBase");
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.show();

                final Node source = (Node) actionEvent.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Login failed");
            }

        } catch (SQLException e) {
            ret_code = e.getErrorCode();
            System.err.println(ret_code + e.getMessage());
            conn.close();
        }

    }

    public void PubLogin(ActionEvent actionEvent) throws IOException, SQLException {
        int ret_code;
        Connection conn = null;
        conn = new Database().getConnection();
        String result = "";
        int count = 0;
        try {

            String podcastsSql = "SELECT count(*) as total FROM PUBLISHERS WHERE PUBLISHERNAME = \'" + PublisherNameField.getText() + "\' AND PASSWORD = \'" + PublisherPasswordField.getText() + "\'" ;
            System.out.println(podcastsSql);
            PreparedStatement statement = conn.prepareStatement(podcastsSql);
            ResultSet rset = statement.executeQuery();
            if (rset.next()) count = rset.getInt("total");

            System.out.println(count);
           // rset.close();
           // st.close();
           // conn.close();

        } catch (SQLException e) {ret_code = e.getErrorCode();
            System.err.println(ret_code + e.getMessage()); conn.close();}

        if (count != 1) {
            System.out.println("Login successful");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewMyPodcasts.fxml"));
            primaryStage.setTitle("Podcast DataBase");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();

            final Node source = (Node) actionEvent.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("Login failed");
        }
    }

    public void SignUp(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 325, 325));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
