package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class Resultados {
    ArrayList <Embarazada> emb = new ArrayList<>();


    Controller stage1_controller_en_stage2;
    Registro StageRcontroller;

    @FXML
    public void recibeparametros(Controller stage1,String texto)
    {

        txtNombre.setText(texto);
        // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
        //emb = embten;
        stage1_controller_en_stage2 = stage1;
    }
    @FXML
    void initialize() {

    }
}
