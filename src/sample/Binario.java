package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Binario implements Initializable {

    FicherosBinarios fb = new FicherosBinarios();
    FileOutputStream fos = new FileOutputStream("Embarazadas.bin",true);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    FileInputStream fis =  new FileInputStream("Embarazadas.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);

    Controller stage1_controller_en_stagebr;
    Registro StageRcontroller;
    ObservableList<Embarazada> OembBinario = FXCollections.observableArrayList();
    ArrayList arr = new ArrayList();
    ArrayList P2 = new ArrayList();
    ArrayList P3 = new ArrayList();
    ArrayList P4 = new ArrayList();

    @FXML
    private Button btnclose;
    @FXML
    private Button btnread;
    @FXML
    private Button btnP1;
    @FXML
    private Button btnP2;
    @FXML
    private Button btnP3;
    @FXML
    private Button btnP4;

    public Binario() throws IOException {
    }


    @FXML
    public void recibeparametrosbr(Controller stage1, ObservableList embara) {
        arr.add("1) Almacenar todas las embarazadas del consultorio" + "\n");
        arr.add("Lista de Embarazadas" + "\n");

        for (int i = 0; i < embara.size(); i++) {

            OembBinario.add((Embarazada) embara.get(i));
            arr.add(embara.get(i));
        }
        stage1_controller_en_stagebr = stage1;
        System.out.println("Binario:" + OembBinario.toString());



    }

    public void pregunta2()
    {
        P2.clear();
        P2.add("2)  Almacenar el nombre y el número de historia clínica de cada embarazada en riesgo." + "\n");
        P2.add("Embarazadas en riesgo" + "\n");

        for (int i = 0; i < OembBinario.size(); i++) {

            if (OembBinario.get(i).getRiesgos()==true)
            {

                P2.add(" Nombre: " + OembBinario.get(i).getNombre() + " Historia Clinica: "+ OembBinario.get(i).getHclinica()+ "\n");
            }
        }
    }

    public void pregunta3()
    {
        P3.clear();
        P3.add("3)  Almacenar el nombre y el número de historia clínica de las embarazadas en riesgo, mayoresde 35 años" + "\n");
        P3.add("Embarazadas en riesgo Mayores a 35 anos" + "\n");
        EMayor em = new EMayor();
        for (int i = 0; i < OembBinario.size(); i++) {

            if (OembBinario.get(i).getClass().isInstance(em)== true && OembBinario.get(i).getRiesgos()==true)
            {

                P3.add(" Nombre: " + OembBinario.get(i).getNombre() + " Historia Clinica: "+ OembBinario.get(i).getHclinica()+ "\n");
            }
        }
    }

    public void pregunta4()
    {
        P4.clear();
        EDiabetes ed = new EDiabetes();
        EHipertension et = new EHipertension();
        ArrayList<EDiabetes> Ediabetes = new ArrayList();
        ArrayList<EHipertension> Ehipertension = new ArrayList();
        P4.add("4) Almacenar el nombre, el número de historia clínica y el valor de las embarazadas que se hayan efectuado chequeo auxiliar." + "\n");
        P4.add("Embarazadas que se realizaron chequeos Auxiliares" + "\n");
        for (int i = 0; i < OembBinario.size(); i++) {

            if (OembBinario.get(i).getClass().isInstance(ed)) {
                Ediabetes.add((EDiabetes) OembBinario.get(i));
            }
            if (OembBinario.get(i).getClass().isInstance(et))
            {
                Ehipertension.add((EHipertension) OembBinario.get(i));
            }
        }
        for (int i = 0; i < Ediabetes.size(); i++)
        {
            P4.add(" Nombre: " + Ediabetes.get(i).getNombre()+ " Historia Clinica: "+ Ediabetes.get(i).getHclinica()+ " PTG = " + Ediabetes.get(i).getPTG()+ " Glucosa = " + Ediabetes.get(i).getGlucosa()+ "\n");

        }
        for (int i = 0; i < Ehipertension.size(); i++)
        {
            P4.add(" Nombre: " + Ehipertension.get(i).getNombre()+ " Historia Clinica: "+ Ehipertension.get(i).getHclinica()+ " Tension Arterial = " + Ehipertension.get(i).getTensionArterial()+ " Pulsaciones = " + Ehipertension.get(i).getPulsaciones()+ "\n");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnclose.setOnAction((event) -> {
            try {


                oos.close();
                fis.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnread.setOnAction((event) -> {

            try {
                fb.leer_binario();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e);
                //e.printStackTrace();
            }
        });

        btnP1.setOnAction((event) -> {

            fb.escribir_binario(oos,arr);
            try {
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        btnP2.setOnAction((event) -> {
            pregunta2();
            fb.escribir_binario(oos,P2);
            try {
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        btnP3.setOnAction((event) -> {
            pregunta3();
            fb.escribir_binario(oos,P3);
            try {
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        btnP4.setOnAction((event) -> {
            pregunta4();
            fb.escribir_binario(oos,P4);
            try {
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }
}
