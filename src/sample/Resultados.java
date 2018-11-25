package sample;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

public class Resultados {
    ArrayList <Embarazada> emb = new ArrayList<>();
    ObservableList<Embarazada> Vacia = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oemb = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembRiesgo = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembDiab = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembRiesgoMayor = FXCollections.observableArrayList(emb);





    @FXML
    private Button btnprueba;
    @FXML
    private TableView<Embarazada> tblvw;
    @FXML
    private TableColumn<Embarazada,String> Nombrecolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicacolumn;
    @FXML
    private TableColumn<Embarazada,String> Examencolumn;
    @FXML
    private Button btnRiesgo;
    @FXML
    private Label lblRiesgo;
    @FXML
    private Button btnDiab;
    @FXML
    private Button btnRiesmay;


    Controller stage1_controller_en_stage2;

    @FXML
    public void recibeparametrosRes(Controller stage1,String texto)
    {

       System.out.println(texto);
        // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
        //emb = embten;
        stage1_controller_en_stage2 = stage1;
    }


    @FXML
    public void recibeparametrosResEmb (Controller stage1 , ArrayList embara) {
        // txtprueba.setText(texto);
        // emb.add(embara);
        //emb = (ArrayList) embara.clone();

        for (int i = 0; i < embara.size(); i++) {
            Oemb.add((Embarazada) embara.get(i));
        }
            System.out.println(embara.toString());
            stage1_controller_en_stage2 = stage1;


    }

    @FXML
    public void prueba()
    {
        System.out.println("Observable" + Oemb.toString());
        for (int i = 0; i < Oemb.size(); i++) {
            System.out.println(OembRiesgo);
        }

        for (int i = 0; i < Oemb.size(); i++) {

            if (Oemb.get(i).getRiesgos()==true)
            {
                OembRiesgo.add(Oemb.get(i));
            }
        }


        tblvw.setItems(OembRiesgo);
    }

    @FXML
    public void llenarlistaRiesgo()
    {

        //System.out.println("Observable" + Oemb.toString());
        OembRiesgo.clear();
        for (int i = 0; i < Oemb.size(); i++) {

            if (Oemb.get(i).getRiesgos()==true)
            {

                OembRiesgo.add(Oemb.get(i));
            }
        }

        lblRiesgo.setText(String.valueOf(OembRiesgo.size()));
        tblvw.setItems(OembRiesgo);

        btnDiab.setVisible(true);
        btnRiesmay.setVisible(true);
    }

    @FXML
    public void llenarlistaDiabeticas()
    {
        tblvw.getItems().clear();
        //System.out.println("Observable" + Oemb.toString());
        EDiabetes ed = new EDiabetes();
        OembDiab.clear();
        for (int i = 0; i < Oemb.size(); i++) {


            if (Oemb.get(i).getClass().isInstance(ed)== true)
            {

                OembDiab.add(Oemb.get(i));
            }
        }

        tblvw.setItems(OembDiab);
    }

    @FXML
    public void llenarlistariegomayores()
    {
        tblvw.getItems().clear();
        //System.out.println("Observable" + Oemb.toString());
        EDiabetes ed = new EDiabetes();
        EMayor em = new EMayor();
        OembRiesgoMayor.clear();
        for (int i = 0; i < Oemb.size(); i++) {


            if (Oemb.get(i).getClass().isInstance(em)== true && Oemb.get(i).getRiesgos()==true)
            {

                OembRiesgoMayor.add(Oemb.get(i));
            }
        }

        tblvw.setItems(OembRiesgoMayor);
    }






    @FXML
    void initialize() {

        btnDiab.setVisible(false);
        btnRiesmay.setVisible(false);


        Nombrecolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        tblvw.setItems(Oemb);


    }
}
