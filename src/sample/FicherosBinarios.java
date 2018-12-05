package sample;

import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FicherosBinarios {

    public FicherosBinarios() {
    }

    public void escribir_binario(ObjectOutputStream oos,ArrayList arr){
       // File fichero = new File("Embarazadas.bin");



        try {
            String str = Arrays.toString(arr.toArray());
            System.out.println(str);
            oos.writeUTF(str +"\n" + "\n");
            oos.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }


/*
        try {
            //fos = new FileOutputStream(fichero,true);

            //oos = new ObjectOutputStream(fos);

            oos.writeUTF("Hola");
            // oos.writeUTF();
            // oos.writeUTF(Oemb.toString()+"\n" + Diabetes.toString());


        } catch (FileNotFoundException e) {
            System.out.println("Error en la localizacion del archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        }
*/
    }

    public void leer_binario() throws IOException {

        //FileInputStream fis;
        //ObjectInputStream ois;
       // DataInputStream dis;
        FileInputStream fis =  new FileInputStream("Embarazadas.bin");
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (ois.available()>0) {
            try {
                String k = ois.readUTF();
                System.out.println(k);
            } catch (IOException e) {
                System.out.println(e);
                //e.printStackTrace();
            }
        }
/*
            try {
                while (true)
                System.out.println(ois.readUTF());

            } catch (IOException e) {

                System.out.println(e);
                //e.printStackTrace();
            }

            */
        }

/*


        try {
            //fis =  new FileInputStream("Embarazadas.bin");
            //ois =  new ObjectInputStream(fis);


            System.out.println("Listado de Embarazadas");
            System.out.println(ois.readUTF());




        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la manipulacion del archivo");
            e.printStackTrace();
        }
*/

    }




