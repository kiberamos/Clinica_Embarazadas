package sample;

import javafx.beans.property.SimpleFloatProperty;

public interface ExamenesAdicionales {


    public void agrExamen (SimpleFloatProperty value);

    SimpleFloatProperty getagrExamen ();

    String getCondicion();

}
