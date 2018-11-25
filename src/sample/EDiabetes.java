package sample;

import java.util.ArrayList;

public class EDiabetes extends Embarazada implements ExamenesAdicionales {

    private float PTG;
    private float Glucosa;

    public EDiabetes ()
    {

    }

    public EDiabetes (String Nombre, int Hclinica, ArrayList <Examen> listexamen,float pPTG,float pGlucosa)
    {
        super (Nombre,Hclinica,listexamen);
        PTG = pPTG;
        Glucosa = pGlucosa;

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

    public void setPTG (float pPTG)
    {
        PTG = pPTG;
    }

    public float getPTG()
    {
        return PTG;
    }

    @Override
    public boolean getRiesgos ()
    {
        return PTG > 4.4;
    }

    @Override
    public void agrExamen (float pglucosa)
    {
        Glucosa= pglucosa;
    }

    @Override
    public float getagrExamen ()
    {
        return Glucosa;
    }

    public float getGlucosa() {
        return Glucosa;
    }

    public void setGlucosa(float glucosa) {
        Glucosa = glucosa;
    }

    @Override
    public String getCondicion(){return "Diabetica";}

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Examen PTG : " + getPTG() + "Valor del Examen Adicional: " + getGlucosa() ;

        return String;
    }

}
