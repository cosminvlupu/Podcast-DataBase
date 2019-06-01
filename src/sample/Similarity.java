package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Similarity {

    @FXML
    TextField firstUser;

    @FXML
    TextField secondUser;

    @FXML
    Label label;

    @FXML
    Button calculateSimilarity;

    @FXML
    Button backToMyPodcasts;

    public void calculateSim(ActionEvent actionEvent){
        label.setText("");
        if(firstUser.getText().isEmpty() || secondUser.getText().isEmpty()){
            label.setText("all fields are required");}

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

}
