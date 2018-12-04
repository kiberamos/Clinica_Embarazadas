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
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable, Serializable {

    private ArrayList <Embarazada> emb = new ArrayList<>();
    private ObservableList<Embarazada> Oemb = FXCollections.observableArrayList();
    private ArrayList<Embarazada> Agenda;
    private Embarazada Embacontacto;

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
    public void recibeparametroseditado(ObservableList oedit)
    {
        emb.clear();
        emb.addAll(oedit);
       // Stage1controller = stage1;
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
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Edit.fxml").openStream());
        Edit RegistroInstancia = (Edit) loader.getController();

        RegistroInstancia.recibeparametrosEdit(Stage1controller,emb);
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
/*
    public void escribir_binario(){
        File fichero = new File("Embarazadas.bin");
        Agenda = new ArrayList();
        Agenda.addAll(emb);
        FileOutputStream fos;
        ObjectOutputStream oos;
        BufferedOutputStream fff;
        OutputStreamWriter osw;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(fichero,true);

            oos = new ObjectOutputStream(fos);

            dos = new DataOutputStream(fos);

            //oos.writeUTF("hola"+Agenda.toString());
            //dos.writeUTF(Agenda.toString());

            //oos.writeUTF(Agenda.toString());


            //oos.writeObject(emb);
            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error en la localizacion del archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        }

    }

    public void leer_binario(){

        FileInputStream fis;
        ObjectInputStream ois;
        DataInputStream dis;
        Agenda = new ArrayList();

        try {
            fis =  new FileInputStream("Embarazadas.bin");
            ois =  new ObjectInputStream(fis);
            dis =  new DataInputStream(fis);
           // Agenda =  (ArrayList<Embarazada>) ois.readObject();
            System.out.println("Listado de Embarazadas");
            //System.out.println(ois.readUTF());
            //System.out.println(dis.readUTF());

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
            //System.out.println("Error no hay clase");
            //e.printStackTrace();
        //}

    }

    public void ListarDatos()
    {
        //System.out.println("Listado de Embarazadas");
        System.out.println(Agenda.toString());
        for (Embarazada Elemento:Agenda)
        {

            Embacontacto = new EJoven();
//            Embacontacto = new Embarazada() {
//                @Override
//                boolean getRiesgos() {
//                    return false;
//                }
//            };
            Embacontacto = Elemento;
            //MostrarDato();
        }
    }



    public void MostrarDato()
    {
        System.out.println(Embacontacto.getNombre());
    }

*/
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

        btnResultados.setOnAction((event) -> {
            try {
                llamar_stageresultados();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // escribir_binario();
            //leer_binario();
            //ListarDatos();

        });

    }
}
