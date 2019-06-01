package sample;

import connection.Database;
import controllers.PodcastController;
import entities.Podcast;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;
import oracle.jdbc.OracleTypes;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class ViewPodcasts extends Application {
    @FXML
    TableView podcastTable;
    /*@FXML
    TableColumn<Podcast, Integer> podcastNr;
    @FXML
    TableColumn<Podcast, String> podcastTitle;
    @FXML
    TableColumn<Podcast, String> podcastDescription;
    @FXML
    TableColumn<Podcast, Date> podcastDate;*/
    @FXML
    Button button;

    @FXML
    Button left;

    @FXML
    Button right;

    @FXML
    TextField howMany;

    @FXML
    Label label;

    private int amount = 10;
    private int leftValue = -10;
    private int rightValue = 0;

    private PodcastController podcastController;
    private ObservableList<ObservableList> data;

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

    public void buildData(int lefty, int righty) {
        Connection conn = null;
        conn = new Database().getConnection();

        try {
            CallableStatement cstmt = conn.prepareCall("{? = call paginarea_podcasturilor(?,?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setInt(2, lefty);
            cstmt.setInt(3, righty);

            System.out.println(cstmt);
            cstmt.execute();
            System.out.println(cstmt.toString());
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            ObservableList data = FXCollections.observableArrayList();

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                //System.out.println(rs.getMetaData().getColumnName(i+1));
                col.setMinWidth(25.0);
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        System.out.println(param.getValue().get(j).toString());
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                podcastTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }

            //FINALLY ADDED TO TableView
            podcastTable.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public void toLeft() {
        System.out.println("AM INTRAT AICI, APEL BUN!");
        if(howMany.getText().isEmpty())
            howMany.setText("0");

        if (this.leftValue - Integer.parseInt(howMany.getText()) >= 1) {
            label.setText("");
            this.rightValue = this.leftValue - 1;
            this.leftValue = this.leftValue - Integer.parseInt(howMany.getText());

            podcastTable.getItems().clear();
            podcastTable.getColumns().clear();

            buildData(this.leftValue, this.rightValue);
        }
        else {
            label.setText("Already at the beginning!");
        }
    }

    public void toRight()  {
        System.out.println("AM INTRAT AICI, APEL BUN!");
        if(howMany.getText().isEmpty())
            howMany.setText("0");
        System.out.println(Integer.parseInt(howMany.getText()));
        if (this.rightValue + Integer.parseInt(howMany.getText()) < 1000008) {
            label.setText("");
            this.leftValue = this.rightValue + 1;
            this.rightValue = this.leftValue + Integer.parseInt(howMany.getText()) - 1;

            podcastTable.getItems().clear();
            podcastTable.getColumns().clear();

            System.out.println(this.leftValue + " " + this.rightValue );
            buildData(this.leftValue, this.rightValue);
        }
        else {
            label.setText("Already at the end!");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Main Scene
        Scene scene = new Scene(podcastTable);
        System.out.println("Chiar intru aici!");
        stage.setScene(scene);
        stage.show();

    }
}
