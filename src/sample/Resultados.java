package sample;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Resultados {
    ArrayList <Embarazada> emb = new ArrayList<>();

    @FXML
    private Button btnprueba;


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
    public void recibeparametrosResEmb (Controller stage1 , ArrayList embara)
    {
        // txtprueba.setText(texto);
       // emb.add(embara);
        emb = (ArrayList) embara.clone();
        System.out.println(embara.toString());
        stage1_controller_en_stage2 = stage1;

    }


    public void prueba()
    {
        System.out.println(emb.toString());
    }



    @FXML
    void initialize() {

    }
}
