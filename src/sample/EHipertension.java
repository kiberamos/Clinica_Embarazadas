package sample;

import java.beans.BeanProperty;
import java.util.ArrayList;

public class EHipertension extends Embarazada implements ExamenesAdicionales {

   // private int TensionArterial;
    private ArrayList <Integer> TensionArterial = new ArrayList<>();
    float pulsaciones;


    EHipertension()
    {

    }

    EHipertension(String Nombre, int Hclinica, ArrayList<Examen> listexamen, ArrayList<Integer> pTensionArterial, float ppulsaciones)
    {
        super(Nombre,Hclinica,listexamen);
        TensionArterial = pTensionArterial;
        pulsaciones = ppulsaciones;

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

    public float getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(float pulsaciones) {
        this.pulsaciones = pulsaciones;
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


    @Override
    boolean getRiesgos ()
    {
        return true;
       //return TensionArterial > 90 ;
    }

    public void agrExamen (float ppulsaciones)
    {
        pulsaciones = ppulsaciones;
    }

    @Override
    public float getagrExamen ()
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

        String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Tension Arterial: " + getTensionArterial() + "Valor del Examen Adicional: " + getPulsaciones();

        return String;
    }


}
