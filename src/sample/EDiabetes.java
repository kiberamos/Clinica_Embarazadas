package sample;

import javafx.beans.property.SimpleFloatProperty;

import java.util.ArrayList;

public class EDiabetes extends Embarazada{

    private SimpleFloatProperty PTG;
    private SimpleFloatProperty Glucosa;

    public EDiabetes ()
    {

    }

    public EDiabetes (String Nombre, int Hclinica, ArrayList <Examen> listexamen,float pPTG,float pGlucosa) throws MyException {
        super(Nombre, Hclinica, listexamen);
        if (pPTG <= 0) {
            throw new MyException("El PTG no puede ser menor o igual a 0");
        } else {
            PTG = new SimpleFloatProperty(pPTG);
        }
        if (pGlucosa <= 0) {
            throw new MyException("La glucosa no puede ser menor o igual a 0");
        } else {
            Glucosa = new SimpleFloatProperty(pGlucosa);
        }
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

    public float getPTG() {
        return PTG.get();
    }

    public SimpleFloatProperty PTGProperty() {
        return PTG;
    }

    public void setPTG(float PTG) {
        this.PTG.set(PTG);
    }


    @Override
    public boolean getRiesgos ()
    {
        if (getPTG() > 4.4)
        {
            return true;
        }
        else{
            return false;
        }
    }


    public void agrExamen (float pglucosa)
    {

    }


    public SimpleFloatProperty getagrExamen ()
    {
        return Glucosa;
    }


    public float getGlucosa() {
        return Glucosa.get();
    }

    public SimpleFloatProperty glucosaProperty() {
        return Glucosa;
    }

    public void setGlucosa(float glucosa) {
        this.Glucosa.set(glucosa);
    }



    public String getCondicion(){return "Diabetica";}

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

       // String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Examen PTG : " + getPTG() + "Examen Glucosa: " + getGlucosa() + "\n" ;
        String = "Nombre de la Embarazada: " + getNombre() + " Examen de Glucosa: " + getGlucosa()+ "\n" ;

        return String;
    }

    public String toStringR()
    {
        String String;

        String = "Nombre de la Embarazada: " + getNombre() + " Examen de Glucosa: " + getGlucosa();
        return String;
    }

}
