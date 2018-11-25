package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Registro implements Initializable
{
    @FXML
    private AnchorPane anc;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtHclinica;
    @FXML
    private TextField txtExamRutina;
    @FXML
    private ComboBox cmbExamnRutina;
    @FXML
    private Button btnagrEmbarazada;
    @FXML
    private Button btnShowexam;
    @FXML
    private Button btnAgregarTensiones;
    @FXML
    private RadioButton radMenor;
    @FXML
    private RadioButton radMayor;
    @FXML
    private RadioButton radTension;
    @FXML
    private RadioButton radDiabetes;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtPTG;
    @FXML
    private TextField txtTension;
    @FXML
    private ComboBox cmbAmeno;
    @FXML
    private Button btnNext;
    @FXML
    private Label lblinstruc;
    @FXML
    private Label lbledad;
    @FXML
    private Label lblPTG;
    @FXML
    private Label lblTension;
    @FXML
    private Label lblamneo;
    @FXML
    private Label lbledad2;
    @FXML
    private Label lblPTG2;
    @FXML
    private Label lblTension2;


    ArrayList<Embarazada> Aembarazadas = new ArrayList();
    ArrayList<Examen> exmas = new ArrayList();
    ObservableList<String> amneolist = FXCollections.observableArrayList("Positivo","Negativo");
    ObservableList<String> rutinalist = FXCollections.observableArrayList("Positivo","Negativo");
    ArrayList<Integer> TensionArterial = new ArrayList<>();
    private float Glucosa;
    private float Tension;


    //____________________________________Paso de Datos_________________________________________________________________

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

        public void llenartensionArterial()
        {

            TensionArterial.add(Integer.parseInt(txtTension.getText()));

            System.out.println(TensionArterial.toString());
            System.out.println(TensionArterial.size());

        }

    //_______________Paso de Valores a Ventanas Modificado a Registro la embarazada con tension arterial________________


    @FXML
    public void recibeparametrosten (float entero)
    {
        //txtTension.setText(String.valueOf(entero));
        Tension = entero;

    }

    @FXML
    private void llamar_Adicionales() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Adicionales.fxml").openStream());
        Adicionales RegistroInstancia = (Adicionales)loader.getController();


        RegistroInstancia.recibeparametros(StageRcontroller,69);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }



    //_______________Paso de Valores a Ventanas Modificado a Registro la embarazada con diabetes________________________


    @FXML
    public void recibeparametrosdia (float entero)
    {
        //txtPTG.setText(String.valueOf(entero));
        Glucosa = entero;

    }

    @FXML
    private void llamar_AdicionalesDiab() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("AdicionalesD.fxml").openStream());
        AdicionalesD RegistroInstancia = (AdicionalesD) loader.getController();


        RegistroInstancia.recibeparametros(StageRcontroller,69);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    //_________________________________________Paso de Valores a Ventanas y cierra la ventana___________________________

        @FXML
        void cerrar()
        {

            if(radTension.isSelected())
            {



                EHipertension embten = new EHipertension(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,TensionArterial,Tension);
                System.out.println(embten.toString());
                stage1_controller_en_stage2.recibeparametros(embten);
                Stage stage = (Stage) btnNext.getScene().getWindow();
                stage.close();
            }
            if(radDiabetes.isSelected())
            {
                EDiabetes embdia = new EDiabetes(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtPTG.getText()),Glucosa);
                System.out.println(embdia.toString());
                stage1_controller_en_stage2.recibeparametros(embdia);
                Stage stage = (Stage) btnNext.getScene().getWindow();
                stage.close();
            }

            if(radMenor.isSelected())
            {
                EJoven embjov = new EJoven(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtEdad.getText()));
                System.out.println(embjov.toString());
                stage1_controller_en_stage2.recibeparametros(embjov);
                Stage stage = (Stage) btnNext.getScene().getWindow();
                stage.close();
            }

            if(radMayor.isSelected())
            {
                EMayor embmay =  new EMayor(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,cmbAmeno.getSelectionModel().getSelectedItem().toString());
                // cmbAmeno.getValue()
                System.out.println(embmay.toString());
                stage1_controller_en_stage2.recibeparametros(embmay);
                Stage stage = (Stage) btnNext.getScene().getWindow();
                stage.close();
            }





           // EHipertension embten = new EHipertension("Sebas",12,exmas,15);
           // stage1_controller_en_stage2.recibeparametros(embten);
            //Stage stage = (Stage) btnNext.getScene().getWindow();
           // stage.close();

        }


    //____________________________________Se termina Paso de Datos______________________________________________________




    public void showexamenes()
    {
        btnNext.setVisible(true);
        lblinstruc.setVisible(true);
        radDiabetes.setVisible(true);
        radMayor.setVisible(true);
        radMenor.setVisible(true);
        radTension.setVisible(true);
        btnShowexam.setVisible(false);



    }

    public void radiosSelect (ActionEvent event)
    {
        if(radTension.isSelected())
        {
            lblTension.setVisible(true);
            lblTension2.setVisible(true);
            txtTension.setVisible(true);
            btnAgregarTensiones.setVisible(true);
            //________________________________
            lbledad.setVisible(false);
            lbledad2.setVisible(false);
            txtEdad.setVisible(false);
            lblamneo.setVisible(false);
            cmbAmeno.setVisible(false);
            lblPTG.setVisible(false);
            lblPTG2.setVisible(false);
            txtPTG.setVisible(false);

        }

        if(radMenor.isSelected())
        {
            lbledad.setVisible(true);
            lbledad2.setVisible(true);
            txtEdad.setVisible(true);
            //________________________________
            lblTension.setVisible(false);
            lblTension2.setVisible(false);
            txtTension.setVisible(false);
            lblamneo.setVisible(false);
            cmbAmeno.setVisible(false);
            lblPTG.setVisible(false);
            lblPTG2.setVisible(false);
            txtPTG.setVisible(false);




        }
        if(radMayor.isSelected())
        {
          lblamneo.setVisible(true);
          cmbAmeno.setVisible(true);
          //________________________________
            lblTension.setVisible(false);
            lblTension2.setVisible(false);
            txtTension.setVisible(false);
            lbledad.setVisible(false);
            lbledad2.setVisible(false);
            txtEdad.setVisible(false);
            lblPTG.setVisible(false);
            lblPTG2.setVisible(false);
            txtPTG.setVisible(false);

        }
        if(radDiabetes.isSelected())
        {
            lblPTG.setVisible(true);
            lblPTG2.setVisible(true);
            txtPTG.setVisible(true);
            //________________________________
            lblamneo.setVisible(false);
            cmbAmeno.setVisible(false);
            lblTension.setVisible(false);
            lblTension2.setVisible(false);
            txtTension.setVisible(false);
            lblTension.setVisible(false);
            lblTension2.setVisible(false);
            txtTension.setVisible(false);
            lbledad.setVisible(false);
            lbledad2.setVisible(false);
            txtEdad.setVisible(false);

        }
    }

    public void AgregarExamen ()
    {
        Examen examen = new Examen(txtExamRutina.getText(),cmbExamnRutina.getValue().toString());
        exmas.add(examen);

        System.out.println(examen.toString());
        System.out.println(exmas.size());
    }


    public void AgrergarEmbarazada()
    {
        if(radTension.isSelected())
        {
            EHipertension embten = new EHipertension(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,TensionArterial,0);
            System.out.println(embten.toString());
        }

        if(radMenor.isSelected())
        {
            EJoven embjov = new EJoven(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtEdad.getText()));
            System.out.println(embjov.toString());
        }

        if(radMayor.isSelected())
        {
            EMayor embmay =  new EMayor(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,cmbAmeno.getSelectionModel().getSelectedItem().toString());
           // cmbAmeno.getValue()
            System.out.println(embmay.toString());
        }

        if(radDiabetes.isSelected())
        {
            EDiabetes embdia = new EDiabetes(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtPTG.getText()),0);
            System.out.println(embdia.toString());
        }
    }




    @FXML
    void initialize() {

        btnNext.setVisible(false);
        txtEdad.setVisible(false);
        txtPTG.setVisible(false);
        txtTension.setVisible(false);
        cmbAmeno.setVisible(false);
        lblinstruc.setVisible(false);
        lbledad.setVisible(false);
        lblPTG.setVisible(false);
        lblTension.setVisible(false);
        lblamneo.setVisible(false);
        lbledad2.setVisible(false);
        lblPTG2.setVisible(false);
        lblTension2.setVisible(false);
        radDiabetes.setVisible(false);
        radMayor.setVisible(false);
        radMenor.setVisible(false);
        radTension.setVisible(false);
        cmbExamnRutina.setItems(rutinalist);
        cmbAmeno.setItems(amneolist);
        btnAgregarTensiones.setVisible(false);




        btnagrEmbarazada.setOnAction((event) -> {
            AgregarExamen();
        });


        btnShowexam.setOnAction((event) -> {
            showexamenes();
        });

        btnAgregarTensiones.setOnAction((event) -> {
            llenartensionArterial();
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnNext.setVisible(false);
        txtEdad.setVisible(false);
        txtPTG.setVisible(false);
        txtTension.setVisible(false);
        cmbAmeno.setVisible(false);
        lblinstruc.setVisible(false);
        lbledad.setVisible(false);
        lblPTG.setVisible(false);
        lblTension.setVisible(false);
        lblamneo.setVisible(false);
        lbledad2.setVisible(false);
        lblPTG2.setVisible(false);
        lblTension2.setVisible(false);
        radDiabetes.setVisible(false);
        radMayor.setVisible(false);
        radMenor.setVisible(false);
        radTension.setVisible(false);
        cmbExamnRutina.setItems(rutinalist);
        cmbAmeno.setItems(amneolist);
        btnAgregarTensiones.setVisible(false);

        StageRcontroller=this;


        btnAgregarTensiones.setOnAction((event) -> {
            llenartensionArterial();
        });


        btnagrEmbarazada.setOnAction((event) -> {
            AgregarExamen();
        });

        btnShowexam.setOnAction((event) -> {
            showexamenes();
        });
    }
}


