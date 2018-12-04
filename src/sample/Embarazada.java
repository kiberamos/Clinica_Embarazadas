package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Embarazada implements Serializable {


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getHclinica() {
        return Hclinica;
    }

    public void setHclinica(int hclinica) {
        Hclinica = hclinica;
    }



    // private SimpleStringProperty Nombre;
   // private SimpleIntegerProperty Hclinica;
    private String Nombre;


    private int Hclinica;
    private ArrayList <Examen> listexamen = new ArrayList<>();

    public Embarazada ()
    {

    }
    public Embarazada (String pNombre, int pHclinica)
    {
        //Nombre = new SimpleStringProperty(pNombre);
        //Hclinica = new SimpleIntegerProperty(pHclinica);
        Nombre = pNombre;
        Hclinica = pHclinica;
    }
    public Embarazada (String pNombre, int pHclinica, ArrayList<Examen> plistexamen)
    {
        //Nombre = new SimpleStringProperty(pNombre);
        //Hclinica = new SimpleIntegerProperty(pHclinica);
        Nombre = pNombre;
        Hclinica = pHclinica;
        listexamen.addAll(plistexamen);
    }


/*
    public String getNombre() {
        return Nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public int getHclinica() {
        return Hclinica.get();
    }

    public SimpleIntegerProperty hclinicaProperty() {
        return Hclinica;
    }

    public void setHclinica(int hclinica) {
        this.Hclinica.set(hclinica);
    }

    */


    public ArrayList<Examen> getListexamen() {
        return listexamen;
    }

    public void setListexamen(ArrayList<Examen> plistexamen) {
        this.listexamen = plistexamen;
    }

    public void setListexamen (Examen plistexamen)
    {
        listexamen.add(plistexamen);
    }

    abstract boolean getRiesgos();

}
