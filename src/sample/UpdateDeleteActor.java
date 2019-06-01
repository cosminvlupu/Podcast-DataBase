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
import java.sql.*;

public class UpdateDeleteActor {

    @FXML
    TextField id;

    @FXML
    TextField fname;

    @FXML
    TextField lname;

    @FXML
    Label label;

    public void update(ActionEvent actionEvent) {

        label.setText("");
        String firstName = fname.getText();
        String lastName = lname.getText();
        String actorId = id.getText();

        Connection conn = null;
        conn = new Database().getConnection();

        if (actorId.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            label.setText("All fields are mandatory for an update");
        } else {
            try {
                CallableStatement cs = conn.prepareCall("call update_actor(?,?,?)");
                cs.setInt(1,Integer.parseInt(actorId));
                cs.setString(2,firstName.toString());
                cs.setString(3,lastName.toString());

                cs.executeUpdate();
                label.setText("Actor Updated");
            } catch (SQLException e) {
                label.setText(e.toString());
            }
        }
    }

    public void delete(ActionEvent actionEvent) {
        label.setText("");
        String actorId = id.getText();
        Connection conn = null;
        conn = new Database().getConnection();

        if (actorId.isEmpty()) {
            label.setText("ID is needed for delete");
        }else{
            try {
                CallableStatement cs = conn.prepareCall("call delete_actor(?)");
                cs.setInt(1,Integer.parseInt(actorId));

                cs.executeUpdate();
                label.setText("Actor Deleted");
            } catch (SQLException e) {
                label.setText(e.toString());
            }
        }
    }

    public void getException(ActionEvent actionEvent) {
        label.setText("");

        Connection conn = null;
        conn = new Database().getConnection();

        try {
            CallableStatement cs = conn.prepareCall("call functie_de_eroare(?)");
            cs.setString(1," ");

            cs.executeUpdate();
            label.setText("Exception");
        } catch (SQLException e) {
            label.setText(e.toString());
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
}
