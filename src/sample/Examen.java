package sample;

import javafx.beans.property.SimpleStringProperty;

public class Examen {

    private SimpleStringProperty Nombre;
    private SimpleStringProperty resultado;

    Examen ()
    {

    }

    Examen(String pNombre, String presultado)
    {
        Nombre = new SimpleStringProperty(pNombre);
        resultado = new SimpleStringProperty(presultado);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public String getResultado() {
        return resultado.get();
    }

    public SimpleStringProperty resultadoProperty() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado.set(resultado);
    }

    public String toString()
    {
        String String;

        //String = Integer.toString(getId()) + " " + getName() + " " + getClinicHistory() + " " + Integer.toString(getAge()) + " " + getDiabetes() + " " + Integer.toString(getBloodPreasure());

        String = getNombre() + " " + getResultado();

        return String;
    }

}
