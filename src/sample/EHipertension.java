package sample;

import java.beans.BeanProperty;
import java.util.ArrayList;

public class EHipertension extends Embarazada implements ExamenesAdicionales {

    private int TensionArterial;
    float pulsaciones;

    EHipertension()
    {

    }

    EHipertension(String Nombre, int Hclinica, ArrayList<Examen> listexamen, int pTensionArterial)
    {
        super(Nombre,Hclinica,listexamen);
        TensionArterial = pTensionArterial;

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

    public int getTensionArterial ()
    {
        return TensionArterial;
    }

    public void setTensionArterial (int pTensionArterial)
    {
        TensionArterial = pTensionArterial;
    }

    @Override
    boolean getRiesgos ()
    {
        return TensionArterial > 90 ;
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

}
