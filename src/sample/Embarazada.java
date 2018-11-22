package sample;

import java.util.ArrayList;

public abstract class Embarazada {

    private String Nombre;
    private int Hclinica;
    private ArrayList <Examen> listexamen = new ArrayList<>();

    public Embarazada ()
    {

    }
    public Embarazada (String pNombre, int pHclinica)
    {
        Nombre = pNombre;
        Hclinica = pHclinica;
    }
    public Embarazada (String pNombre, int pHclinica, ArrayList<Examen> plistexamen)
    {
        Nombre = pNombre;
        Hclinica = pHclinica;
        listexamen.addAll(plistexamen);
    }


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
