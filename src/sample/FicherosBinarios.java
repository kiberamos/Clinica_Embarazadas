package sample;

import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class FicherosBinarios {

    public FicherosBinarios() {
    }

    public void escribir_binario(ArrayList NumerosRiesgo,ArrayList Diabetes,ArrayList NumerosRiesgomay,ArrayList mayor,ArrayList Extrass){
        File fichero = new File("Embarazadas.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(fichero,true);

            oos = new ObjectOutputStream(fos);

            oos.writeUTF("Bienvenido a la Lectura del Archivo Binario" + "\n" + "\n" + "\n"+
                    "1) Cantidad de embarazadas que se consideran en riesgo: " + "\n" + NumerosRiesgo.toString() + "\n" + "\n"+
                    "2) Obtener el listado de las embarazadas diabéticas:" + "\n" + Diabetes.toString() + "\n" + "\n"+
                    "3) Del total de embarazadas en riesgo cuántas tienen más de 35 años: " + "\n" +  NumerosRiesgomay.toString() + "\n" + "\n" +
                    "4) Obtener el número de historia clínica de la embarazada diabética con mayor PTG: "  + "\n" + mayor.toString() + "\n" + "\n" +
                    "5) Imprimir el valor del chequeo extra realizado de todas las embarazadas del tipo diabética y de presión arterial alta:" + "\n" +  Extrass.toString() + "\n"
            );
            // oos.writeUTF();
            // oos.writeUTF(Oemb.toString()+"\n" + Diabetes.toString());

            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error en la localizacion del archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        }

    }

    public void leer_binario(){

        FileInputStream fis;
        ObjectInputStream ois;
        DataInputStream dis;


        try {
            fis =  new FileInputStream("Embarazadas.bin");
            ois =  new ObjectInputStream(fis);


            System.out.println("Listado de Embarazadas");
            System.out.println(ois.readUTF());




        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        }


    }



}