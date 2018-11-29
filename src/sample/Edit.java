package sample;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class Edit {
    ArrayList<Embarazada> emb = new ArrayList<>();
    ObservableList<Embarazada> Oembjoven = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oemb = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oembmayor = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oembdiabetes = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oembtension = FXCollections.observableArrayList(emb);
    ObservableList<Embarazada> Oembeditado = FXCollections.observableArrayList(emb);

    Controller stage1_controller_en_stage2;


    @FXML
    private Button btnclose;
    @FXML
    private TableView<Embarazada> tblvwjoven;
    @FXML
    private TableColumn<Embarazada,String> Nombrejovencolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicajovencolumn;
    @FXML
    private TableColumn<Embarazada,String> Examenjovencolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Edadjovencolumn;
    @FXML
    private TableView<Embarazada> tblvwmayor;
    @FXML
    private TableColumn<Embarazada,String> Nombremayorcolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicamayorcolumn;
    @FXML
    private TableColumn<Embarazada,String> Examenmayorcolumn;
    @FXML
    private TableColumn<Embarazada,String> Amneosentesismayorcolumn;
    @FXML
    private TableView<Embarazada> tblvwDiabetica;
    @FXML
    private TableColumn<Embarazada,String> Nombrediacolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicadiacolumn;
    @FXML
    private TableColumn<Embarazada,String> Examendiacolumn;
    @FXML
    private TableColumn<Embarazada,Float> PTGdiacolumn;
    @FXML
    private TableColumn<Embarazada,Float> Glucosadiacolumn;

    @FXML
    private TableView<Embarazada> tblvwTension;
    @FXML
    private TableColumn<Embarazada,String> Nombretencolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Hclinicatencolumn;
    @FXML
    private TableColumn<Embarazada,String> Examentencolumn;
    @FXML
    private TableColumn<Embarazada,Integer> Tensiontencolumn;
    @FXML
    private TableColumn<Embarazada,Float> Pulsacionestencolumn;




    @FXML
    public void recibeparametrosEdit(Controller stage1, ArrayList emb) {

        //System.out.println("Se pasaron los datos"+emb.toString());
        // EHipertension embten = new EHipertension("Sebas",12,exmas,15,TensionArterial,1);
        //emb = embten;
        stage1_controller_en_stage2 = stage1;
        Oemb.addAll(emb);
        EDiabetes ed = new EDiabetes();
        EJoven ej = new EJoven();
        EMayor em = new EMayor();
        EHipertension eh = new EHipertension();

        for (int i = 0; i < emb.size(); i++) {

            if (emb.get(i).getClass().isInstance(ed)== true) {
                Oembdiabetes.add(Oemb.get(i));
            }
            if (emb.get(i).getClass().isInstance(ej)== true) {
                Oembjoven.add(Oemb.get(i));
            }
            if (emb.get(i).getClass().isInstance(em)== true) {
                Oembmayor.add(Oemb.get(i));
            }
            if (emb.get(i).getClass().isInstance(eh)== true) {
                Oembtension.add(Oemb.get(i));
            }

            //System.out.println("Se pasaron los datos" + Oembeditado.toString());
            //System.out.println("tensiioooon" +  Oembtension.toString());

        }
    }


    @FXML
    public void recibeparametrosResEmb(Controller stage1, ArrayList embara) {
        // txtprueba.setText(texto);
        // emb.add(embara);
        //emb = (ArrayList) embara.clone();

        for (int i = 0; i < embara.size(); i++) {
            Oemb.add((Embarazada) embara.get(i));
        }
        System.out.println(embara.toString());
        stage1_controller_en_stage2 = stage1;

    }


    public void cerrar()
    {
        Oembeditado.addAll(Oembjoven);
        Oembeditado.addAll(Oembmayor);
        Oembeditado.addAll(Oembdiabetes);
        Oembeditado.addAll(Oembtension);


        System.out.println("Editados" + Oembeditado.toString());
        stage1_controller_en_stage2.recibeparametroseditado(Oembeditado);
        Stage stage = (Stage) btnclose.getScene().getWindow();
        stage.close();
    }
    //_______________________________________Joven______________________________________________________________________



    public void changeNamejoven(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwjoven.getSelectionModel().getSelectedItem();
        personselected.setNombre(edittedCell.getNewValue().toString());
    }
    public void changeClinicajoven(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwjoven.getSelectionModel().getSelectedItem();
        personselected.setHclinica(Integer.parseInt(edittedCell.getNewValue().toString()));
    }
    public void changeexamenesjoven(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwjoven.getSelectionModel().getSelectedItem();
        //personselected.setListexamen(edittedCell.getNewValue().toString()));
    }
    public void changeedadjoven(TableColumn.CellEditEvent edittedCell)
    {
        EJoven personselected = (EJoven) tblvwjoven.getSelectionModel().getSelectedItem();
        personselected.setEdad(Integer.parseInt(edittedCell.getNewValue().toString()));
    }



    //_______________________________________Mayor______________________________________________________________________


    public void changeNamemayor(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwmayor.getSelectionModel().getSelectedItem();
        personselected.setNombre(edittedCell.getNewValue().toString());
    }
    public void changeClinicamayor(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwmayor.getSelectionModel().getSelectedItem();
        personselected.setHclinica(Integer.parseInt(edittedCell.getNewValue().toString()));
    }
    public void changeexamenesmayor(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwmayor.getSelectionModel().getSelectedItem();
        //personselected.setListexamen(edittedCell.getNewValue().toString()));
    }
    public void changeAmneomayor(TableColumn.CellEditEvent edittedCell)
    {
        EMayor personselected = (EMayor) tblvwmayor.getSelectionModel().getSelectedItem();
        personselected.setAmneosentesis(edittedCell.getNewValue().toString());
    }


//_______________________________________Diabetes______________________________________________________________________


    public void changeNamediabetes(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwDiabetica.getSelectionModel().getSelectedItem();
        personselected.setNombre(edittedCell.getNewValue().toString());
    }
    public void changeClinicadiabetes(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwDiabetica.getSelectionModel().getSelectedItem();
        personselected.setHclinica(Integer.parseInt(edittedCell.getNewValue().toString()));
    }
    public void changeexamenesdiabetes(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwDiabetica.getSelectionModel().getSelectedItem();
        //personselected.setListexamen(edittedCell.getNewValue().toString()));
    }
    public void changeglucosadiabetes(TableColumn.CellEditEvent edittedCell)
    {
        EDiabetes personselected = (EDiabetes) tblvwDiabetica.getSelectionModel().getSelectedItem();
        personselected.setGlucosa(Float.parseFloat(edittedCell.getNewValue().toString()));
    }
    public void changePTGdiabetes(TableColumn.CellEditEvent edittedCell)
    {
        EDiabetes personselected = (EDiabetes) tblvwDiabetica.getSelectionModel().getSelectedItem();
        personselected.setPTG(Float.parseFloat(edittedCell.getNewValue().toString()));
    }


    //_______________________________________Hipertensas______________________________________________________________________


    public void changeNameten(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwTension.getSelectionModel().getSelectedItem();
        personselected.setNombre(edittedCell.getNewValue().toString());
    }
    public void changeClinicaten(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwTension.getSelectionModel().getSelectedItem();
        personselected.setHclinica(Integer.parseInt(edittedCell.getNewValue().toString()));
    }
    public void changeexamenesten(TableColumn.CellEditEvent edittedCell)
    {
        Embarazada personselected = tblvwTension.getSelectionModel().getSelectedItem();
        //personselected.setListexamen(edittedCell.getNewValue().toString()));
    }
    public void changetenTension(TableColumn.CellEditEvent edittedCell)
    {
        EHipertension personselected = (EHipertension) tblvwTension.getSelectionModel().getSelectedItem();
       // personselected.setTensionArterial(Integer.parseInt(edittedCell.getNewValue().toString()));
    }
    public void changetenPuls(TableColumn.CellEditEvent edittedCell)
    {
        EHipertension personselected = (EHipertension) tblvwTension.getSelectionModel().getSelectedItem();
        personselected.setPulsaciones(Integer.parseInt(edittedCell.getNewValue().toString()));
    }








    @FXML
    void initialize() {

        Nombrejovencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicajovencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examenjovencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        Edadjovencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Edad"));

        tblvwjoven.setItems(Oembjoven);
        tblvwjoven.setEditable(true);
        Nombrejovencolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Hclinicajovencolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //Examenjovencolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Edadjovencolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));


        Nombremayorcolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicamayorcolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examenmayorcolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        Amneosentesismayorcolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Amneosentesis"));

        tblvwmayor.setItems(Oembmayor);
        tblvwmayor.setEditable(true);
        Nombremayorcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Hclinicamayorcolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
       // Examenmayorcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Amneosentesismayorcolumn.setCellFactory(TextFieldTableCell.forTableColumn());


        Nombrediacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicadiacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examendiacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        PTGdiacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Float>("PTG"));
        Glucosadiacolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Float>("Glucosa"));

        tblvwDiabetica.setItems(Oembdiabetes);
        tblvwDiabetica.setEditable(true);
        Nombrediacolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Hclinicadiacolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //Examendiacolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PTGdiacolumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        Glucosadiacolumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));



        Nombretencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("Nombre"));
        Hclinicatencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("Hclinica"));
        Examentencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, String>("listexamen"));
        Tensiontencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Integer>("TensionArterial"));
        Pulsacionestencolumn.setCellValueFactory(new PropertyValueFactory<Embarazada, Float>("Pulsaciones"));

        tblvwTension.setItems(Oembtension);
        tblvwTension.setEditable(true);
        Nombretencolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        Hclinicatencolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //Examentencolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //Tensiontencolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Pulsacionestencolumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));



    }


    }
