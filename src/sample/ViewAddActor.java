package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewAddActor {

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
