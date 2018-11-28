package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    private boolean validateFields() {
        if (txtnumero.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("El valor esta en Blanco");
            alert.showAndWait();
            return false;
        }
        return true;
    }
        @FXML
        void cerrar()
        {
            if (validateFields()) {
                stageRegistro_controller_en_stageAdicinoales.recibeparametrosdia(Integer.parseInt(txtnumero.getText()));
                Stage stage = (Stage) btnagregar.getScene().getWindow();
                stage.close();
            }

        }

    public void checknumber()
    {
        txtnumero.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtnumero.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });



    }




        @Override
        public void initialize(URL location, ResourceBundle resources) {
            checknumber();
        }
    }




