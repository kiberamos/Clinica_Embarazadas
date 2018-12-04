package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class EHipertension extends Embarazada implements ExamenesAdicionales, Serializable {

   // private int TensionArterial;
    private ArrayList <Integer> TensionArterial = new ArrayList<>();

    public Float getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(Float pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    //SimpleFloatProperty pulsaciones;
    Float pulsaciones;



    EHipertension()
    {

    }

    EHipertension(String Nombre, int Hclinica, ArrayList<Examen> listexamen, ArrayList<Integer> pTensionArterial, float ppulsaciones) throws MyException {
        super(Nombre,Hclinica,listexamen);
        for (int i = 0; i < pTensionArterial.size(); i++) {
        if (pTensionArterial.get(i) <= 0) {
            throw new MyException("La presion Arterial no puede ser menor o igual a 0");
            } else{
            TensionArterial = pTensionArterial;
            }
        }
        if (ppulsaciones <= 0){
            throw new MyException("Las pulsaciones de una persona no pueden ser menor o igual a 0");
        }else {
            //pulsaciones = new SimpleFloatProperty(ppulsaciones);
            pulsaciones = ppulsaciones;
        }

    }



    public String getNombre ()
    {

        return super.getNombre();

    }

    public ArrayList<Integer> getTensionArterial() {
        return TensionArterial;
    }

    public void setTensionArterial(ArrayList<Integer> tensionArterial) {
        TensionArterial = tensionArterial;
    }

/*

    public float getPulsaciones() {
        return pulsaciones.get();
    }

    public SimpleFloatProperty pulsacionesProperty() {
        return pulsaciones;
    }

    public void setPulsaciones(float pulsaciones) {
        this.pulsaciones.set(pulsaciones);
    }
*/

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


    @Override
    boolean getRiesgos ()
    {
        for (int i = 0; i < getTensionArterial().size(); i++) {

            if (getTensionArterial().get(i)>90)
            {
                return true;
            } else
            {
                return false;
            }

        }

        return true;
       //return TensionArterial > 90 ;
    }
    @Override
    public void agrExamen (Float ppulsaciones)
    {
        pulsaciones = ppulsaciones;
    }




    @Override
    public Float getagrExamen ()
    {
        return pulsaciones;
    }

    @Override
    public String getCondicion()
    {
        return "Hipertensa";
    }

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Tension Arterial: " + getTensionArterial() + " Examen Pulsaciones:  " + getPulsaciones() + "\n";
        //String = "Nombre de la Embarazada: " + getNombre() + " Examen de Pulsaciones: " + getPulsaciones()+ "\n" ;
        return String;
    }

    public String toStringR()
    {
        String String;

        String = "Nombre de la Embarazada: " + getNombre() + " Examen de Pulsaciones: " + getPulsaciones();
        return String;
    }


}
