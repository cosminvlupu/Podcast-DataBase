package sample;

import connection.CreateConnection;
import connection.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignUpController {
    @FXML
    private TextField emailInput;

    @FXML
    private TextField signUpNameInput;

    @FXML
    private PasswordField signUpPasswordInput;

    @FXML
    private PasswordField signUpPasswordRepeat;

    @FXML
    private Label label;


    public void Signup(ActionEvent actionEvent) throws IOException, SQLException {

        label.setText("");

        String name = signUpNameInput.getText();
        String password = signUpPasswordInput.getText();
        String passwordAgain = signUpPasswordRepeat.getText();
        String email = emailInput.getText();

        int ret_code;
        Connection conn = null;
        conn = new Database().getConnection();
        String result = "";
        try {

            CallableStatement pstmt = conn.prepareCall("{call CREATE_USER(?,?,?)}");
            pstmt.setString(1, name.toString());
            pstmt.setString(2, email.toString());//ADAUGA CAMP DE EMAIL
            pstmt.setString(3, password.toString());

            pstmt.executeUpdate();

            // pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            ret_code = e.getErrorCode();
            label.setText(ret_code + e.getMessage());
            conn.close();
        }

        if (name.isEmpty() || password.isEmpty() || passwordAgain.isEmpty() || email.isEmpty()) {
            label.setText("All fields are required");
        } else {
            if (password.equals(passwordAgain)) {
                label.setText(name + " signed up!");

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                primaryStage.setTitle("Podcast DataBase");
                primaryStage.setScene(new Scene(root, 475, 275));
                primaryStage.show();

                final Node source = (Node) actionEvent.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

            } else {
                signUpPasswordInput.setText("");
                signUpPasswordRepeat.setText("");
                label.setText("Passwords don't match. Try again.");
            }
        }
    }

    public void Login(ActionEvent actionEvent) throws IOException{
        label.setText("");

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 472, 275));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
