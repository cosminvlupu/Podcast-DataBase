package sample;

import connection.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ViewAddDirector {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private Label label;

    public void add(ActionEvent actionEvent) throws SQLException {

        label.setText("");

        if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
            label.setText("All fields are required");
        }
        else {

            String fName = firstName.getText();
            String lName = lastName.getText();

            int ret_code;
            Connection conn = null;
            conn = new Database().getConnection();
            String result = "";

            try {

                CallableStatement pstmt = conn.prepareCall("{call Add_director(?,?)}");
                pstmt.setString(1, fName.toString());
                pstmt.setString(2, lName.toString());

                pstmt.executeUpdate();

                label.setText(fName + " " + lName + " was added to " + "directors");
                // pstmt.close();
                //conn.close();
            } catch (SQLException e) {
                ret_code = e.getErrorCode();
                label.setText(ret_code + e.getMessage());
                conn.close();
            }
        }
    }

    public void ToMyPodcasts(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewMyPodcasts.fxml"));
        primaryStage.setTitle("Podcast DataBase Publisher");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToViewAddPodcast(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewAddPodcast.fxml"));
        primaryStage.setTitle("Podcast DataBase Publisher");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToViewAddActor(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewAddActor.fxml"));
        primaryStage.setTitle("Podcast DataBase Publisher");
        primaryStage.setScene(new Scene(root, 425, 250));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToViewAddDirector(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewAddDirector.fxml"));
        primaryStage.setTitle("Podcast DataBase Publisher");
        primaryStage.setScene(new Scene(root, 425, 250));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToViewAddWriter(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewAddWriter.fxml"));
        primaryStage.setTitle("Podcast DataBase Publisher");
        primaryStage.setScene(new Scene(root, 425, 250));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
