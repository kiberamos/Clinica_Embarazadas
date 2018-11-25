package sample;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class EMayor extends Embarazada {


    SimpleStringProperty amneosentesis;

    @Override
    public boolean getRiesgos ()
    {
        if (getAmneosentesis().equals("Positivo"))
        {
            return true;
        }else{
            return false;
        }


    }

    EMayor ()
    {

    }

    EMayor (String nombre, int hclinica, ArrayList <Examen> listexamen)
    {
        super (nombre, hclinica, listexamen);
    }

    EMayor (String nombre, int hclinica, ArrayList <Examen> listexamen, String pamneosentesis )
    {
        super (nombre, hclinica, listexamen);
        amneosentesis = new SimpleStringProperty(pamneosentesis);
    }

    public String getNombre ()
    {
        
        return super.getNombre();
    
    }
    public void setNombre (String pnombre)
    {
        super.setNombre(pnombre);
    }

    public int getHclinica()
    {
        return super.getHclinica();
    }

    public void setHclinica (int pHclinica)
    {
        super.setHclinica(pHclinica);
    }


    public ArrayList<Examen> getListexamen() {
        return super.getListexamen();
    }

    public void setListexamen(ArrayList<Examen> plistexamen) {
        super.setListexamen(plistexamen);
    }


    public SimpleStringProperty amneosentesisProperty() {
        return amneosentesis;
    }

    public void setAmneosentesis(String amneosentesis) {
        this.amneosentesis.set(amneosentesis);
    }

    public String getAmneosentesis() {
        return amneosentesis.get();
    }

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Examen Amneosentesis : " + getAmneosentesis();

        return String;
    }
}
