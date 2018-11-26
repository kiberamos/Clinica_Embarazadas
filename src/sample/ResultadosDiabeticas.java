package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultadosDiabeticas implements Initializable {

    Controller stage1_controller_en_stage;
    Registro StageRcontroller;
    ObservableList<Embarazada> OembDiab = FXCollections.observableArrayList();

    @FXML
    private TableView<Embarazada> tblvw;
    @FXML
    private TableColumn<Embarazada,String> Nombrecolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicacolumn;
    @FXML
    private TableColumn<Embarazada,String> Examencolumn;
    @FXML
    private TableColumn<Embarazada,Float> PTGcolumn;
    @FXML
    private TableColumn<Embarazada,Float> Glucosacolumn;


    @FXML
    public void recibeparametros(Controller stage1, ObservableList embara) {
        EDiabetes ed = new EDiabetes();
        OembDiab.clear();
        for (int i = 0; i < embara.size(); i++) {

            if (embara.get(i).getClass().isInstance(ed)) {
                OembDiab.add((Embarazada) embara.get(i));
            }
            // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
            //emb = embten;
            stage1_controller_en_stage = stage1;
            System.out.println(OembDiab.toString());

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Nombrecolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        PTGcolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Float>("PTG"));
        Glucosacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Float>("Glucosa"));
        tblvw.setItems(OembDiab);

    }
}