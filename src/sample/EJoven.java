package sample;

import java.util.ArrayList;

public class EJoven extends Embarazada {


    private int edad;

    EJoven()
    {

    }

    EJoven(String nombre, int hclinico, ArrayList <Examen> listexamen, int pedad)
    {
    super(nombre,hclinico,listexamen);
        edad = pedad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean getRiesgos ()
    {
        return edad<=18 && edad >=16;
    }

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = "Nombre de Embarazada: " + getNombre() + " Numero de Clinica: " + getHclinica() + " Lista de Examenes: " + getListexamen() + " Edad: " + getEdad();

        return String;
    }

}
