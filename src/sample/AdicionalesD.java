package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdicionalesD implements Initializable {



        @FXML
        private TextField txtnumero;
        @FXML
        private Button btnagregar;

        private ArrayList<Embarazada> embAdi = new ArrayList<>();



        //____________________________________Paso de Datos modificado a Adicionales________________________________________

        Registro stageRegistro_controller_en_stageAdicinoales;
        Registro StageRcontroller;

        @FXML
        public void recibeparametros(Registro stage1)
        {

            //txtnumero.setText(String.valueOf(entero));
            // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
            //emb = embten;
            stageRegistro_controller_en_stageAdicinoales = stage1;
        }





        @FXML
        void cerrar()
        {

            stageRegistro_controller_en_stageAdicinoales.recibeparametrosdia(Integer.parseInt(txtnumero.getText()));
            Stage stage = (Stage) btnagregar.getScene().getWindow();
            stage.close();

        }




        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
    }




