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

    @Override
    public boolean getRiesgos ()
    {
        return edad<=18 && edad >=16;
    }

}
