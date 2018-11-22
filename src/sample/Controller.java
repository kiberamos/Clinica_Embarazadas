package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private ArrayList <Embarazada> emb;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button btnRegistro;
    @FXML
    private Button btnExamenesA;
    @FXML
    private Button btnResultados;

//________________________________________________Cambio de Pantallas___________________________________________________

    public void newpageRegistro(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void newpageAdicional(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("Adicionales.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void newpageResultados(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("Resultados.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }
//_____________________________________________Fin de Cambio de Pantallas_______________________________________________


















    @FXML
    private void initialize() {



    }
}
