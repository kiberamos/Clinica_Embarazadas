package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private ArrayList <Embarazada> emb = new ArrayList<>();

    @FXML
    private Button btnRegistro;
    @FXML
    private Button btnExamenesA;
    @FXML
    private Button btnResultados;

    //_________________________________________Paso de Valores a Ventanas_______________________________________________
    Controller Stage1controller;

    @FXML
    public void recibeparametros (Embarazada embara)
    {
       // txtprueba.setText(texto);
        emb.add(embara);
        System.out.println(emb.toString());
    }

    @FXML
    private void llamar_stage2() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Registro.fxml").openStream());
        Registro RegistroInstancia = (Registro)loader.getController();

        RegistroInstancia.recibeparametros(Stage1controller,"Prueba");
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Stage1controller=this;

    }
}
