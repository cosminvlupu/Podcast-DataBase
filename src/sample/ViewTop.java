package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewTop {

    @FXML
    private ComboBox genres;

    public void ToTop(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewTop.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToSuggestions(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewSuggestions.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToFollowing(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewFollowing.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToPodcasts(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPodcasts.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToActors(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewActors.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToDirectors(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewDirectors.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void ToPublishers(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPublishers.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    public void ToWriters(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewWriters.fxml"));
        primaryStage.setTitle("Podcast DataBase");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
