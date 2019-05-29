package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class LoginController {
    @FXML
    private TextField UserNameField;

    @FXML
    private PasswordField UserPasswordField;

    @FXML
    private TextField PublisherNameField;

    @FXML
    private  PasswordField PublisherPasswordField;


    public void UserLogin(ActionEvent actionEvent) throws IOException {
        if (UserNameField.getText().equals("user") && UserPasswordField.getText().equals("pass")) {
            System.out.println("Login successful");

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
    }

    public void PubLogin(ActionEvent actionEvent) {
        if (PublisherNameField.getText().equals("publisher") && PublisherPasswordField.getText().equals("publisher")) {
            System.out.println("Login successful");
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
