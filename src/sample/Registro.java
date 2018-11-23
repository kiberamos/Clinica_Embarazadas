package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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


    //____________________________________Paso de Datos_________________________________________________________________

        Controller stage1_controller_en_stage2;

        @FXML
        public void recibeparametros(Controller stage1,String texto)
        {

            txtNombre.setText(texto);
            EHipertension embten = new EHipertension("Sebas",12,exmas,15);
            //emb = embten;
            stage1_controller_en_stage2 = stage1;
        }

        @FXML
        void cerrar()
        {



            EHipertension embten = new EHipertension("Sebas",12,exmas,15);
            stage1_controller_en_stage2.recibeparametros(embten);
            Stage stage = (Stage) btnNext.getScene().getWindow();
            stage.close();

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
            EHipertension embten = new EHipertension(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtTension.getText()));
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
            EDiabetes embdia = new EDiabetes(txtNombre.getText(),Integer.valueOf(txtHclinica.getText()),exmas,Integer.parseInt(txtPTG.getText()));
            System.out.println(embdia.toString());
        }
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
