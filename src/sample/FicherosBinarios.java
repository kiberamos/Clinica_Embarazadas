package sample;

import java.io.*;
import java.util.ArrayList;

public class FicherosBinarios {

    public FicherosBinarios() {
    }



    public void escribir_embarazada(ArrayList arr)
    {
        ArrayList aList = new ArrayList();
        File file;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        file = new File("Embarazadas.bin");
        aList.addAll(arr);



        String friend = " ";


        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            int sz = aList.size();

            for (int i = 0; i < sz; i++) {

                objectOutputStream.writeObject(aList.get(i).toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }


    }

    public void leer_embarazada()
    {
        String line;
        ArrayList aList = new ArrayList();

        File file;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;

        file = new File("Embarazadas.bin");


        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true)
            {

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0;i < aList.size(); i++)
        {
            System.out.println(aList.get(i).toString());
        }


    }


}