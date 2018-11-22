package sample;

public class Examen {

    private String Nombre;
    private String resultado;

    Examen ()
    {

    }

    Examen(String pNombre, String presultado)
    {
        Nombre = pNombre;
        resultado = presultado;
    }

    String getNombre ()
    {
        return Nombre;
    }

    String getResultado ()
    {
        return resultado;
    }

    public void setNombre (String pNombre)
    {
        Nombre = pNombre;
    }
    public void setResultado (String presultado)
    {
        resultado = presultado;
    }

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = getNombre() + " " + getResultado();

        return String;
    }

}
