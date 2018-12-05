package sample;

import java.awt.*;
import java.awt.TextField;
import java.io.*;
import java.net.URL;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Resultados implements Initializable, Serializable {
    ArrayList <Embarazada> emb = new ArrayList<>();
    ObservableList<Embarazada> Vacia = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oemb = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembRiesgo = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembDiab = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> OembRiesgoMayor = FXCollections.observableArrayList(emb);
    private ArrayList<Embarazada> Agenda;
    public ArrayList<EDiabetes> Diabetes = new ArrayList();
    public ArrayList NumerosDiabetes = new ArrayList();
    public ArrayList<Embarazada> Mayor = new ArrayList();
    public ArrayList<Embarazada> Riesgo = new ArrayList();
    public ArrayList NumerosRiesgo = new ArrayList();
    public ArrayList<Embarazada> Riesgomay = new ArrayList();
    public ArrayList NumerosRiesgomay = new ArrayList();
    public ArrayList Extrass = new ArrayList();
    public ArrayList mayor =  new ArrayList();
    private Embarazada Embacontacto;

    //FicherosBinarios fb = new FicherosBinarios();
    //FileOutputStream fos = new FileOutputStream("Embarazadas.bin",true);
    //ObjectOutputStream oos = new ObjectOutputStream(fos);
    //FileInputStream fis =  new FileInputStream("Embarazadas.bin");


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
    @FXML
    private Button  btncheck;
    @FXML
    private Button btnmayorptg;
    @FXML
    private Label lblRiesgoMayor;
    @FXML
    private TextArea txtprp;


    Controller stage1_controller_en_stage2;

    public Resultados() throws IOException {
    }

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
                Riesgo.add(Oemb.get(i));
            }
        }

        lblRiesgo.setText(String.valueOf(OembRiesgo.size()));
        tblvw.setItems(OembRiesgo);

        NumerosRiesgo.add("Cantidad de Embarazadas que se consideran en riesgo: " + OembRiesgo.size() + "\n");
        //NumerosRiesgo.add(OembRiesgo.size());

        btnDiab.setVisible(true);
        btnRiesmay.setVisible(true);

        System.out.println(NumerosRiesgo.toString());
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
                Diabetes.add((EDiabetes) Oemb.get(i));
            }
        }
        //NumerosDiabetes.add("listado de embarazadas diabéticas: " + "\n");
       // NumerosDiabetes.addAll(Diabetes);

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
                Riesgomay.add(Oemb.get(i));
            }
        }
        NumerosRiesgomay.add("Total de embarazadas en riesgo que tienen más de 35 años = " + OembRiesgoMayor.size() + "\n");
        lblRiesgoMayor.setText(String.valueOf(OembRiesgoMayor.size()));
        tblvw.setItems(OembRiesgoMayor);
        System.out.println(OembDiab.toString());

    }


    @FXML
    public void llenarlistaextra()
    {
        EDiabetes ed = new EDiabetes();
        EHipertension et = new EHipertension();
        ArrayList<EDiabetes> Ediabetes = new ArrayList();
        ArrayList<EHipertension> Ehipertension = new ArrayList();
        for (int i = 0; i < Oemb.size(); i++) {

            if (Oemb.get(i).getClass().isInstance(ed)) {
                Ediabetes.add((EDiabetes) Oemb.get(i));
            }
            if (Oemb.get(i).getClass().isInstance(et))
            {
                Ehipertension.add((EHipertension) Oemb.get(i));
            }
        }
        for (int i = 0; i < Ediabetes.size(); i++)
        {
            Extrass.add(" Nombre: " + Ediabetes.get(i).getNombre()+ " PTG = " + Ediabetes.get(i).getPTG()+ " Glucosa = " + Ediabetes.get(i).getGlucosa()+ "\n");

        }
        for (int i = 0; i < Ehipertension.size(); i++)
        {
            Extrass.add(" Nombre: " + Ehipertension.get(i).getNombre()+ " Tension Arterial = " + Ehipertension.get(i).getTensionArterial()+ " Pulsaciones = " + Ehipertension.get(i).getPulsaciones()+ "\n");
        }
        System.out.println(Extrass.toString());
    }



    @FXML
    public void encontrarmayorPTG ()
    {
        EDiabetes ed = new EDiabetes();
        ArrayList<EDiabetes> Ediabetes = new ArrayList();
        ArrayList indice = new ArrayList();
        float c = 0;
        int m=0;

        for (int i = 0; i < Oemb.size(); i++) {

            if (Oemb.get(i).getClass().isInstance(ed)) {
                Ediabetes.add((EDiabetes) Oemb.get(i));
            }
        }

        for (int i = 0; i < Ediabetes.size(); i++) {

            if (Ediabetes.get(i).getPTG()>c)
            {
                c = Ediabetes.get(i).getPTG();
                m = i;

            }
        }
    System.out.println("Mayor PTG" + Ediabetes.get(m));
        mayor.add(Ediabetes.get(m));
    }





    //________________________________________Paso de valores hacia Resultados Diabetes_________________________________

    @FXML
    private void llamar_stageresultadosdiabetes() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("ResultadosDiabeticas.fxml").openStream());
        ResultadosDiabeticas RegistroInstancia = (ResultadosDiabeticas) loader.getController();

        RegistroInstancia.recibeparametros(stage1_controller_en_stage2,Oemb);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    //__________________________________________________________________________________________________________________

    //___________________________________Paso de valores hacia Resultados Chequeos Extra________________________________

    @FXML
    private void llamar_stageChequeosExtra() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Chequeosextra.fxml").openStream());
        Chequeosextra RegistroInstanciach = (Chequeosextra) loader.getController();

        RegistroInstanciach.recibeparametrosch(stage1_controller_en_stage2,Oemb);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    //__________________________________________________________________________________________________________________
    //___________________________________Paso de valores hacia Binario__________________________________________________

    @FXML
    private void llamar_stageBinarios() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Binario.fxml").openStream());
        Binario RegistroInstanciabr = (Binario) loader.getController();

        RegistroInstanciabr.recibeparametrosbr(stage1_controller_en_stage2,Oemb);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    //__________________________________________________________________________________________________________________



    public void leer_binario(){

        //FileInputStream fis;
        //ObjectInputStream ois;
        //DataInputStream dis;
        Agenda = new ArrayList();
        String str;

        //ois =  new ObjectInputStream(fis);


        System.out.println("Listado de Embarazadas");
        // System.out.println(ois.readUTF());


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(Oemb.toString());

        btnDiab.setVisible(false);
        btnRiesmay.setVisible(false);



        Nombrecolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        tblvw.setItems(Oemb);

        btnRiesgo.setOnAction((event) -> {
            llenarlistaRiesgo();
        });

        btnprueba.setOnAction((event) -> {

            try {
                llamar_stageBinarios();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*escribir_binario();
            leer_binario();
            fb.escribir_binario(fos,oos,NumerosRiesgo,Diabetes,NumerosRiesgomay,mayor,Extrass);
            try {
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            leer_binario();
            */
        });

        btncheck.setOnAction((event) -> {

            try {
                llamar_stageChequeosExtra();
            } catch (IOException e) {
                e.printStackTrace();
            }
            llenarlistaextra();

        });

        btnmayorptg.setOnAction((event) -> {

            try {
                llamar_stageresultadosdiabetes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            encontrarmayorPTG();

        });



    }
}