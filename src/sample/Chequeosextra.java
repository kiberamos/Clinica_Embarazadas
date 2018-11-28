package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.nio.BufferUnderflowException;
import java.util.ResourceBundle;

public class Chequeosextra implements Initializable {

        Controller stage1_controller_en_stagech;
        Registro StageRcontroller;
        ObservableList<Embarazada> OembExtras = FXCollections.observableArrayList();
        @FXML
        private TextArea txtextra;
        @FXML
        private Button btnsubmit;


        @FXML
        public void recibeparametrosch(Controller stage1, ObservableList embara) {
            EDiabetes ed = new EDiabetes();
            EHipertension et = new EHipertension();
            OembExtras.clear();
            for (int i = 0; i < embara.size(); i++) {

                if (embara.get(i).getClass().isInstance(ed) || embara.get(i).getClass().isInstance(et)) {
                    OembExtras.add((Embarazada) embara.get(i));
                    }


                }
                // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
                //emb = embten;
                stage1_controller_en_stagech = stage1;
                System.out.println("Extras:" + OembExtras.toString());


            }


        public void imprimirdiabeticas ()
        {
            EDiabetes ed = new EDiabetes();
            EHipertension et = new EHipertension();

            for (int i = 0; i < OembExtras.size(); i++) {


                  txtextra.appendText(OembExtras.get(i).toString());


                }
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //txtextra.appendText("Hola" + "\n");

        }
    }


