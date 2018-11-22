package sample;

import java.util.ArrayList;

public class EDiabetes extends Embarazada implements ExamenesAdicionales {

    private float PTG;
    private float Glucosa;

    public EDiabetes ()
    {

    }

    public EDiabetes (String Nombre, int Hclinica, ArrayList <Examen> listexamen,int pPTG)
    {
        super (Nombre,Hclinica,listexamen);
        PTG = pPTG;

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

    @Override
    public String getCondicion(){return "Diabetica";}

}
