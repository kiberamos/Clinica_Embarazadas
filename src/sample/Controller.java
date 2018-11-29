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
    private ObservableList<Embarazada> Oemb = FXCollections.observableArrayList();

    //__________________________________________Arrays para probar elprograma___________________________________________
    private ArrayList <Integer> TensionArterial = new ArrayList<>();
    private ArrayList <Examen> Examenes = new ArrayList<>();
    //__________________________________________________________________________________________________________________


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
        Oemb.add(embara);
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

        RegistroInstancia.recibeparametros(Stage1controller);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    @FXML
    private void llamar_stageresultados() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Resultados.fxml").openStream());
        Resultados RegistroInstancia = (Resultados)loader.getController();

        RegistroInstancia.recibeparametrosResEmb(Stage1controller,emb);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    @FXML
    private void llamar_stageeditarEmb() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Resultados.fxml").openStream());
        Resultados RegistroInstancia = (Resultados)loader.getController();

        RegistroInstancia.recibeparametrosResEmb(Stage1controller,emb);
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


    @FXML
    public void instance ()
    {

        EDiabetes ed = new EDiabetes();

        for(int x=0;x<emb.size();x++) {
            //System.out.println(emb.get(x).getClass().toString());
            //System.out.println(emb.get(x).getClass().getName());
            //System.out.println(emb.get(x).getClass().getPackageName());
            //System.out.println(emb.get(x).getClass().getTypeName());

            if (emb.get(x).getClass().isInstance(ed)== true)
            {
                System.out.println("Siiii lo lograste es diabetica");
            }else{
                System.out.println("no no lo se");
            }
        }




    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Examenes.add(new Examen("Especial","Positivo"));
        Examenes.add(new Examen("Normal","Negativo"));
        TensionArterial.add(100);

        try {
            emb.add(new EDiabetes("Joel",1,Examenes,1,12));
        } catch (MyException e) {
            e.printStackTrace();
        }
        emb.add(new EMayor("Nicole",2,Examenes,"Positivo"));
        try {
            emb.add( new EHipertension("Juana",3,Examenes,TensionArterial,16));
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            emb.add(new EJoven("Paloma",4,Examenes,17));
        } catch (MyException e) {
            e.printStackTrace();
        }

        Stage1controller=this;

    }
}
